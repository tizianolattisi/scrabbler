package com.axiastudio.scrabbler.board;

import com.axiastudio.scrabbler.core.*;

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
        return position.getX()>=0 && position.getY()>=0 && position.getX()<size-1 && position.getY()<size-1;
    }

    private List<Pattern> findPatternFromPosition(Position position) {
        ArrayList<Pattern> possiblesPatterns = new ArrayList<>();
        possiblesPatterns.addAll(findHorizontalPatternFromPosition(position));
        possiblesPatterns.addAll(findVerticalPatternFromPosition(position));
        return possiblesPatterns;
    }

    private List<Pattern> findHorizontalPatternFromPosition(Position position) {
        return findPatternFromPositionAndOrientation(position, Orientation.HORIZONTAL);

    }

    private List<Pattern> findVerticalPatternFromPosition(Position position) {
        return findPatternFromPositionAndOrientation(position, Orientation.VERTICAL);
    }

    private List<Pattern> findPatternFromPositionAndOrientation(Position position, Orientation orientation) {
        List<Pattern> patterns = new ArrayList<>();
        if (isAValidStartingSquare(position, orientation)) {
            Position cursor = new Position(position);
            Integer remainingLetters = 7;
            Pattern patternUnderConstruction = new Pattern(new Position(position), orientation);
            Square firstSquare = getSquare(cursor);
            patternUnderConstruction.addSquare(firstSquare);
            if (firstSquare.isEmpty()) {
                remainingLetters--;
            }
            moveCursorForward(orientation, cursor);
            while (shouldWeMoveToNextSquare(cursor, remainingLetters)) {
                Square nextSquare = getSquare(cursor);
                patternUnderConstruction.addSquare(nextSquare);
                if (nextSquare.isEmpty()) {
                    remainingLetters--;
                }
                moveCursorForward(orientation, cursor);
                if ((!isInBoard(cursor) || getSquare(cursor).isEmpty()) && remainingLetters<7 && patternUnderConstruction.isValid()) {
                    Pattern newPatternWithSameSquares = patternUnderConstruction.createNewPatternWithSameSquares();
                    patterns.add(newPatternWithSameSquares);
                }
            }
        }
        return patterns;
    }

    private Boolean isAValidStartingSquare(Position position, Orientation orientation) {
        Position cursor = new Position(position);
        if (orientation.equals(Orientation.HORIZONTAL)) {
            cursor.horizontalBackwardShift();
        } else {
            cursor.verticalBackwardShift();
        }
        return !isInBoard(cursor) || getSquare(cursor).isEmpty();
    }

    private boolean shouldWeMoveToNextSquare(Position cursor, Integer remainingLetters) {
        return isInBoard(cursor) && (!getSquare(cursor).isEmpty() || remainingLetters > 0);
    }

    private void moveCursorForward(Orientation orientation, Position cursor) {
        if (Orientation.VERTICAL.equals(orientation)) {
            cursor.verticalForwardShift();
        } else {
            cursor.horizontalForwardShift();
        }
    }

}
