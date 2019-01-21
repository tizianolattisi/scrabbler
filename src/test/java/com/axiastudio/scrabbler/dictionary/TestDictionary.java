package com.axiastudio.scrabbler.dictionary;

import com.axiastudio.scrabbler.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDictionary {

    private final static String DICTIONARY_FILE_NAME = "dictionary.txt";
    private static Dictionary dictionary;

    @BeforeAll
    public static void initializeTestEnvironment() {
        dictionary = buildAndInitializeDictionary();
    }

    private static Dictionary buildAndInitializeDictionary() {
        DictionaryFactory factory = new TextDictionaryFactory(DICTIONARY_FILE_NAME);
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
                .addTile()
                .addTile(new Tile(3, LetterOrWord.LETTER))
                .addTile(new Tile("a"))
                .addTile();
        Assertions.assertEquals(4, pattern.length());
    }

    @Test
    public void testWordsDiscover() {
        Pattern pattern = new Pattern()
                .addTile(new Tile("c"))
                .addTile(new Tile("a"))
                .addTile()
                .addTile(new Tile("a"));
        List<String> discovered = dictionary.discoverWordsByLettersAndPattern("sleaaii", pattern);
        Assertions.assertTrue(discovered.contains("casa"));
        Assertions.assertTrue(discovered.contains("cara"));
        Assertions.assertFalse(discovered.contains("caza"));
    }

}
