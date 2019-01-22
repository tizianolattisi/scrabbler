package com.axiastudio.scrabbler.bag;

public class LetterTile implements Tile {

    protected String letter;
    private Integer value;

    public LetterTile(String letter, Integer value) {
        this.letter = letter;
        this.value = value;
    }

    @Override
    public String letter() {
        return letter;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public Boolean isScarab() {
        return Boolean.FALSE;
    }

}
