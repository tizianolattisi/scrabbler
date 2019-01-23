package com.axiastudio.scrabbler.dictionary;

import com.axiastudio.scrabbler.core.Dictionary;
import com.axiastudio.scrabbler.core.DictionaryFactory;

public class TextDictionaryFactory implements DictionaryFactory {

    private final String fileName;

    public TextDictionaryFactory(String fileName) {
        this.fileName = fileName;
    }

    public Dictionary buildAndInitialize() {
        TextDictionary dictionary = new TextDictionary();
        dictionary.loadWordsFromFile(fileName);
        return dictionary;
    }

}
