package com.axiastudio.scrabbler.core;

public interface Bag {

    Integer getValueOfALetter(String letter);

    Tile extractTileFromLetter(String letter);

}
