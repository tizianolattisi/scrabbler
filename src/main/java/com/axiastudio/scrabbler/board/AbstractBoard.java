package com.axiastudio.scrabbler.board;

import com.axiastudio.scrabbler.commons.Square;
import com.axiastudio.scrabbler.dictionary.Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBoard implements Board {

    protected Integer size;
    protected Map<Position, Square> squares;

    public AbstractBoard(Integer size) {
        this.size = size;
        initiazlizeEmptyBoard(size);
    }

    private void initiazlizeEmptyBoard(Integer size) {
        squares = new HashMap<>();
        for (int x=0; x<size; x++) {
            for(int y=0; y<size; y++) {
                squares.put(new Position(x, y), new Square());
            }
        }
    }

    public void setSquare(Position position, Square square) {
        squares.put(position, square);
    }

    @Override
    public Square getSquare(Position position) {
        Square square = squares.get(position);
        return square;
    }

    @Override
    public void placeLetterAtPosition(Position position, String letter) {
        Square square = squares.get(position);
        square.placeLetter(letter);
        squares.put(position, square);
    }

    @Override
    public List<Pattern> findPossiblesPatterns() {
        ArrayList<Pattern> possibilesPatterns = new ArrayList<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                List<Pattern> newPatterns = findPatternFromPosition(new Position(x, y));
                possibilesPatterns.addAll(newPatterns);
            }
        }
        return possibilesPatterns;
    }

    private boolean isInBoard(Position position) {
        return position.getX()<size-1 && position.getY()<size-1;
    }

    private List<Pattern> findPatternFromPosition(Position position) {
        ArrayList<Pattern> possibilesPatterns = new ArrayList<>();
        possibilesPatterns.addAll(findHorizontalPatternFromPosition(position));
        possibilesPatterns.addAll(findVerticalPatternFromPosition(position));
        return possibilesPatterns;
    }

    private List<Pattern> findHorizontalPatternFromPosition(Position position) {
        return findVerticalPatternFromPosition(position, Boolean.FALSE);

    }

    private List<Pattern> findVerticalPatternFromPosition(Position position) {
        return findVerticalPatternFromPosition(position, Boolean.TRUE);
    }

    private List<Pattern> findVerticalPatternFromPosition(Position position, Boolean vertical) {
        List<Pattern> patterns = new ArrayList<>();
        Integer numberfOfLetters = 7;
        Pattern actualPattern = new Pattern();
        actualPattern.addSquare(getSquare(position));
        numberfOfLetters--;
        while (numberfOfLetters > 0 && isInBoard(position)) {
            if (vertical) {
                position.verticalShift();
            } else {
                position.horizontalShift();
            }
            Square nextSquare = getSquare(position);
            actualPattern.addSquare(nextSquare);
            if (nextSquare.isEmpty()) {
                numberfOfLetters--;
            }
            if (actualPattern.isValid()) {
                patterns.add(actualPattern.createNewPatternWithSameSquares());
            }
        }
        return patterns;
    }

}
