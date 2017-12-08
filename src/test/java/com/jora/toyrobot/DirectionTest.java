package com.jora.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void shouldSeeWestWhenTurnLeftFromNorth() {
        Direction north = Direction.NORTH;
        Direction rotatedDirection = north.turnLeft();
        assertEquals(Direction.WEST, rotatedDirection);
    }

    @Test
    void shouldSeeSouthWhenTurnLeftFromWest() {
        Direction west = Direction.WEST;
        Direction rotatedDirection = west.turnLeft();
        assertEquals(Direction.SOUTH, rotatedDirection);
    }

    @Test
    void shouldSeeEastWhenTurnLeftFromSouth() {
        Direction south = Direction.SOUTH;
        Direction rotatedDirection = south.turnLeft();
        assertEquals(Direction.EAST, rotatedDirection);
    }

    @Test
    void shouldSeeNorthWhenTurnLeftFromEast() {
        Direction east = Direction.EAST;
        Direction rotatedDirection = east.turnLeft();
        assertEquals(Direction.NORTH, rotatedDirection);
    }

    @Test
    void shouldSeeNorthWhenTurnRightFromWest() {
        Direction west = Direction.WEST;
        Direction rotatedDirection = west.turnRight();
        assertEquals(Direction.NORTH, rotatedDirection);
    }

    @Test
    void shouldSeeEastWhenTurnRightFromNorth() {
        Direction west = Direction.NORTH;
        Direction rotatedDirection = west.turnRight();
        assertEquals(Direction.EAST, rotatedDirection);
    }

    @Test
    void shouldSeeSouthWhenTurnRightFromEast() {
        Direction west = Direction.EAST;
        Direction rotatedDirection = west.turnRight();
        assertEquals(Direction.SOUTH, rotatedDirection);
    }

    @Test
    void shouldSeeWestWhenTurnRightFromSouth() {
        Direction west = Direction.SOUTH;
        Direction rotatedDirection = west.turnRight();
        assertEquals(Direction.WEST, rotatedDirection);
    }
}