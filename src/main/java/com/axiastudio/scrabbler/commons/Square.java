package com.axiastudio.scrabbler.commons;

public class Square {

    private String letter;
    private Integer multiplicator;
    private LetterOrWord letterOrWord;

    public Square() {
        multiplicator = 1;
        letterOrWord = LetterOrWord.NONE;
        letter = null;
    }

    public Square(String letter) {
        this.multiplicator = 1;
        this.letterOrWord = LetterOrWord.NONE;
        this.letter = letter;
    }

    public Square(Integer multiplicator, LetterOrWord letterOrWord) {
        this.multiplicator = multiplicator;
        this.letterOrWord = letterOrWord;
        this.letter = null;
    }

    public Square(Integer multiplicator, LetterOrWord letterOrWord, String letter) {
        this.multiplicator = multiplicator;
        this.letterOrWord = letterOrWord;
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public void placeLetter(String letter) {
        this.letter = letter;
    }

    public Boolean isEmpty() {
        return letter == null;
    }

    public Integer getMultiplicator() {
        return multiplicator;
    }

    public Boolean isMultiplicatorForLetter() {
        return letterOrWord.equals(LetterOrWord.LETTER);
    }

    public Boolean isMultiplicatorForWord() {
        return letterOrWord.equals(LetterOrWord.WORD);
    }

    public LetterOrWord getLetterOrWord() {
        return letterOrWord;
    }
}
