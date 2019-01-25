package com.axiastudio.scrabbler.bag;

import com.axiastudio.scrabbler.core.Tile;

public interface Bag {

    Integer getValueOfALetter(String letter);

    Tile extractTileByLetter(String letter);

}
