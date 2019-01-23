package com.axiastudio.scrabbler.core;

public interface Bag {

    Integer getValueOfALetter(String letter);

    Tile extractTileByLetter(String letter);

}
