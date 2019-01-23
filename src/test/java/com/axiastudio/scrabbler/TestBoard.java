package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.core.Board;
import com.axiastudio.scrabbler.board.classic.ClassicBoardFactory;
import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.core.Square;
import com.axiastudio.scrabbler.dictionary.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestBoard {

    private static Board board;

    @BeforeAll
    public static void initializeTestEnvironment() {
        board = new ClassicBoardFactory().buildAndInitialize();
    }

    @Test
    public void testClassicBoardCreation() {
        Square square = board.getSquare(new Position(0, 0));
        Assertions.assertTrue(square.isEmpty());
        Assertions.assertTrue(square.isMultiplicatorForWord());
        Assertions.assertEquals(3, (int) square.getMultiplicator());
    }

    @Test
    public void testPatternsDiscover() {
        board.placeLetterAtPosition(new Position(1, 0), "z");
        List<Pattern> possiblesPatterns = board.findPossiblesPatterns();
        Assertions.assertFalse(possiblesPatterns.isEmpty());
    }

}
