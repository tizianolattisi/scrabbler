package com.axiastudio.scrabbler.bag;

public interface Bag {

    Integer getValueOfALetter(String letter);

    Tile extractTileFromLetter(String letter);

}
