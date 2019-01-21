package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.board.ClassicBoardFactory;
import com.axiastudio.scrabbler.dictionary.TextDictionaryFactory;
import com.axiastudio.scrabbler.engine.Engine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEngine {

    private final static String DICTIONARY_FILE_NAME = "dictionary.txt";

    private static Engine engine;


    @BeforeAll
    public static void initializeTestEnvironment() {
        engine = new Engine(new ClassicBoardFactory(), new TextDictionaryFactory(DICTIONARY_FILE_NAME));
    }

    @Test
    public void testSolutionsOnBoard() {
        engine.placeLetter(0, 0, "c");
        engine.placeLetter(2, 0, "s");
        String lettersInYourHand = "ai";
        List<String> solutions = engine.findSolutions(lettersInYourHand);
        Assertions.assertTrue(solutions.contains("casi"));
        Assertions.assertFalse(solutions.contains("casa"));
    }

}
