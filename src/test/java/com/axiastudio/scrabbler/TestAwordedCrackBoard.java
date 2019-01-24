package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.board.awordedcrack.AwordedCrackBoardFactory;
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
    public void testAwordedCrackBoardCreation() {
        Square square = board.getSquare(new Position(1, 0));
        Assertions.assertTrue(square.isEmpty());
        Assertions.assertTrue(square.isMultiplicatorForWord());
        Assertions.assertEquals(3, (int) square.getMultiplicator());
    }

}
