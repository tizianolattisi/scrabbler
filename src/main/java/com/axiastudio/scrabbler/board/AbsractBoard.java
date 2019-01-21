package com.axiastudio.scrabbler.board;

import com.axiastudio.scrabbler.commons.Tile;

import java.util.HashMap;
import java.util.Map;

public abstract class AbsractBoard implements Board {

    protected Integer size;
    protected Map<Position, Tile> tiles;

    public AbsractBoard(Integer size) {
        this.size = size;
        tiles = new HashMap<>();
    }

    public void setTile(Position position, Tile tile) {
        tiles.put(position, tile);
    }

    @Override
    public Tile getTile(Position position) {
        return tiles.get(position);
    }

}
