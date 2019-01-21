package com.axiastudio.scrabbler.engine;

import com.axiastudio.scrabbler.board.Board;
import com.axiastudio.scrabbler.board.BoardFactory;
import com.axiastudio.scrabbler.board.Position;
import com.axiastudio.scrabbler.dictionary.Dictionary;
import com.axiastudio.scrabbler.dictionary.DictionaryFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    private Board board;
    private Dictionary dictionary;

    public Engine(BoardFactory boardFactory, DictionaryFactory dictionaryFactory) {
        board = boardFactory.buildAndInitialize();
        dictionary = dictionaryFactory.buildAndInitialize();
    }

    public void placeLetter(Integer x, Integer y, String letter) {
        board.placeLetterAtPosition(new Position(x, y), letter);
    }

    public List<String> findSolutions(String lettersInYourHand) {
        List<String> solutions = board.findPossiblesPatterns().stream()
                .map(pattern -> dictionary.discoverWordsByLettersAndPattern(lettersInYourHand, pattern))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return solutions;
    }

}
