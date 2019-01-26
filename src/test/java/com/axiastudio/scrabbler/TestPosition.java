package com.axiastudio.scrabbler;

import com.axiastudio.scrabbler.core.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPosition {

    @Test
    public void testCreation() {
        Position position = new Position(3, 7);
        Assertions.assertEquals(3, position.getX());
        Assertions.assertEquals(7, position.getY());
    }

    @Test
    public void testShift() {
        Position position = new Position(3, 7);
        position.horizontalForwardShift();
        Assertions.assertEquals(4, position.getX());
        position.verticalForwardShift();
        Assertions.assertEquals(8, position.getY());
        position.horizontalBackwardShift();
        position.verticalBackwardShift();
        Assertions.assertEquals(3, position.getX());
        Assertions.assertEquals(7, position.getY());
    }

    @Test
    public void testPositionFromPosition() {
        Position origin = new Position(13, 9);
        Position destination = new Position(origin);
        destination.horizontalForwardShift();
        destination.verticalForwardShift();
        Assertions.assertNotEquals(origin.getX(), destination.getX());
        Assertions.assertNotEquals(origin.getY(), destination.getY());
        Assertions.assertEquals(1, destination.getX() - origin.getX());
    }
}
