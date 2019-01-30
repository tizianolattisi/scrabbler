package com.axiastudio.scrabbler.games;

import com.axiastudio.scrabbler.customs.awordedcrack.AwordedCrackBoardFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicBagFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicDictionaryFactory;
import com.axiastudio.scrabbler.engine.Engine;
import com.axiastudio.scrabbler.engine.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/*
 *   This is a real game played again a real player (thank's LucaB)
 *
 *
 */
public class TestGame2 {

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
                "      zar      ", // central
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "orlonse";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("ronzare", solution.pattern().word());
    }

    @Test
    public void testRound2() {
        String[] lettersToPlace = {
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "    su         ",
                "   ronzare     ", // central
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "golnais";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("segalino", solution.pattern().word());
    }

    @Test
    public void testRound3() {
        String[] lettersToPlace = {
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "    su   s     ",
                "   ronzare     ", // central
                "    lai  g     ",
                "         a     ",
                "         l     ",
                "         i     ",
                "         n     ",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "aaoddla";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("alidada", solution.pattern().word());
    }

    @Test
    public void testRound4() {
        String[] lettersToPlace = {
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "    su   s     ",
                "   ronzare     ", // central
                "    lai  g     ",
                "         a     ",
                "         l     ",
                "       alidada ",
                "         n   th",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "aeroeih";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("ghiro", solution.pattern().word());
    }

    @Test
    public void testRound5() {
        String[] lettersToPlace = {
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "    su   s     ",
                "   ronzare     ", // central
                "    lai  ghiro ",
                "         a oh  ",
                "         l     ",
                "       alidada ",
                "         n   th",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "aeeoeae";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("ohe", solution.pattern().word());
    }

    @Test
    public void testRound6() {
        String[] lettersToPlace = {
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "               ",
                "    su   s     ",
                "   ronzare   pc", // central
                "    lai  ghiro ",
                "         a ohe ",
                "         l     ",
                "       alidada ",
                "         n   th",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "aeeoeae";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("ozia", solution.pattern().word());
    }

    @Test
    public void testRound7() {
        String[] lettersToPlace = {
                "               ",
                "               ",
                "               ",
                "               ",
                "     c         ",
                "     r         ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "    lai  ghiro ",
                "      a  a ohe ",
                "         l     ",
                "       alidada ",
                "         n   th",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "veeuea";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("velai", solution.pattern().word());
    }

    @Test
    public void testRound8() {
        String[] lettersToPlace = {
                "               ",
                "               ",
                "               ",
                "               ",
                "     castano   ",
                "     r         ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "    lai  ghiro ",
                "      a  a ohe ",
                "         l     ",
                "       alidada ",
                "         n   th",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "seouaee";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("suase", solution.pattern().word());
    }

    @Test
    public void testRound9() {
        String[] lettersToPlace = {
                "         s     ",
                "         f     ",
                "         i     ",
                "         g     ",
                "     castano   ",
                "     r         ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "    lai  ghiro ",
                "      a  a ohe ",
                "         l     ",
                "       alidada ",
                "         n   th",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "meoieme";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("sememi", solution.pattern().word());
    }

    @Test
    public void testRound10() {
        String[] lettersToPlace = {
                "         sememi",
                "         f     ",
                "         i     ",
                "         g     ",
                "     castano   ",
                "     r         ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "    lai  ghiro ",
                "      a  a ohe ",
                "         l     ",
                "       alidada ",
                "         n   th",
                "    bavero     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "icoimie";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("emici", solution.pattern().word());
    }

    @Test
    public void testRound11() {
        String[] lettersToPlace = {
                "         sememi",
                "         f     ",
                "         i     ",
                "         g     ",
                "     castano   ",
                "     r         ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "    lai  ghiro ",
                "      a  a ohe ",
                "f        l     ",
                "e      alidada ",
                "l        n   th",
                "c   bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "ianooii";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("ionia", solution.pattern().word());
    }

    @Test
    public void testRound12() {
        String[] lettersToPlace = {
                "         sememi",
                "         f    o",
                "         i    n",
                "         g peti",
                "     castano  a",
                "     r         ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "    lai  ghiro ",
                "      a  a ohe ",
                "f        l     ",
                "e      alidada ",
                "l        n   th",
                "c   bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "intoaai";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("pontaio", solution.pattern().word());
    }

    @Test
    public void testRound13() {
        String[] lettersToPlace = {
                "         sememi",
                "         f    o",
                "         i    n",
                "         g peti",
                "     castano  a",
                "     r         ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "    lai  ghiro ",
                "      a  a ohe ",
                "f        l     ",
                "e      alidada ",
                "l        n   th",
                "c   bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "intoaai";
        Solution solution = engine.bestSolution(lettersInMyHand);
        Assertions.assertEquals("pontaio", solution.pattern().word());
    }

}
