package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.board.ClassicBoardFactory;
import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.dictionary.Dictionary;
import com.axiastudio.scrabbler.dictionary.DictionaryFactory;
import com.axiastudio.scrabbler.dictionary.TextDictionaryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TestAlgoritm {

    private final static String DICTIONARY_FILE_NAME = "dictionary.txt";

    private static Board board;
    private static Dictionary dictionary;


    @BeforeAll
    public static void initializeTestEnvironment() {
        board = new ClassicBoardFactory().buildAndInitialize();
        dictionary = buildAndInitializeDictionary();
    }

    private static Dictionary buildAndInitializeDictionary() {
        DictionaryFactory factory = new TextDictionaryFactory(DICTIONARY_FILE_NAME);
        return factory.buildAndInitialize();
    }

    @Test
    public void testSolutionsOnBoard() {
        board.placeLetterAtPosition(new Position(0, 0), "c");
        board.placeLetterAtPosition(new Position(2, 0), "s");
        String lettersInYourHand = "ai";
        List<String> solutions = board.findPossiblesPatterns().stream()
                .map(pattern -> dictionary.discoverWordsByLettersAndPattern(lettersInYourHand, pattern))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        Assertions.assertTrue(solutions.contains("casi"));
        Assertions.assertFalse(solutions.contains("casa"));
    }

}
