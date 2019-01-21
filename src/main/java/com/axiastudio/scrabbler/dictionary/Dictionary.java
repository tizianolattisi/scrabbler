package com.axiastudio.scrabbler.dictionary;

import java.util.List;

public interface Dictionary {

    Integer numberOfWords();
    Boolean checkWordExistence(String word);
    List<Pattern> discoverWordsByLettersAndPattern(String letters, Pattern pattern);

}
