package com.axiastudio.scrabbler.games;

import com.axiastudio.scrabbler.customs.awordedcrack.AwordedCrackBoardFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicBagFactory;
import com.axiastudio.scrabbler.customs.classic.ClassicDictionaryFactory;
import com.axiastudio.scrabbler.engine.Engine;
import com.axiastudio.scrabbler.engine.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
                "      m pruvaie",
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
        String lettersInMyHand = "rroltoi";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // litio
    }

    @Test
    public void testRound7() {
        // note: the "pruvaie" solution was a suggest to the opponent... ;-)
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                "     amba      ",
                "mole  m pruvaie",
                "   litio       ",
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
        String lettersInMyHand = "rroliad";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // dolorai
    }

    @Test
    public void testRound8() {
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                " d   amba      ",
                "mole  m pruvaie",
                " l litio       ",
                " o   or        ",
                " r   ha        ",
                " a    t        ",
                " i sazio       ",
                "   b i cestino ",
                "   a f         ",
                " c v           ",
                " ago           ",
                " rh            ",
                " pi            ",
                " pe            "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "rraseea";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // astraere
    }

    @Test
    public void testRound9() {
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                " d   amba      ",
                "mole  m pruvaie",
                " l litio       ",
                "go   or        ",
                "or   ha        ",
                "ta    t   a    ",
                "oi sazio  s    ",
                "   b i cestino ",
                "   a f    r    ",
                " c v      a    ",
                " ago      e    ",
                " rh       r    ",
                " pi       e    ",
                " pe            "
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "ffeltcp";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // felpe
    }

    @Test
    public void testRound10() {
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                " d   amba      ",
                "mole  m pruvaie",
                " l litio       ",
                "go   or        ",
                "or   ha        ",
                "ta    t   a    ",
                "oi sazio  s    ",
                "   b i cestino ",
                "   a f    r    ",
                " c v      a    ",
                " ago      e    ",
                " rh       r    ",
                " pi      felpe ",
                " pe         cab"
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "fnuotcm";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // futon
    }

    @Test
    public void testRound11() {
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                " d   amba      ",
                "mole  m pruvaie",
                " l litio       ",
                "go   or        ",
                "or   ha      f ",
                "ta    t   a  u ",
                "oi sazio  s  t ",
                "   b i cestino ",
                "   a f    r  ni",
                " c v      a   n",
                " ago      e   n",
                " rh       r   o",
                " pi      felpe ",
                " pe         cab"
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "doeoocm";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // comode
    }

    @Test
    public void testRound12() {
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                " d   amba      ",
                "mole  m pruvaie",
                " l litio       ",
                "go   or        ",
                "or   ha      f ",
                "ta    t   a zum",
                "oi sazio  s  t ",
                "   b i cestino ",
                "   a f    r  ni",
                " c v      a   n",
                " ago comode   n",
                " rh       r   o",
                " pi      felpe ",
                " pe         cab"
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "nessuso";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // cune
    }

    @Test
    public void testRound13() {
        String[] lettersToPlace = {
                "  acqua cuvee  ",
                " d   amba      ",
                "mole  m pruvaie",
                " l litio       ",
                "go   or        ",
                "or   ha      f ",
                "ta    t   a zum",
                "oi sazio  s  t ",
                "   b i cestino ",
                "   a f    r  ni",
                " c v      a   n",
                " ago comode   n",
                " rh  u    r   o",
                " pi  n   felpe ",
                " pe  e ido  cab"
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "aoessso";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // sesso
    }

    @Test
    public void testRound14() {
        String[] lettersToPlace = {
                "  acqua cuvee s",
                " d   amba     t",
                "mole  m pruvaie",
                " l litio      l",
                "go   or       i",
                "or   ha  s   f ",
                "ta    t  ea zum",
                "oi sazio ss  t ",
                "   b i cestino ",
                "   a f   or  ni",
                " c v      a   n",
                " ago comode   n",
                " rh  u    r   o",
                " pi  n   felpe ",
                " pe  e ido  cab"
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "aos";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // zano
    }

    @Test
    public void testRound15() {
        String[] lettersToPlace = {
                "  acqua cuvee s",
                " d   amba     t",
                "mole  m pruvaie",
                " l litio      l",
                "go   or       i",
                "or   ha  s   f ",
                "tai   t  ea zum",
                "oi sazio ss  t ",
                "   b i cestino ",
                "   a f   or  ni",
                " c v      a   n",
                " ago comode   n",
                " rh  u    r   o",
                " pi  n   felpe ",
                " pe  e ido  cab"
        };
        engine.placeLetters(lettersToPlace);
        String lettersInMyHand = "s";
        Solution solution = engine.bestSolution(lettersInMyHand);
        System.out.println(solution);
        // the opponent is the winner (but with a hint in round 7) 628 - 692
    }
}
