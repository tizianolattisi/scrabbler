package com.axiastudio.scrabbler.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pattern {

    private List<Square> squares;
    private Optional<Orientation> orientation;
    private Optional<Position> position;

    public Pattern() {
        this.orientation = Optional.empty();
        this.position = Optional.empty();
        squares = new ArrayList<>();
    }

    public Pattern(Position position, Orientation orientation) {
        this.orientation = Optional.of(orientation);
        this.position = Optional.of(position);
        this.squares = new ArrayList<>();
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
        Pattern newPattern;
        if (position.isPresent() && orientation.isPresent()) {
            newPattern = new Pattern(position.get(), orientation.get());
        } else {
            newPattern = new Pattern();
        }
        squares.stream().forEach(square -> newPattern.addSquare(new Square(square.getMultiplicator(),
                square.getMultipliactorFor(),
                square.getTile())));
        return newPattern;
    }

    public Integer length() {
        return squares.size();
    }

    public Square getSquare(Integer index) {
        return squares.get(index);
    }

    public Pattern placeWord(String word) {
        for (int i = 0; i< squares.size(); i++) {
            Tile tile = new LetterTile(String.valueOf(word.charAt(i)));
            squares.get(i).placeTile(tile);
        }
        return this;
    }

    public String word() {
        return squares.stream().map(t -> t.isEmpty() ? "-" : t.getTile().letter()).reduce(String::concat).get();
    }

    public Optional<Position> position() {
        return position;
    }

    public Optional<Orientation> orientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "squares=[" +  word() +
                "]}";
    }

}
