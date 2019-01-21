package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.board.awordedcrack.AwordedCrackBoardFactory;
import com.axiastudio.scrabbler.board.classic.ClassicBagFactory;
import com.axiastudio.scrabbler.board.classic.ClassicBoardFactory;
import com.axiastudio.scrabbler.commons.Tile;
import com.axiastudio.scrabbler.dictionary.Pattern;
import com.axiastudio.scrabbler.dictionary.TextDictionaryFactory;
import com.axiastudio.scrabbler.engine.Engine;
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
    public void testClassicBoard() {
        Engine engine = new Engine(new ClassicBoardFactory(), new TextDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
        engine.placeLetter(0, 0, "c");
        engine.placeLetter(2, 0, "s");
        String lettersInYourHand = "ai";
        List<String> solutions = engine.findSolutions(lettersInYourHand).stream()
                .map(pattern -> pattern.word())
                .collect(Collectors.toList());
        Assertions.assertTrue(solutions.contains("casi"));
        Assertions.assertFalse(solutions.contains("casa"));
    }

    @Test
    public void testAwordedCrackBoardWithClassicBag() {
        Engine engine = new Engine(new AwordedCrackBoardFactory(), new TextDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
        engine.placeLetter(0, 0, "c");
        engine.placeLetter(2, 0, "s");
        String lettersInYourHand = "ai";
        List<String> solutions = engine.findSolutions(lettersInYourHand).stream()
                .map(pattern -> pattern.word())
                .collect(Collectors.toList());
        Assertions.assertTrue(solutions.contains("casi"));
        Assertions.assertFalse(solutions.contains("casa"));
    }

    @Test
    public void testPoints() {
        Engine engine = new Engine(new ClassicBoardFactory(), new TextDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
        engine.placeLetter(0, 0, "c");
        engine.placeLetter(2, 0, "s");
        String lettersInYourHand = "ai";
        List<Pattern> solutions = engine.findSolutions(lettersInYourHand);

        for (Pattern solution: solutions) {
            Integer points=0;
            Integer wordMultiplicator = 1;
            for (int i= 0; i<solution.word().length(); i++) {
                String letter = String.valueOf(solution.word().charAt(i));
                Tile tile = solution.getTile(i);
                Integer value = engine.getBag().getValueOfALetter(letter);
                if (tile.isMultiplicatorForLetter()) {
                    value = value * tile.getMultiplicator();
                }
                points += value;
                if (tile.isMultiplicatorForWord()) {
                    wordMultiplicator *= tile.getMultiplicator();
                }
            }
            points *= wordMultiplicator;
            System.out.println(solution.word() + " (" + points + ")");
        }
    }

}
