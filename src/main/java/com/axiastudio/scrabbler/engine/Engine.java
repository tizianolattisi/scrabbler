package com.axiastudio.scrabbler.engine;

import com.axiastudio.scrabbler.bag.Bag;
import com.axiastudio.scrabbler.bag.BagFactory;
import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.board.BoardFactory;
import com.axiastudio.scrabbler.core.*;
import com.axiastudio.scrabbler.dictionary.Dictionary;
import com.axiastudio.scrabbler.dictionary.DictionaryFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Engine {

    private Board board;
    private Dictionary dictionary;
    private Bag bag;

    public Engine(BoardFactory boardFactory, DictionaryFactory dictionaryFactory, BagFactory bagFactory) {
        board = boardFactory.buildAndInitialize();
        dictionary = dictionaryFactory.buildAndInitialize();
        bag = bagFactory.buildAndInitialize();
    }

    public void placeLetter(Integer x, Integer y, String letter) {
        board.placeTileAtPosition(new Position(x, y), bag.extractTileByLetter(letter));
    }

    public void placeLetters(String[] rowsOfLetters) {
        assert rowsOfLetters.length==board.size();
        for (int j=0; j<board.size(); j++) {
            String rowOfLetters = rowsOfLetters[j];
            assert rowOfLetters.length()==board.size();
            for (int i=0; i<board.size(); i++) {
                String letter = String.valueOf(rowOfLetters.charAt(i));
                if (isALetter(letter)) {
                    placeLetter(i, j, letter);
                }
            }
        }
    }

    private Boolean isALetter(String maybeALetter) {
        return !" ".equals(maybeALetter);
    }

    public List<Pattern> findSolutions(String lettersInYourHand) {
        List<Pattern> possiblesPatterns = board.findPossiblesPatterns();
        return possiblesPatterns.stream()
                .map(pattern -> discoverWordsByLettersAndPattern(lettersInYourHand, pattern))
                .flatMap(List::stream)
                .filter(solution -> checkSolutionForCrossingWords(solution))
                .collect(Collectors.toList());
    }

    public List<Pattern> discoverWordsByLettersAndPattern(String letters, Pattern pattern) {
        return dictionary.words().stream()
                .filter(word -> isMatchingPattern(word, pattern))
                .filter(word -> canBeBuildWithLetters(word, letters, pattern))
                .map(word -> pattern.createNewPatternWithSameSquares().placeWord(word))
                .collect(Collectors.toList());
    }

    private Boolean isMatchingPattern(String word, Pattern pattern) {
        if (word.length()!=pattern.length()) {
            return Boolean.FALSE;
        }
        for (int i = 0; i<pattern.length(); i++) {
            Square square = pattern.getSquare(i);
            char letter = word.charAt(i);
            if (!fitInSquare(square, letter)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    private boolean fitInSquare(Square square, char letter) {
        return square.isEmpty() || square.getTile().letter().charAt(0) == letter;
    }

    private Boolean canBeBuildWithLetters(String word, String letters, Pattern pattern) {
        for (int i=0; i<pattern.length(); i++) {
            Square actualSquare = pattern.getSquare(i);
            String actualLetter = String.valueOf(word.charAt(i));
            if (actualSquare.isEmpty()) {
                if (letters.contains(actualLetter)) {
                    letters = removeLetter(letters, actualLetter);
                } else {
                    return Boolean.FALSE;
                }
            } else if (!actualSquare.getTile().letter().equals(actualLetter)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    private String removeLetter(String letters, String actualLetter) {
        StringBuilder stringBuilder = new StringBuilder(letters);
        stringBuilder.deleteCharAt(letters.indexOf(actualLetter));
        letters = stringBuilder.toString();
        return letters;
    }

    private Boolean checkSolutionForCrossingWords(Pattern solution) {
        assert solution.orientation().isPresent();
        assert solution.position().isPresent();
        Orientation orientation = solution.orientation().get();
        Position position = solution.position().get();
        Boolean validSolution = Boolean.TRUE;
        if (Orientation.HORIZONTAL.equals(orientation)) {

            for (int i=0; i<solution.length()-1; i++) {
                Integer x = position.getX()+i;
                Integer y = Integer.valueOf(position.getY());
                String centralLetter = solution.getSquare(i).getTile().letter();
                Optional<String> crossingWord = findCrossingWord(centralLetter, new Position(x, y), Orientation.HORIZONTAL);
                if (crossingWord.isPresent()) {
                    validSolution = validSolution && dictionary.checkWordExistence(crossingWord.get());
                }
            }
        }
        if (Orientation.VERTICAL.equals(orientation)) {
            for (int j=0; j<solution.length()-1; j++) {
                Integer x = Integer.valueOf(position.getX());
                Integer y = position.getY()+j;
                String centralLetter = solution.getSquare(j).getTile().letter();
                Optional<String> crossingWord = findCrossingWord(centralLetter, new Position(x, y), Orientation.VERTICAL);
                if (crossingWord.isPresent()) {
                    validSolution = validSolution && dictionary.checkWordExistence(crossingWord.get());
                }
            }
        }
        return validSolution;
    }

    private Optional<String> findCrossingWord(String centralLetter, Position position, Orientation orientation) {
        String crossingWord = centralLetter;
        if (Orientation.HORIZONTAL.equals(orientation)) {
            Position backwardCursor = new Position(position);
            while (board.isInBoard(backwardCursor.verticalBackwardShift())) {
                Square square = board.getSquare(backwardCursor);
                if (!square.isEmpty()) {
                    crossingWord = square.getTile().letter() + crossingWord;
                }
            }
            Position forwardCursor = new Position(position);
            while (board.isInBoard(forwardCursor.verticalForwardShift())) {
                Square square = board.getSquare(forwardCursor);
                if (!square.isEmpty()) {
                    crossingWord =  crossingWord + square.getTile().letter();
                }
            }
            if (crossingWord.length()>1) {
                return Optional.of(crossingWord);
            }
        }
        if (Orientation.VERTICAL.equals(orientation)) {
            Position backwardCursor = new Position(position);
            while (board.isInBoard(backwardCursor.horizontalBackwardShift())) {
                Square square = board.getSquare(backwardCursor);
                if (!square.isEmpty()) {
                    crossingWord = square.getTile().letter() + crossingWord;
                }
            }
            Position forwardCursor = new Position(position);
            while (board.isInBoard(forwardCursor.horizontalForwardShift())) {
                Square square = board.getSquare(forwardCursor);
                if (!square.isEmpty()) {
                    crossingWord =  crossingWord + square.getTile().letter();
                }
            }
            if (crossingWord.length()>1) {
                return Optional.of(crossingWord);
            }
        }
        return Optional.empty();
    }

    public Solution bestSolution(String lettersInMyHand) {
        List<Pattern> solutions = findSolutions(lettersInMyHand);
        List<Solution> upperBoundSolutions = findUpperBoundSolutions(solutions);
        return upperBoundSolutions.get(0);
    }

    private List<Solution> findUpperBoundSolutions(List<Pattern> solutions) {
        List<Solution> upperBoudSolutions = new ArrayList<>();
        Integer currentBound = 0;
        for (int i=0; i<solutions.size(); i++) {
            Pattern solutionToCheck = solutions.get(i);
            Integer points = calculatePoints(solutionToCheck);
            if (points>currentBound) {
                upperBoudSolutions.clear();
                upperBoudSolutions.add(new Solution(solutionToCheck, currentBound));
                currentBound = points;
            } else if (points==currentBound) {
                upperBoudSolutions.add(new Solution(solutionToCheck, currentBound));
            }
        }
        return upperBoudSolutions;
    }

    public Integer calculatePoints(Pattern solution) {
        Position cursor = new Position(solution.position().get());
        Orientation orientation = solution.orientation().get();
        Integer points = 0;
        Integer wordMultiplicator = 1;
        for (int i=0; i<solution.length(); i++) {
            Square squareAtCursor = board.getSquare(cursor);
            Tile tile = solution.getSquare(i).getTile();
            if (squareAtCursor.isMultiplicatorForLetter()) {
                points += squareAtCursor.getMultiplicator() * tile.points();
            } else {
                points += tile.points();
            }
            if (squareAtCursor.isMultiplicatorForWord()) {
                wordMultiplicator *= squareAtCursor.getMultiplicator();
            }
            if (orientation.equals(Orientation.HORIZONTAL)) {
                cursor.horizontalForwardShift();
            } else {
                cursor.verticalForwardShift();
            }
        }
        return points * wordMultiplicator;
    }

}
