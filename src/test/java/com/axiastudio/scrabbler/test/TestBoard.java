package com.axiastudio.scrabbler.test;

import com.axiastudio.scrabbler.customs.classic.ClassicBag;
import com.axiastudio.scrabbler.bag.Bag;
import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.customs.classic.ClassicBoardFactory;
import com.axiastudio.scrabbler.core.Position;
import com.axiastudio.scrabbler.core.Square;
import com.axiastudio.scrabbler.core.Pattern;
import org.junit.jupiter.api.*;

import java.util.List;

public class TestBoard {

    private static Board board;
    private static Bag bag;

    @BeforeEach
    public void initializeTestEnvironment() {
        board = new ClassicBoardFactory().buildAndInitialize();
        bag = new ClassicBag();
    }

    @Test
    public void testClassicBoardCreation() {
        Square square = board.getSquare(new Position(0, 0));
        Assertions.assertTrue(square.isEmpty());
        Assertions.assertTrue(square.isMultiplicatorForWord());
        Assertions.assertEquals(3, (int) square.getMultiplicator());
    }

    @Test
    public void testPatternsDiscoverLetterInCorner() {
        board.placeTileAtPosition(new Position(0, 0), bag.extractTileByLetter("z"));
        List<Pattern> possiblesPatterns = board.findPossiblesPatterns();
        Assertions.assertFalse(possiblesPatterns.isEmpty());
        Assertions.assertEquals(26, possiblesPatterns.size());
    }

    @Test
    public void testPatternsDiscoverCentralLetter() {
        board.placeTileAtPosition(new Position(6, 6), bag.extractTileByLetter("z"));
        List<Pattern> possiblesPatterns = board.findPossiblesPatterns();
        Assertions.assertFalse(possiblesPatterns.isEmpty());
        Assertions.assertEquals(131, possiblesPatterns.size());
    }

}
