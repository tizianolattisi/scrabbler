package com.axiastudio.scrabbler;

import java.util.List;

public interface Dictionary {

    Integer numberOfWords();
    Boolean checkWordExistence(String word);
    List<String> discoverWordsByLettersAndPattern(String letters, Pattern pattern);

}
