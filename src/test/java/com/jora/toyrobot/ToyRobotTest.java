package com.jora.toyrobot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyRobotTest {
    @Test
    public void shouldPlaceRobotInInInitialPlace() throws Exception {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), null);

        //when
        Coordinate lastPosition = toyRobot.roamingAround("");

        //then
        Coordinate expectedPosition = new Coordinate(1,2);
        assertEquals(expectedPosition, lastPosition);
    }

    @Test
    void shouldKeepFaceWhenThereIsNoDirectionMove() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.North);

        //when
        toyRobot.roamingAround("");

        //then
        Direction expectedFace = Direction.North;
        assertEquals(expectedFace, toyRobot.getFace());
    }

    @Test
    void shouldMoveRightInNorthDirection() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.North);

        //when
        Coordinate lastPosition = toyRobot.roamingAround("RIGHT");

        //Then
        Coordinate expectedPosition = new Coordinate(2,2);
        assertEquals(expectedPosition, lastPosition);
        Direction expectedFace = Direction.North;
        assertEquals(expectedFace, toyRobot.getFace());
    }

    @Test
    void shouldMoveLeftInNorthDirection() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.North);

        //when
        Coordinate lastPosition = toyRobot.roamingAround("LEFT");

        //Then
        Coordinate expectedPosition = new Coordinate(0,2);
        assertEquals(expectedPosition, lastPosition);
        Direction expectedFace = Direction.North;
        assertEquals(expectedFace, toyRobot.getFace());
    }

}
