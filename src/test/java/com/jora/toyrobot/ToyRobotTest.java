package com.jora.toyrobot;


import com.jora.toyrobot.commands.Command;
import com.jora.toyrobot.commands.MoveCommand;
import com.jora.toyrobot.commands.RotateLeftCommand;
import com.jora.toyrobot.commands.RotateRightCommand;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyRobotTest {
    @Test
    public void shouldPlaceRobotInInitialPlace() throws Exception {
        //Given
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), null, tableTop);

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
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH, tableTop);

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
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH, tableTop);

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
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.EAST, tableTop);

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
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH, tableTop);

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
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH, tableTop);

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
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.NORTH, toyRobot.getFace());
        assertEquals(new Coordinate(1, 3), toyRobot.getPosition());
    }

    @Test
    void shouldMoveOneStepInEastDirection() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.EAST, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.EAST, toyRobot.getFace());
        assertEquals(new Coordinate(2, 2), toyRobot.getPosition());
    }

    @Test
    void shouldMoveOneStepInWestDirection() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.WEST, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.WEST, toyRobot.getFace());
        assertEquals(new Coordinate(0, 2), toyRobot.getPosition());
    }

    @Test
    void shouldMoveOneStepInSouthDirection() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.SOUTH, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.SOUTH, toyRobot.getFace());
        assertEquals(new Coordinate(1, 1), toyRobot.getPosition());
    }

    @Test
    void shouldRotateAndMove() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.EAST, tableTop);

        List<Command> commands = new ArrayList<Command>();
        commands.add(new MoveCommand());
        commands.add(new MoveCommand());
        commands.add(new RotateLeftCommand());
        commands.add(new MoveCommand());
        Coordinate lastPosition = toyRobot.roamingAround(commands);


        assertEquals(new Coordinate(3, 3), lastPosition);
        assertEquals(Direction.NORTH, toyRobot.getFace());
    }

    @Test
    void shouldNotFallOfTableWhenMoving() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(0, 0), Direction.SOUTH, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.SOUTH, toyRobot.getFace());
        assertEquals(new Coordinate(0, 0), toyRobot.getPosition());
    }
}
