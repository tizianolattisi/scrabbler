package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.board.ClassicBoardFactory;
import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.commons.Tile;
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
