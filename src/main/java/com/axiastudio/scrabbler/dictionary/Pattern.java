package com.axiastudio.scrabbler.dictionary;

import com.axiastudio.scrabbler.commons.LetterOrWord;
import com.axiastudio.scrabbler.commons.Square;

import java.util.ArrayList;
import java.util.List;

public class Pattern {

    private List<Square> squares;

    public Pattern() {
        squares = new ArrayList<>();
    }

    public Pattern(List<Square> squares) {
        this.squares = squares;
    }

    public Pattern addSquare() {
        squares.add(new Square());
        return this;
    }

    public Pattern addSquare(Square square) {
        squares.add(square);
        return this;
    }

    public Pattern createNewPatternWithSameSquares() {
        Pattern newPattern = new Pattern();
        squares.stream().forEach(square -> newPattern.addSquare(new Square(square.getMultiplicator(),
                square.isMultiplicatorForLetter() ? LetterOrWord.LETTER : LetterOrWord.WORD,
                square.getLetter())));
        return newPattern;
    }

    public Integer length() {
        return squares.size();
    }

    public Square getSquare(Integer index) {
        return squares.get(index);
    }

    public Boolean isValid() {
        return length()>1 && squares.stream().filter(t -> !t.isEmpty()).count()>0;
    }

    public Pattern placeWord(String word) {
        for (int i = 0; i< squares.size(); i++) {
            squares.get(i).placeLetter(String.valueOf(word.charAt(i)));
        }
        return this;
    }

    public String word() {
        return squares.stream().map(t -> t.isEmpty() ? "-" : t.getLetter()).reduce(String::concat).get();
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "squares=[" +  word() +
                "]}";
    }

}
