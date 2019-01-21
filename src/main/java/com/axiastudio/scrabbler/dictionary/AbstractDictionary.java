package com.axiastudio.scrabbler.dictionary;

import com.axiastudio.scrabbler.commons.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDictionary implements Dictionary {

    protected List<String> words = new ArrayList<>();

    @Override
    public List<Pattern> discoverWordsByLettersAndPattern(String letters, Pattern pattern) {
        return words.stream()
                .filter(word -> isMatchingPattern(word, pattern))
                .filter(word -> canBeBuildWithLetters(word, letters, pattern))
                .map(word -> pattern.createNewPatternWithSameTiles().placeWord(word))
                .collect(Collectors.toList());
    }

    private Boolean isMatchingPattern(String word, Pattern pattern) {
        if (word.length()!=pattern.length()) {
            return Boolean.FALSE;
        }
        for (int i = 0; i<pattern.length(); i++) {
            Tile tile = pattern.getTile(i);
            char letter = word.charAt(i);
            if (!fitInTile(tile, letter)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    private boolean fitInTile(Tile tile, char letter) {
        return tile.isEmpty() || tile.getLetter().charAt(0) == letter;
    }

    private Boolean canBeBuildWithLetters(String word, String letters, Pattern pattern) {
        for (int i=0; i<pattern.length(); i++) {
            Tile actualTile = pattern.getTile(i);
            String actualLetter = String.valueOf(word.charAt(i));
            if (actualTile.isEmpty()) {
                if (letters.contains(actualLetter)) {
                    letters = removeLetter(letters, actualLetter);
                } else {
                    return Boolean.FALSE;
                }
            } else if (!actualTile.getLetter().equals(actualLetter)) {
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
