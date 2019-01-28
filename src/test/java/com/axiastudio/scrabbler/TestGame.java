package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.core.Pattern;
import com.axiastudio.scrabbler.customs.awordedcrack.AwordedCrackBoardFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicBagFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicDictionaryFactory;
import com.axiastudio.scrabbler.engine.Engine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGame {

    private final static String DICTIONARY_FILE_NAME = "dictionary.txt";
    private static Engine engine;

    @BeforeEach
    public void initializeEngine() {
        engine = new Engine(new AwordedCrackBoardFactory(), new ClassicDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
    }

    @Test
    public void testRoundOne() {
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
        engine.placeLetters(lettersToPlace);
        String lettersInYourHand = "dahqrnf";
        List<Pattern> solutions = engine.findSolutions(lettersInYourHand);
        List<Pattern> upperBoundSolutions = findUpperBoundSolutions(solutions);
        Assertions.assertEquals(1,upperBoundSolutions.size());
        //Assertions.assertEquals("franda", upperBoundSolutions.get(0).word());

    }

    private List<Pattern> findUpperBoundSolutions(List<Pattern> solutions) {
        List<Pattern> upperBoudSolutions = new ArrayList<>();
        Integer currentBound = 0;
        for (int i=0; i<solutions.size(); i++) {
            Pattern solutionToCheck = solutions.get(i);
            Integer points = engine.calculatePoints(solutionToCheck);
            if (points>currentBound) {
                upperBoudSolutions.clear();
                upperBoudSolutions.add(solutionToCheck);
                currentBound = points;
            } else if (points==currentBound) {
                upperBoudSolutions.add(solutionToCheck);
            }
        }
        System.out.println("\nupperBound: " + currentBound);
        return upperBoudSolutions;
    }

}
