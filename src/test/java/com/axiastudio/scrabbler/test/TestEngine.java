package com.axiastudio.scrabbler.test;

import com.axiastudio.scrabbler.core.LetterTile;
import com.axiastudio.scrabbler.customs.awordedcrack.AwordedCrackBoardFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicBagFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicBoardFactory;
import com.axiastudio.scrabbler.core.Square;
import com.axiastudio.scrabbler.core.Pattern;
import com.axiastudio.scrabbler.customs.classic.ClassicDictionaryFactory;
import com.axiastudio.scrabbler.engine.Engine;
import com.axiastudio.scrabbler.engine.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TestEngine {

    private final static String DICTIONARY_FILE_NAME = "dictionary.txt";

    @BeforeAll
    public static void initializeTestEnvironment() {

    }

    @Test
    public void testWordsDiscover() {
        Engine engine = new Engine(new ClassicBoardFactory(), new ClassicDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
        Pattern patternToCheck = new Pattern()
                .addSquare(new Square(new LetterTile("c")))
                .addSquare(new Square(new LetterTile("a")))
                .addSquare()
                .addSquare(new Square(new LetterTile("a")));
        List<String> discovered = engine.discoverWordsByLettersAndPattern("sleaaii", patternToCheck).stream()
                .map(Pattern::word)
                .collect(Collectors.toList());
        Assertions.assertTrue(discovered.contains("casa"));
        Assertions.assertTrue(discovered.contains("cala"));
        Assertions.assertFalse(discovered.contains("caza"));
    }

    @Test
    public void testClassicBoard() {
        Engine engine = new Engine(new ClassicBoardFactory(), new ClassicDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
        engine.placeLetter(0, 0, "c");
        engine.placeLetter(2, 0, "s");
        String lettersInYourHand = "ai";
        List<String> solutions = engine.findSolutions(lettersInYourHand).stream()
                .map(Solution::pattern)
                .map(Pattern::word)
                .collect(Collectors.toList());
        Assertions.assertTrue(solutions.contains("casi"));
        Assertions.assertFalse(solutions.contains("casa"));
    }

    @Test
    public void testAwordedCrackBoardWithClassicBag() {
        Engine engine = new Engine(new AwordedCrackBoardFactory(), new ClassicDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
        engine.placeLetter(0, 0, "c");
        engine.placeLetter(2, 0, "s");
        String lettersInYourHand = "ai";
        List<String> solutions = engine.findSolutions(lettersInYourHand).stream()
                .map(Solution::pattern)
                .map(Pattern::word)
                .collect(Collectors.toList());
        Assertions.assertTrue(solutions.contains("casi"));
        Assertions.assertFalse(solutions.contains("casa"));
    }

    @Test
    public void testLettersPlacingFromStringArray() {
        String[] lettersToPlace = {
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "       casa    ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               "
        };
        Engine engine = new Engine(new AwordedCrackBoardFactory(), new ClassicDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
        engine.placeLetters(lettersToPlace);
        String lettersInYourHand = "dahqrnf";
        List<String> solutions = engine.findSolutions(lettersInYourHand).stream()
                .map(Solution::pattern)
                .map(Pattern::word)
                .collect(Collectors.toList());
    }

    @Test
    public void testCheckSolutionForCrossingWords() {

        String[] lettersToPlace = {
                "i              ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               "
        };
        Engine engine = new Engine(new AwordedCrackBoardFactory(), new ClassicDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
        engine.placeLetters(lettersToPlace);
        String lettersInYourHand = "io";
        List<Solution> solutions = engine.findSolutions(lettersInYourHand);
        Assertions.assertEquals(4, solutions.size());
    }

}
