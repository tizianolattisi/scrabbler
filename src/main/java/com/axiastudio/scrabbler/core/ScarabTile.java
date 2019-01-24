package com.axiastudio.scrabbler.core;

public class ScarabTile extends LetterTile implements Tile {

    public ScarabTile() {
        super(null, null);
    }

    @Override
    public Boolean isScarab() {
        return Boolean.TRUE;
    }

    @Override
    public Integer points() {
        return 0;
    }

    public void castLetter(String letter) {
        this.letter = letter;
    }

}
