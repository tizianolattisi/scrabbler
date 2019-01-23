package com.axiastudio.scrabbler.core;

import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.dictionary.Pattern;

import java.util.List;

public interface Board {

    Square getSquare(Position position);
    void placeLetterAtPosition(Position position, String letter);
    List<Pattern> findPossiblesPatterns();

}
