package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.core.Position;
import com.axiastudio.scrabbler.customs.awordedcrack.AwordedCrackBoardFactory;
import com.axiastudio.scrabbler.core.Board;
import com.axiastudio.scrabbler.core.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TestAwordedCrackBoard {

    private static Board board;

    @BeforeAll
    public static void initializeTestEnvironment() {
        board = new AwordedCrackBoardFactory().buildAndInitialize();
    }

    @Test
    public void testBoardCreation() {
        Square square = board.getSquare(new Position(2, 0));
        Assertions.assertTrue(square.isEmpty());
        Assertions.assertTrue(square.isMultiplicatorForWord());
        Assertions.assertEquals(3, (int) square.getMultiplicator());
    }

    @Test
    public void testBoardIsSymmetric() {
        int maxSizeToCheck = (board.size() + 1) / 2;
        for (int i=0; i<maxSizeToCheck; i++) {
            for (int j=0; j<maxSizeToCheck; j++) {
                Square northEastSquare = board.getSquare(new Position(i, j));
                Square northWestSquare = board.getSquare(new Position(board.size()-1-i, j));
                Square southEastSquare = board.getSquare(new Position(i, board.size()-1-j));
                Square southWestSquare = board.getSquare(new Position(board.size()-1-i, board.size()-1-j));
                Assertions.assertEquals(northEastSquare.getMultiplicator(), northWestSquare.getMultiplicator());
                Assertions.assertEquals(northWestSquare.getMultiplicator(), southEastSquare.getMultiplicator());
                Assertions.assertEquals(southEastSquare.getMultiplicator(), southWestSquare.getMultiplicator());
                Assertions.assertEquals(northEastSquare.isMultiplicatorForWord(), northWestSquare.isMultiplicatorForWord());
                Assertions.assertEquals(northWestSquare.isMultiplicatorForWord(), southEastSquare.isMultiplicatorForWord());
                Assertions.assertEquals(southEastSquare.isMultiplicatorForWord(), southWestSquare.isMultiplicatorForWord());
            }
        }
    }

}
