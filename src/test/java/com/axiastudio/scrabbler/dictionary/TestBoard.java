package com.axiastudio.scrabbler.dictionary;

import com.axiastudio.scrabbler.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBoard {

    @Test
    public void testClassicBoardCreation() {
        Board board = new ClassicBoardFactory().buildAndInitialize();
        Tile tile = board.getTile(new Position(0, 0));
        Assertions.assertTrue(tile.isEmpty());
        Assertions.assertTrue(tile.isMultiplicatorForWord());
        Assertions.assertTrue(tile.getMultiplicator()==3);
    }

}
