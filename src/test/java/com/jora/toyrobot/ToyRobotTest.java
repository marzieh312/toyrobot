package com.jora.toyrobot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyRobotTest {
    @Test
    public void shouldPlaceRobotInInInitialPlace() throws Exception {

        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2));
        Coordinate lastPosition = toyRobot.roamingAround();

        Coordinate expectPosition = new Coordinate(1,2);
        assertEquals(expectPosition, lastPosition);


    }
}
