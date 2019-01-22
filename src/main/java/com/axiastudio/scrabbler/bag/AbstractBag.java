package com.axiastudio.scrabbler.bag;

public abstract class AbstractBag implements Bag {

    @Override
    public Integer getValueOfALetter(String letter) {
        return 1;
    }

    @Override
    public Tile extractTileFromLetter(String letter) {
        return new LetterTile(letter, 1);
    }

}