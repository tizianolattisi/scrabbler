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

    //@Test
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
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("ronzare", solution.pattern().word());
    }

    //@Test
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
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("segalino", solution.pattern().word());
    }

    //@Test
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
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("alidada", solution.pattern().word());
    }

    //@Test
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
                "         n   tu",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "aeroeih";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("ghiro", solution.pattern().word());
    }

    //@Test
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
                "         n   tu",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "aeeoeae";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("ohe", solution.pattern().word());
    }

    //@Test
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
                "         n   tu",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "aeeoeae";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("ozia", solution.pattern().word());
    }

    //@Test
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
                "         n   tu",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "veeuea";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("velai", solution.pattern().word());
    }

    //@Test
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
                "  velai  ghiro ",
                "      a  a ohe ",
                "         l     ",
                "       alidada ",
                "         n   tu",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "seouaee";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("suase", solution.pattern().word());
    }

    //@Test
    public void testRound9() {
        String[] lettersToPlace = {
                "         s     ",
                "       s f     ",
                "       u i     ",
                "       a g     ",
                "     castano   ",
                "     r e       ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "  velai  ghiro ",
                "      a  a ohe ",
                "         l     ",
                "       alidada ",
                "         n   tu",
                "         o     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "meoieme";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("sememi", solution.pattern().word());
    }

    //@Test
    public void testRound10() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f     ",
                "       u i     ",
                "       a g     ",
                "     castano   ",
                "     r e       ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "  velai  ghiro ",
                "      a  a ohe ",
                "         l     ",
                "       alidada ",
                "         n   tu",
                "    bavero     ",
                "               "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "icoimie";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("emici", solution.pattern().word());
    }

    //@Test
    public void testRound11() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f     ",
                "       u i     ",
                "       a g     ",
                "     castano   ",
                "     r e       ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "  velai  ghiro ",
                "      a  a ohe ",
                "f        l     ",
                "e      alidada ",
                "l        n   tu",
                "c   bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "ianooii";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("ionia", solution.pattern().word());
    }

    //@Test
    public void testRound12() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f    o",
                "       u i    n",
                "       a g peti",
                "     castano  a",
                "     r e       ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "  velai  ghiro ",
                "      a  a ohe ",
                "f        l     ",
                "e      alidada ",
                "l        n   tu",
                "c   bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "intoaai";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("pontaio", solution.pattern().word());
    }

    //@Test
    public void testRound13() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f    o",
                "       u i    n",
                "       a g peti",
                "     castano  a",
                "     r e       ",
                "    suo  s     ",
                "   ronzare   pc", // central
                "  velai  ghiro ",
                "      a  a ohe ",
                "f        l     ",
                "e      alidada ",
                "l        n   tu",
                "c   bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "intoaai";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("pontaio", solution.pattern().word());
    }

    //@Test
    public void testRound14() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f    o",
                "       u in   n",
                "       a gipeti",
                "     castano  a",
                "     r e  in   ",
                "    suo  s t   ",
                "   ronzare a pc", // central
                "  velai  ghiro ",
                "      a  a ohe ",
                "f        l     ",
                "e      alidada ",
                "l        n   tu",
                "c   bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "iouofai";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("fuio", solution.pattern().word());
    }

    //@Test
    public void testRound15() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f    o",
                "      qu in   n",
                "       a gipeti",
                "     castano  a",
                "     r e  in   ",
                "    suo  s t   ",
                "   ronzare a pc", // central
                "  velai  ghiro ",
                " fuio a  a ohe ",
                "f        l     ",
                "e      alidada ",
                "l        n   tu",
                "c   bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "eoctvai";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("vuotavi", solution.pattern().word());
        System.out.println(solution.points());
    }

    //@Test
    public void testRound16() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f    o",
                "      qu in   n",
                "       a gipeti",
                "     castano  a",
                "     r e  in   ",
                "    suo  s t   ",
                "   ronzare a pc", // central
                "  velai  ghiro ",
                " fuio a  a ohe ",
                "f o      l     ",
                "e t    alidada ",
                "l a   ti n   tu",
                "c v bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "ioeczoo";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("oziai", solution.pattern().word());
    }

    //@Test
    public void testRound17() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f    o",
                "      qu in   n",
                "       a gipeti",
                "     castano  a",
                "     r e  in   ",
                "    suo  s t   ",
                "   ronzare a pc", // central
                "  velai  ghiro ",
                " fuio a  a ohe ",
                "f o   i  l     ",
                "e t    alidada ",
                "l amo ti n   tu",
                "c v bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "boeczoo";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("tbc", solution.pattern().word());
    }

    //@Test
    public void testRound18() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f    o",
                "      qu in   n",
                "       a gipeti",
                "     castano ba",
                "     r e  in c ",
                "    suo  s t   ",
                "   ronzare a pc", // central
                "  velai  ghiro ",
                " fuio a  a ohe ",
                "f o   i  l     ",
                "est    alidada ",
                "l amo ti n   tu",
                "c v bavero     ",
                "emici          "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "ooemzoo";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("zoo", solution.pattern().word());
    }

    //@Test
    public void testRound19() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f    o",
                "      qu in   n",
                "       a gipeti",
                "     castano ba",
                "     r e  in c ",
                "    suo  s t   ",
                "   ronzare a pc", // central
                "  velai  ghiro ",
                " fuio a  a ohe ",
                "f o   i  l     ",
                "est    alidada ",
                "l amo ti n   tu",
                "c v bavero zoo ",
                "emici       r  "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "ooepm";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("mm", solution.pattern().word());
    }

    //@Test
    public void testRound20() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f    o",
                "      qu in   n",
                "       a gipeti",
                "     castano ba",
                "     r e  in c ",
                "    suo  s t   ",
                "   ronzare a pc", // central
                "  velai  ghiro ",
                " fuio a  a ohe ",
                "f o   i  l     ",
                "est lo alidada ",
                "l amo ti n   tu",
                "c v bavero zoo ",
                "emici       r  "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "ooep";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("pel", solution.pattern().word());
    }

    //@Test
    public void testRound21() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f u  o",
                "      qu in   n",
                "       a gipeti",
                "     castano ba",
                "     r e  in c ",
                "    suo  s t   ",
                "   ronzare a pc", // central
                "  velai  ghiro ",
                " fuio a pa ohe ",
                "f o   i el     ",
                "est lo alidada ",
                "l amo ti n   tu",
                "c v bavero zoo ",
                "emici       r  "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "oo";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("do", solution.pattern().word());
    }

    //@Test
    public void testRound22() {
        String[] lettersToPlace = {
                "         sememi",
                "       s f u  o",
                "      qu in   n",
                "       a gipeti",
                "     castano ba",
                "     r e  in c ",
                "    suo  s t   ",
                "   ronzare a pc", // central
                "  velai  ghiro ",
                " fuio a pa ohe ",
                "f o  bi el     ",
                "est lo alidada ",
                "l amo ti no  tu",
                "c v bavero zoo ",
                "emici       r  "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "o";
        Solution solution = engine.bestSolution(lettersInMyHand).get();
        Assertions.assertEquals("to", solution.pattern().word());
        // win
    }

}
