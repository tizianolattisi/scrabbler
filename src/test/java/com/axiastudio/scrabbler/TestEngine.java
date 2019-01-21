package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.board.awordedcrack.AwordedCrackBoardFactory;
import com.axiastudio.scrabbler.board.classic.ClassicBoardFactory;
import com.axiastudio.scrabbler.dictionary.TextDictionaryFactory;
import com.axiastudio.scrabbler.engine.Engine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEngine {

    private final static String DICTIONARY_FILE_NAME = "dictionary.txt";

    @BeforeAll
    public static void initializeTestEnvironment() {

    }

    @Test
    public void testClassicBoard() {
        Engine engine = new Engine(new ClassicBoardFactory(), new TextDictionaryFactory(DICTIONARY_FILE_NAME));
        engine.placeLetter(0, 0, "c");
        engine.placeLetter(2, 0, "s");
        String lettersInYourHand = "ai";
        List<String> solutions = engine.findSolutions(lettersInYourHand);
        Assertions.assertTrue(solutions.contains("casi"));
        Assertions.assertFalse(solutions.contains("casa"));
    }

    @Test
    public void testAwordedCrackBoard() {
        Engine engine = new Engine(new AwordedCrackBoardFactory(), new TextDictionaryFactory(DICTIONARY_FILE_NAME));
        engine.placeLetter(0, 0, "c");
        engine.placeLetter(2, 0, "s");
        String lettersInYourHand = "ai";
        List<String> solutions = engine.findSolutions(lettersInYourHand);
        Assertions.assertTrue(solutions.contains("casi"));
        Assertions.assertFalse(solutions.contains("casa"));
    }

}
