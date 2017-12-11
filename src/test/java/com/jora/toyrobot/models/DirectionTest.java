package com.jora.toyrobot.models;


import com.jora.toyrobot.models.Direction;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

class DirectionTest {

    @Test
    public void shouldSeeWestWhenTurnLeftFromNorth() {
        Direction north = Direction.NORTH;
        Direction rotatedDirection = north.turnLeft();
        assertEquals(Direction.WEST, rotatedDirection);
    }

    @Test
    public void shouldSeeSouthWhenTurnLeftFromWest() {
        Direction west = Direction.WEST;
        Direction rotatedDirection = west.turnLeft();
        assertEquals(Direction.SOUTH, rotatedDirection);
    }

    @Test
    public void shouldSeeEastWhenTurnLeftFromSouth() {
        Direction south = Direction.SOUTH;
        Direction rotatedDirection = south.turnLeft();
        assertEquals(Direction.EAST, rotatedDirection);
    }

    @Test
    public void shouldSeeNorthWhenTurnLeftFromEast() {
        Direction east = Direction.EAST;
        Direction rotatedDirection = east.turnLeft();
        assertEquals(Direction.NORTH, rotatedDirection);
    }

    @Test
    public void shouldSeeNorthWhenTurnRightFromWest() {
        Direction west = Direction.WEST;
        Direction rotatedDirection = west.turnRight();
        assertEquals(Direction.NORTH, rotatedDirection);
    }

    @Test
    public void shouldSeeEastWhenTurnRightFromNorth() {
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

    @Test
    void shouldReturnOneForDeltaXWhenFacingEast() {
        Direction east = Direction.EAST;
        assertEquals(1, east.getDeltaX());
    }

    @Test
    void shouldReturnZeroForDeltaYWhenFacingEast() {
        Direction east = Direction.EAST;
        assertEquals(0, east.getDeltaY());
    }

    @Test
    void shouldReturnMinusOneForDeltaXWhenFacingWest() {
        Direction west = Direction.WEST;
        assertEquals(-1, west.getDeltaX());
    }

    @Test
    void shouldReturnZeroForDeltaYWhenFacingWEST() {
        Direction west = Direction.WEST;
        assertEquals(0, west.getDeltaY());
    }

    @Test
    void shouldReturnZeroForDeltaXWhenFacingNorth() {
        Direction north = Direction.NORTH;
        assertEquals(0, north.getDeltaX());
    }

    @Test
    void shouldReturnZeroForDeltaXWhenFacingSouth() {
        Direction south = Direction.SOUTH;
        assertEquals(0, south.getDeltaX());
    }

    @Test
    void shouldReturnOneForDeltaYWhenFacingNorth() {
        Direction north = Direction.NORTH;
        assertEquals(1, north.getDeltaY());
    }

    @Test
    void shouldReturnMinusOneForDeltaYWhenFacingSouth() {
        Direction south = Direction.SOUTH;
        assertEquals(-1, south.getDeltaY());
    }
}