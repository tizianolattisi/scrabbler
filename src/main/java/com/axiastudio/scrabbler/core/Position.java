package com.axiastudio.scrabbler.core;

import java.util.Objects;

public class Position {

    private Integer x, y;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this.x = Integer.valueOf(position.getX());
        this.y = Integer.valueOf(position.getY());
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Position horizontalForwardShift() {
        x++;
        return this;
    }

    public Position verticalForwardShift() {
        y++;
        return this;
    }

    public Position horizontalBackwardShift() {
        x--;
        return this;
    }

    public Position verticalBackwardShift() {
        y--;
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

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
