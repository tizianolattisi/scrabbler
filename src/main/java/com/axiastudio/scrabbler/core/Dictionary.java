package com.axiastudio.scrabbler.core;

import java.util.List;

public interface Dictionary {

    Integer numberOfWords();
    Boolean checkWordExistence(String word);
    List<String> words();

}
