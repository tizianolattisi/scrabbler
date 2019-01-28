package com.axiastudio.scrabbler.core;

public class Square {

    private Tile tile;
    private Integer multiplicator;
    private LetterOrWord letterOrWord;

    public Square() {
        multiplicator = 1;
        letterOrWord = LetterOrWord.NONE;
        tile = null;
    }

    public Square(Tile tile) {
        this.multiplicator = 1;
        this.letterOrWord = LetterOrWord.NONE;
        this.tile = tile;
    }

    public Square(Integer multiplicator, LetterOrWord letterOrWord) {
        this.multiplicator = multiplicator;
        this.letterOrWord = letterOrWord;
        this.tile = null;
    }

    public Square(Integer multiplicator, LetterOrWord letterOrWord, Tile tile) {
        this.multiplicator = multiplicator;
        this.letterOrWord = letterOrWord;
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public void placeTile(Tile tile) {
        this.tile = tile;
    }

    public Boolean isEmpty() {
        return tile == null;
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

    public LetterOrWord getMultipliactorFor() {
        return letterOrWord;
    }
}
