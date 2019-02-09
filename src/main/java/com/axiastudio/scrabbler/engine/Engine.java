package com.axiastudio.scrabbler.engine;

import com.axiastudio.scrabbler.bag.Bag;
import com.axiastudio.scrabbler.bag.BagFactory;
import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.board.BoardFactory;
import com.axiastudio.scrabbler.core.*;
import com.axiastudio.scrabbler.dictionary.Dictionary;
import com.axiastudio.scrabbler.dictionary.DictionaryFactory;

import java.util.Comparator;
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

    public List<Solution> findSolutions(String lettersInYourHand) {
        List<Pattern> possiblesPatterns = board.findPossiblesPatterns();
        return possiblesPatterns.stream()
                .map(pattern -> discoverWordsByLettersAndPattern(lettersInYourHand, pattern))
                .flatMap(List::stream)
                .filter(pattern -> checkPatternForCrossingWords(pattern))
                .map(pattern -> new Solution(pattern, calculatePoints(pattern)))
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

    private Boolean checkPatternForCrossingWords(Pattern pattern) {
        assert pattern.orientation().isPresent();
        assert pattern.position().isPresent();
        Orientation orientation = pattern.orientation().get();
        Position position = pattern.position().get();
        Boolean validSolution = Boolean.TRUE;
        if (Orientation.HORIZONTAL.equals(orientation)) {
            for (int i=0; i<pattern.length(); i++) {
                Integer x = position.getX()+i;
                Integer y = Integer.valueOf(position.getY());
                String centralLetter = pattern.getSquare(i).getTile().letter();
                Optional<String> crossingWord = findCrossingWord(centralLetter, new Position(x, y), Orientation.HORIZONTAL);
                if (crossingWord.isPresent()) {
                    validSolution = validSolution && dictionary.checkWordExistence(crossingWord.get());
                }
            }
        }
        if (Orientation.VERTICAL.equals(orientation)) {
            for (int j=0; j<pattern.length(); j++) {
                Integer x = Integer.valueOf(position.getX());
                Integer y = position.getY()+j;
                String centralLetter = pattern.getSquare(j).getTile().letter();
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
            while (isAdjacentTile(backwardCursor.verticalBackwardShift())) {
                Square square = board.getSquare(backwardCursor);
                if (!square.isEmpty()) {
                    crossingWord = square.getTile().letter() + crossingWord;
                }
            }
            Position forwardCursor = new Position(position);
            while (isAdjacentTile(forwardCursor.verticalForwardShift())) {
                Square square = board.getSquare(forwardCursor);
                crossingWord =  crossingWord + square.getTile().letter();
            }
            if (crossingWord.length()>1) {
                return Optional.of(crossingWord);
            }
        }
        if (Orientation.VERTICAL.equals(orientation)) {
            Position backwardCursor = new Position(position);
            while (isAdjacentTile(backwardCursor.horizontalBackwardShift())) {
                Square square = board.getSquare(backwardCursor);
                crossingWord = square.getTile().letter() + crossingWord;
            }
            Position forwardCursor = new Position(position);
            while (isAdjacentTile(forwardCursor.horizontalForwardShift())) {
                Square square = board.getSquare(forwardCursor);
                crossingWord =  crossingWord + square.getTile().letter();
            }
            if (crossingWord.length()>1) {
                return Optional.of(crossingWord);
            }
        }
        return Optional.empty();
    }

    private Boolean isAdjacentTile(Position position) {
        return board.isInBoard(position) && !board.getSquare(position).isEmpty();
    }

    public Optional<Solution> bestSolution(String lettersInMyHand) {
        List<Solution> solutions = findSolutions(lettersInMyHand);
        return solutions.stream().max(Comparator.comparing(Solution::points));
    }

    private Integer calculatePoints(Pattern solution) {
        Position cursor = new Position(solution.position().get());
        Orientation orientation = solution.orientation().get();
        Integer points = 0;
        Integer wordMultiplicator = 1;
        Integer numberOfLettersInHand = 7;
        Integer bonusPoints = 0;
        for (int i=0; i<solution.length(); i++) {
            Square squareAtCursor = board.getSquare(cursor);
            Tile tile = solution.getSquare(i).getTile();
            if (squareAtCursor.isEmpty()) {
                numberOfLettersInHand--;
            }
            if (squareAtCursor.isEmpty() && squareAtCursor.isMultiplicatorForLetter()) {
                points += squareAtCursor.getMultiplicator() * tile.points();
            } else {
                points += tile.points();
            }
            if (squareAtCursor.isEmpty() && squareAtCursor.isMultiplicatorForWord()) {
                wordMultiplicator *= squareAtCursor.getMultiplicator();
            }
            if (orientation.equals(Orientation.HORIZONTAL)) {
                cursor.horizontalForwardShift();
            } else {
                cursor.verticalForwardShift();
            }
        }
        if (numberOfLettersInHand==0) {
            bonusPoints = 40;
        }
        return points * wordMultiplicator + bonusPoints;
    }

}
