package com.jora.toyrobot;


import com.jora.toyrobot.commands.Command;
import com.jora.toyrobot.commands.MoveCommand;
import com.jora.toyrobot.commands.RotateLeftCommand;
import com.jora.toyrobot.commands.RotateRightCommand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyRobotTest {
    @Test
    public void shouldPlaceRobotInInitialPlace() throws Exception {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), null);

        //when
        List<Command> moves = new ArrayList<Command>();
        Coordinate lastPosition = toyRobot.roamingAround(moves);

        //then
        Coordinate expectedPosition = new Coordinate(1, 2);
        assertEquals(expectedPosition, lastPosition);
    }

    @Test
    void shouldKeepFaceWhenThereIsNoDirectionMove() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH);

        //when
        List<Command> moves = new ArrayList<Command>();
        toyRobot.roamingAround(moves);

        //then
        Direction expectedFace = Direction.NORTH;
        assertEquals(expectedFace, toyRobot.getFace());
    }

    @Test
    void shouldMoveInNorthDirection() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH);

        //when
        List<Command> moves = new ArrayList<Command>();
        moves.add(new MoveCommand());
        Coordinate lastPosition = toyRobot.roamingAround(moves);

        //Then
        Coordinate expectedPosition = new Coordinate(1, 3);
        assertEquals(expectedPosition, lastPosition);
        Direction expectedFace = Direction.NORTH;
        assertEquals(expectedFace, toyRobot.getFace());
    }

    @Test
    void shouldMoveInEastDirection() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.EAST);

        //when
        List<Command> moves = new ArrayList<Command>();
        moves.add(new MoveCommand());
        Coordinate lastPosition = toyRobot.roamingAround(moves);

        //Then
        Coordinate expectedPosition = new Coordinate(2, 2);
        assertEquals(expectedPosition, lastPosition);
        Direction expectedFace = Direction.EAST;
        assertEquals(expectedFace, toyRobot.getFace());
    }

    @Test
    void shouldRotateLeft() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH);

        //when
        List<Command> commands = new ArrayList<Command>();
        commands.add(new RotateLeftCommand());
        Coordinate lastPosition = toyRobot.roamingAround(commands);

        //Then
        Coordinate expectedPosition = new Coordinate(1, 2);
        assertEquals(expectedPosition, lastPosition);
        Direction expectedFace = Direction.WEST;
        assertEquals(expectedFace, toyRobot.getFace());
    }

    @Test
    void shouldRotateRight() {
        //Given
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH);

        //when
        List<Command> commands = new ArrayList<Command>();
        commands.add(new RotateRightCommand());
        Coordinate lastPosition = toyRobot.roamingAround(commands);

        //Then
        Coordinate expectedPosition = new Coordinate(1, 2);
        assertEquals(expectedPosition, lastPosition);
        Direction expectedFace = Direction.EAST;
        assertEquals(expectedFace, toyRobot.getFace());
    }

    @Test
    void shouldMoveOneStepInNorthDirection() {
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH);

        toyRobot.moveOneStep();

        assertEquals(Direction.NORTH, toyRobot.getFace());
        assertEquals(new Coordinate(1, 3), toyRobot.getPosition());
    }

    @Test
    void shouldMoveOneStepInEastDirection() {
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.EAST);

        toyRobot.moveOneStep();

        assertEquals(Direction.EAST, toyRobot.getFace());
        assertEquals(new Coordinate(2, 2), toyRobot.getPosition());
    }

    @Test
    void shouldMoveOneStepInWestDirection() {
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.WEST);

        toyRobot.moveOneStep();

        assertEquals(Direction.WEST, toyRobot.getFace());
        assertEquals(new Coordinate(0, 2), toyRobot.getPosition());
    }

    @Test
    void shouldMoveOneStepInSouthDirection() {
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.SOUTH);

        toyRobot.moveOneStep();

        assertEquals(Direction.SOUTH, toyRobot.getFace());
        assertEquals(new Coordinate(1, 1), toyRobot.getPosition());
    }

    @Test
    void shouldRotateAndMove() {
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.EAST);

        List<Command> commands = new ArrayList<Command>();
        commands.add(new MoveCommand());
        commands.add(new MoveCommand());
        commands.add(new RotateLeftCommand());
        commands.add(new MoveCommand());
        Coordinate lastPosition = toyRobot.roamingAround(commands);


        assertEquals(new Coordinate(3, 3), lastPosition);
        assertEquals(Direction.NORTH, toyRobot.getFace());
    }
}
