package com.axiastudio.scrabbler.dictionary;

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
