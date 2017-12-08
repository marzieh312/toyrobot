package com.jora.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void shouldFaceWestWhenRotateLeftFromNorth() {
        Direction currentDirection = Direction.NORTH;
        Direction rotatedDirection = currentDirection.rotateLeft();
        assertEquals(Direction.WEST, rotatedDirection);
    }

    @Test
    void shouldFaceSouthWhenRotateLeftFromWest() {
        Direction currentDirection = Direction.WEST;
        Direction rotatedDirection = currentDirection.rotateLeft();
        assertEquals(Direction.SOUTH, rotatedDirection);
    }

    @Test
    void shouldFaceEastWhenRotateLeftFromSouth() {
        Direction currentDirection = Direction.SOUTH;
        Direction rotatedDirection = currentDirection.rotateLeft();
        assertEquals(Direction.EAST, rotatedDirection);
    }

    @Test
    void shouldFaceNorthWhenRotateLeftFromEast() {
        Direction currentDirection = Direction.EAST;
        Direction rotatedDirection = currentDirection.rotateLeft();
        assertEquals(Direction.NORTH, rotatedDirection);
    }
}