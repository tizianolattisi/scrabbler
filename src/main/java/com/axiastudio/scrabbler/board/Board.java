package com.axiastudio.scrabbler.board;

import com.axiastudio.scrabbler.core.Pattern;
import com.axiastudio.scrabbler.core.Position;
import com.axiastudio.scrabbler.core.Square;
import com.axiastudio.scrabbler.core.Tile;

import java.util.List;

public interface Board {

    Square getSquare(Position position);
    void placeTileAtPosition(Position position, Tile tile);
    List<Pattern> findPossiblesPatterns();
    Integer size();

}
