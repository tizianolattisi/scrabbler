package com.axiastudio.scrabbler.board;

import com.axiastudio.scrabbler.core.Board;
import com.axiastudio.scrabbler.core.Position;
import com.axiastudio.scrabbler.core.Square;
import com.axiastudio.scrabbler.core.Tile;
import com.axiastudio.scrabbler.core.Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBoard implements Board {

    protected Integer size;
    protected Map<Position, Square> squares;

    public AbstractBoard(Integer size) {
        this.size = size;
        initializeEmptyBoard(size);
    }

    private void initializeEmptyBoard(Integer size) {
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
    public Integer size() {
        return size;
    }

    @Override
    public Square getSquare(Position position) {
        return squares.get(position);
    }

    @Override
    public void placeTileAtPosition(Position position, Tile tile) {
        Square square = squares.get(position);
        square.placeTile(tile);
        squares.put(position, square);
    }

    @Override
    public List<Pattern> findPossiblesPatterns() {
        ArrayList<Pattern> possiblesPatterns = new ArrayList<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                List<Pattern> newPatterns = findPatternFromPosition(new Position(x, y));
                possiblesPatterns.addAll(newPatterns);
            }
        }
        return possiblesPatterns;
    }

    private boolean isInBoard(Position position) {
        return position.getX()<size-1 && position.getY()<size-1;
    }

    private List<Pattern> findPatternFromPosition(Position position) {
        ArrayList<Pattern> possiblesPatterns = new ArrayList<>();
        possiblesPatterns.addAll(findHorizontalPatternFromPosition(position));
        possiblesPatterns.addAll(findVerticalPatternFromPosition(position));
        return possiblesPatterns;
    }

    private List<Pattern> findHorizontalPatternFromPosition(Position position) {
        return findVerticalPatternFromPosition(position, Boolean.FALSE);

    }

    private List<Pattern> findVerticalPatternFromPosition(Position position) {
        return findVerticalPatternFromPosition(position, Boolean.TRUE);
    }

    private List<Pattern> findVerticalPatternFromPosition(Position position, Boolean vertical) {
        List<Pattern> patterns = new ArrayList<>();
        Integer numberOfLetters = 7;
        Pattern actualPattern = new Pattern();
        actualPattern.addSquare(getSquare(position));
        numberOfLetters--;
        while (numberOfLetters > 0 && isInBoard(position)) {
            if (vertical) {
                position.verticalShift();
            } else {
                position.horizontalShift();
            }
            Square nextSquare = getSquare(position);
            actualPattern.addSquare(nextSquare);
            if (nextSquare.isEmpty()) {
                numberOfLetters--;
            }
            if (actualPattern.isValid()) {
                patterns.add(actualPattern.createNewPatternWithSameSquares());
            }
        }
        return patterns;
    }

}
