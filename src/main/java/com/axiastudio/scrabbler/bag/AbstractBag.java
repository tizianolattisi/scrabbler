package com.axiastudio.scrabbler.bag;

import com.axiastudio.scrabbler.core.Bag;
import com.axiastudio.scrabbler.core.Tile;

public abstract class AbstractBag implements Bag {

    @Override
    public Integer getValueOfALetter(String letter) {
        return 1;
    }

    @Override
    public Tile extractTileByLetter(String letter) {
        return new LetterTile(letter);
    }

}
