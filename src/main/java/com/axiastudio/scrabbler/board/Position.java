package com.axiastudio.scrabbler.board;

import java.util.Objects;

public class Position {

    private Integer x, y;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Position horizontalShift() {
        x++;
        return this;
    }

    public Position verticalShift() {
        y++;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x.equals(position.x) &&
                y.equals(position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
