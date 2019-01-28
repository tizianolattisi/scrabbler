package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.core.LetterTile;
import com.axiastudio.scrabbler.core.LetterOrWord;
import com.axiastudio.scrabbler.core.Square;
import com.axiastudio.scrabbler.dictionary.Dictionary;
import com.axiastudio.scrabbler.dictionary.DictionaryFactory;
import com.axiastudio.scrabbler.core.Pattern;
import com.axiastudio.scrabbler.customs.classic.ClassicDictionaryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestDictionary {

    private final static String DICTIONARY_FILE_NAME = "dictionary.txt";
    private static Dictionary dictionary;

    @BeforeAll
    public static void initializeTestEnvironment() {
        dictionary = buildAndInitializeDictionary();
    }

    private static Dictionary buildAndInitializeDictionary() {
        DictionaryFactory factory = new ClassicDictionaryFactory(DICTIONARY_FILE_NAME);
        return factory.buildAndInitialize();
    }

    @Test
    public void testDictionaryInitialization() {
        Assertions.assertTrue(dictionary.numberOfWords()>0);
    }

    @Test
    public void testExistentWordSearch() {
        Assertions.assertTrue(dictionary.checkWordExistence("casa"));
    }

    @Test
    public void testInexistentWordSearch() {
        Assertions.assertFalse(dictionary.checkWordExistence("casax"));
    }

    @Test
    public void testPatternLength() {
        Pattern pattern = new Pattern()
                .addSquare()
                .addSquare(new Square(3, LetterOrWord.LETTER))
                .addSquare(new Square(new LetterTile("a")))
                .addSquare();
        Assertions.assertEquals(4, pattern.length());
    }

}
