package com.axiastudio.scrabbler.dictionary;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDictionary implements Dictionary {

    protected List<String> words = new ArrayList<>();

    @Override
    public List<String> words() {
        return words;
    }

}
