package com.axiastudio.scrabbler.bag;

public class LetterTile implements Tile {

    protected String letter;
    private Integer points;

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
        return points;
    }

    @Override
    public Boolean isScarab() {
        return Boolean.FALSE;
    }

}
