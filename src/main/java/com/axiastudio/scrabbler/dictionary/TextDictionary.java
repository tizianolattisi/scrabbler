package com.axiastudio.scrabbler.dictionary;

import com.axiastudio.scrabbler.core.Dictionary;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TextDictionary extends AbstractDictionary implements Dictionary {


    protected Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public void loadWordsFromFile(String fileName) {
        URL dictionaryUrl = getClass().getClassLoader().getResource(fileName);
        try (Stream<String> wordsStream = Files.lines(Paths.get(dictionaryUrl.getPath()))) {
            wordsStream.forEach(words::add);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Unable to load words.");
        }
    }

    @Override
    public Integer numberOfWords() {
        return words.size();
    }

    @Override
    public Boolean checkWordExistence(String word) {
        return words.contains(word);
    }

}
