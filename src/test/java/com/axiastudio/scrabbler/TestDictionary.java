package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.bag.LetterTile;
import com.axiastudio.scrabbler.commons.LetterOrWord;
import com.axiastudio.scrabbler.commons.Square;
import com.axiastudio.scrabbler.dictionary.Dictionary;
import com.axiastudio.scrabbler.dictionary.DictionaryFactory;
import com.axiastudio.scrabbler.dictionary.Pattern;
import com.axiastudio.scrabbler.dictionary.TextDictionaryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

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
                .addSquare()
                .addSquare(new Square(3, LetterOrWord.LETTER))
                .addSquare(new Square(new LetterTile("a")))
                .addSquare();
        Assertions.assertEquals(4, pattern.length());
    }

    @Test
    public void testValidPattern() {
        Pattern pattern = new Pattern()
                .addSquare()
                .addSquare(new Square(3, LetterOrWord.LETTER))
                .addSquare(new Square(new LetterTile("a")))
                .addSquare();
        Assertions.assertTrue(pattern.isValid());
    }

    @Test
    public void testInvalidEmptyPattern() {
        Pattern emptyPattern = new Pattern()
                .addSquare()
                .addSquare()
                .addSquare();
        Assertions.assertFalse(emptyPattern.isValid());
    }

    @Test
    public void testInvalidShortPattern() {
        Pattern emptyPattern = new Pattern()
                .addSquare();
        Assertions.assertFalse(emptyPattern.isValid());
    }

    @Test
    public void testWordsDiscover() {
        Pattern patternToCheck = new Pattern()
                .addSquare(new Square(new LetterTile("c")))
                .addSquare(new Square(new LetterTile("a")))
                .addSquare()
                .addSquare(new Square(new LetterTile("a")));
        List<String> discovered = dictionary.discoverWordsByLettersAndPattern("sleaaii", patternToCheck).stream()
                .map(pattern -> pattern.word())
                .collect(Collectors.toList());
        Assertions.assertTrue(discovered.contains("casa"));
        Assertions.assertTrue(discovered.contains("cala"));
        Assertions.assertFalse(discovered.contains("caza"));
    }

}
