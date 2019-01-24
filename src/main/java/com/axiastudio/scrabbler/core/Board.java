package com.axiastudio.scrabbler.core;

import java.util.List;

public interface Board {

    Square getSquare(Position position);
    void placeTileAtPosition(Position position, Tile tile);
    List<Pattern> findPossiblesPatterns();
    Integer size();

}
