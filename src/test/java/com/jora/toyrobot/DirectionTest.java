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
}