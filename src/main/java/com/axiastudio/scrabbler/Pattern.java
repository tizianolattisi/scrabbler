package com.axiastudio.scrabbler;

import java.util.ArrayList;
import java.util.List;

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

    public Integer length() {
        return tiles.size();
    }

    public Tile getTile(Integer index) {
        return tiles.get(index);
    }

}
