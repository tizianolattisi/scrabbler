package com.axiastudio.scrabbler.dictionary;

import com.axiastudio.scrabbler.commons.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Pattern {

    private List<Tile> tiles;

    public Pattern() {
        tiles = new ArrayList<>();
    }

    public Pattern(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public Pattern addTile() {
        tiles.add(new Tile());
        return this;
    }

    public Pattern addTile(Tile tile) {
        tiles.add(tile);
        return this;
    }

    public Pattern createNewPatternWithSameTiles() {
        Pattern newPattern = new Pattern();
        tiles.stream().forEach(t -> newPattern.addTile(t));
        return newPattern;
    }

    public Integer length() {
        return tiles.size();
    }

    public Tile getTile(Integer index) {
        return tiles.get(index);
    }

    public Boolean isValid() {
        return length()>1 && tiles.stream().filter(t -> !t.isEmpty()).count()>0;
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "tiles=[" + tiles.stream().map(t -> t.isEmpty() ? "-" : t.getLetter()).reduce(String::concat).get() +
                "]}";
    }

}
