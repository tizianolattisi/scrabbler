package com.axiastudio.scrabbler.board;

import com.axiastudio.scrabbler.commons.Square;
import com.axiastudio.scrabbler.dictionary.Pattern;

import java.util.List;

public interface Board {

    Square getSquare(Position position);
    void placeLetterAtPosition(Position position, String letter);
    List<Pattern> findPossiblesPatterns();

}
