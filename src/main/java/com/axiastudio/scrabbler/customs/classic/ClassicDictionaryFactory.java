package com.axiastudio.scrabbler.customs.classic;

import com.axiastudio.scrabbler.dictionary.Dictionary;
import com.axiastudio.scrabbler.dictionary.DictionaryFactory;

public class ClassicDictionaryFactory implements DictionaryFactory {

    private final String fileName;

    public ClassicDictionaryFactory(String fileName) {
        this.fileName = fileName;
    }

    public Dictionary buildAndInitialize() {
        ClassicDictionary dictionary = new ClassicDictionary();
        dictionary.loadWordsFromFile(fileName);
        return dictionary;
    }

}
