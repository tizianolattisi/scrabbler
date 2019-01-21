package com.axiastudio.scrabbler.dictionary;

import com.axiastudio.scrabbler.commons.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDictionary implements Dictionary {

    protected List<String> words = new ArrayList<>();

    @Override
    public List<String> discoverWordsByLettersAndPattern(String letters, Pattern pattern) {
        return words.stream()
                .filter(w -> checkWordMatching(w, pattern))
                .collect(Collectors.toList());
    }

    private Boolean checkWordMatching(String word, Pattern pattern) {
        if (word.length()!=pattern.length()) {
            return Boolean.FALSE;
        }
        for (int i = 0; i<pattern.length(); i++) {
            Tile tile = pattern.getTile(i);
            char letter = word.charAt(i);
            if (tile.isEmpty() || tile.getLetter().charAt(0) == letter) {

            } else {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
