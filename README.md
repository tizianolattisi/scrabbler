# scrabbler

A Scrabble bot.

```java

String DICTIONARY_FILE_NAME = "dictionary.txt";
Engine engine = new Engine(new AwordedCrackBoardFactory(), new ClassicDictionaryFactory(DICTIONARY_FILE_NAME), new ClassicBagFactory());

String[] lettersToPlace = {
        "  acqua cuvee  ",
        " d   amba      ",
        "mole  m        ",
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
String lettersInMyHand = "euirvpa";
Solution solution = engine.bestSolution(lettersInMyHand);
Assertions.assertEquals("pruavie", solution.pattern().word());
Assertions.assertEquals(139, solution.points());

```
    
