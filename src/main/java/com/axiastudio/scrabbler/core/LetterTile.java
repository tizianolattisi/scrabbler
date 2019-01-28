package com.axiastudio.scrabbler.core;

public class LetterTile implements Tile {

    protected String letter;
    private Integer points;

    public LetterTile(String letter) {
        this.letter = letter;
        this.points = 1;
    }

    public LetterTile(String letter, Integer points) {
        this.letter = letter;
        this.points = points;
    }

    @Override
    public String letter() {
        return letter;
    }

    @Override
    public Integer points() {
        if ("aeio".contains(letter)) {
            return 1;
        } else if ("crst".contains(letter)) {
            return 2;
        } else if ("lmnu".contains(letter)) {
            return 3;
        } else if ("bdfpv".contains(letter)) {
            return 5;
        } else if ("ghz".contains(letter)) {
            return 8;
        } else if ("q".contains(letter)) {
            return 10;
        }
        return 0;
    }

    @Override
    public Boolean isScarab() {
        return Boolean.FALSE;
    }

}
