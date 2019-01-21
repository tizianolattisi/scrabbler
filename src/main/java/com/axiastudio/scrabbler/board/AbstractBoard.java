package com.axiastudio.scrabbler.board;

import com.axiastudio.scrabbler.bag.Bag;
import com.axiastudio.scrabbler.commons.Tile;
import com.axiastudio.scrabbler.dictionary.Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBoard implements Board {

    protected Integer size;
    protected Map<Position, Tile> tiles;
    protected Bag bag;

    public AbstractBoard(Integer size) {
        this.size = size;
        initiazlizeEmptyBoard(size);
    }

    private void initiazlizeEmptyBoard(Integer size) {
        tiles = new HashMap<>();
        for (int x=0; x<size; x++) {
            for(int y=0; y<size; y++) {
                tiles.put(new Position(x, y), new Tile());
            }
        }
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public void setTile(Position position, Tile tile) {
        tiles.put(position, tile);
    }

    @Override
    public Bag bag() {
        return new Bag() {
            @Override
            public Integer getValueOfALetter(String letter) {
                return 1;
            }
        };
    }

    @Override
    public Tile getTile(Position position) {
        Tile tile = tiles.get(position);
        return tile;
    }

    @Override
    public void placeLetterAtPosition(Position position, String letter) {
        Tile tile = tiles.get(position);
        tile.placeLetter(letter);
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
        List<Pattern> horizontalPatterns = new ArrayList<>();
        Integer numberfOfLetters = 7;
        Pattern actualPattern = new Pattern();
        actualPattern.addTile(getTile(position));
        numberfOfLetters--;
        while (numberfOfLetters > 0 && isInBoard(position)) {
            Tile nextTile = getTile(position.horizontalShift());
            actualPattern.addTile(nextTile);
            if (nextTile.isEmpty()) {
                numberfOfLetters--;
            }
            if (actualPattern.isValid()) {
                horizontalPatterns.add(actualPattern.createNewPatternWithSameTiles());
            }
        }
        return horizontalPatterns;
    }

    private List<Pattern> findVerticalPatternFromPosition(Position position) {
        List<Pattern> verticalPatterns = new ArrayList<>();
        return verticalPatterns;
    }

}
