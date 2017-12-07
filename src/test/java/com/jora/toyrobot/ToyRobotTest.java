package com.jora.toyrobot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyRobotTest {
    @Test
    public void shouldPlaceRobotInInInitialPlace() throws Exception {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), null);

        //when
        Coordinate lastPosition = toyRobot.roamingAround();

        //then
        Coordinate expectPosition = new Coordinate(1,2);
        assertEquals(expectPosition, lastPosition);
    }

    @Test
    void shouldKeepFaceWhenThereIsNoDirectionMove() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.North);

        //when
        toyRobot.roamingAround();

        //then
        Direction expectFace = Direction.North;
        assertEquals(expectFace, toyRobot.getFace());
    }

    @Test
    void shouldPrintLastPositionAndDirectionWhenCallingReport() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.North);

        //when
        toyRobot.roamingAround();

        //Then
        assertEquals("Output: 0,1,NORTH", toyRobot.getReport());
    }
}
