package com.axiastudio.scrabbler.engine;

import com.axiastudio.scrabbler.bag.Bag;
import com.axiastudio.scrabbler.bag.BagFactory;
import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.board.BoardFactory;
import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.commons.Square;
import com.axiastudio.scrabbler.dictionary.Dictionary;
import com.axiastudio.scrabbler.dictionary.DictionaryFactory;
import com.axiastudio.scrabbler.dictionary.Pattern;

import java.util.List;
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
        board.placeLetterAtPosition(new Position(x, y), letter);
    }

    public List<Pattern> findSolutions(String lettersInYourHand) {
        List<Pattern> possiblesPatterns = board.findPossiblesPatterns();
        List<Pattern> solutions = possiblesPatterns.stream()
                .map(pattern -> discoverWordsByLettersAndPattern(lettersInYourHand, pattern))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return solutions;
    }

    public Bag getBag() {
        return bag;
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

}