package com.axiastudio.scrabbler.games;

import com.axiastudio.scrabbler.core.Pattern;
import com.axiastudio.scrabbler.core.Position;
import com.axiastudio.scrabbler.customs.awordedcrack.AwordedCrackBoardFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicBagFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicDictionaryFactory;
import com.axiastudio.scrabbler.engine.Engine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
 *   This is a real game played again a real player (thank's LucaB)
 *
 *
 */
public class TestGame1 {

    private final static String DICTIONARY_FILE_NAME = "dictionary.txt";
    private static Engine engine;

    @BeforeEach
    public void initializeEngine() {
        engine = new Engine(new AwordedCrackBoardFactory(), new ClassicDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());
    }

    @Test
    public void testRound1() {
        String[] lettersToPlace = {
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "   sazio       ", // central
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "mraatim";
        List<Pattern> upperBoundSolutions = findUpperBoundSolutions(engine.findSolutions(lettersInMyHand));
        Assertions.assertEquals("ammirati", upperBoundSolutions.get(0).word());
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

    private void printPatterns(List<Pattern> patterns) {
        for (Pattern pattern: patterns) {
            Position position = pattern.position().get();
            String out = pattern.word() + " (" + position.getX() + ", " + position.getY() + ")";
            System.out.println(out);
        }
    }

}
