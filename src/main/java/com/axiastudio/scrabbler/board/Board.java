package com.axiastudio.scrabbler.board;

import com.axiastudio.scrabbler.commons.Tile;
import com.axiastudio.scrabbler.dictionary.Pattern;

import java.util.List;

public interface Board {

    Tile getTile(Position position);
    void placeLetterAtPosition(Position position, String letter);
    List<Pattern> findPossiblesPatterns();

}
