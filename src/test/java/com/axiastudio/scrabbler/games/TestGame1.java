package com.axiastudio.scrabbler.games;

import com.axiastudio.scrabbler.core.Orientation;
import com.axiastudio.scrabbler.core.Pattern;
import com.axiastudio.scrabbler.core.Position;
import com.axiastudio.scrabbler.customs.awordedcrack.AwordedCrackBoardFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicBagFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicDictionaryFactory;
import com.axiastudio.scrabbler.engine.Engine;
import com.axiastudio.scrabbler.engine.Solution;
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
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // ammirati
    }

    @Test
    public void testRound2() {
        String[] lettersToPlace = {
                "      a        ",
                "      m        ",
                "      m        ",
                "      i        ",
                "     or        ",
                "     ha        ",
                "      t        ",
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
        String lettersInMyHand = "aaqhbao";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // amba
    }

    @Test
    public void testRound3() {
        String[] lettersToPlace = {
                "      a cuvee  ",
                "     amba      ",
                "      m        ",
                "      i        ",
                "     or        ",
                "     ha        ",
                "      t        ",
                "   sazio       ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "coqhiua";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // acqua
    }

    @Test
    public void testRound4() {
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                "     amba      ",
                "      m        ",
                "      i        ",
                "     or        ",
                "     ha        ",
                "      t        ",
                "   sazio       ",
                "   b           ",
                "   a           ",
                "   v           ",
                "   o           ",
                "               ",
                "               ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "eogihif";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // ghie (87 points)
    }

    @Test
    public void testRound5() {
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                "     amba      ",
                "      m        ",
                "      i        ",
                "     or        ",
                "     ha        ",
                "      t        ",
                "   sazio       ",
                "   b           ",
                "   a           ",
                " c v           ",
                " ago           ",
                " rh            ",
                " pi            ",
                " pe            "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "frolioi";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // zif
    }

    @Test
    public void testRound6() {
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                "     amba      ",
                "      m        ",
                "      i        ",
                "     or        ",
                "     ha        ",
                "      t        ",
                "   sazio       ",
                "   b i         ",
                "   a f         ",
                " c v           ",
                " ago           ",
                " rh            ",
                " pi            ",
                " pe            "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "epuravi";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // ?
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
        return upperBoudSolutions;
    }

    private void printPatterns(List<Pattern> patterns) {
        for (Pattern pattern: patterns) {
            Position position = pattern.position().get();
            Orientation orientation = pattern.orientation().get();
            String out = pattern.word() + " " + position + " " + orientation;
            System.out.println(out);
        }
    }

}
