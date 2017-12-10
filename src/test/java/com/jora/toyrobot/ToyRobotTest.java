package com.jora.toyrobot;


import com.jora.toyrobot.commands.Command;
import com.jora.toyrobot.commands.MoveCommand;
import com.jora.toyrobot.commands.PlaceCommand;
import com.jora.toyrobot.commands.RotateLeftCommand;
import com.jora.toyrobot.commands.RotateRightCommand;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;


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
    public void shouldKeepFaceWhenThereIsNoDirectionMove() {
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
    public void shouldMoveInNorthDirection() {
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
    public void shouldMoveInEastDirection() {
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
    public void shouldRotateLeft() {
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
    public void shouldRotateRight() {
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
    public void shouldPlaceRobotInSpecifiedPositionAndDirectionOnTable() {
        //Given
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH, tableTop);

        //when
        List<Command> commands = new ArrayList<Command>();
        commands.add(new PlaceCommand(new Coordinate(3, 3), Direction.WEST));
        Coordinate lastPosition = toyRobot.roamingAround(commands);

        //Then
        assertEquals(new Coordinate(3, 3), lastPosition);
        assertEquals(Direction.WEST, toyRobot.getFace());
    }

    @Test
    public void shouldNotPlaceRobotIfNewPositionNotInsideTableBorders() {
        //Given
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH, tableTop);

        //when
        List<Command> commands = new ArrayList<Command>();
        commands.add(new PlaceCommand(new Coordinate(3, 6), Direction.WEST));
        Coordinate lastPosition = toyRobot.roamingAround(commands);

        //Then
        assertEquals(new Coordinate(1, 2), lastPosition);
        assertEquals(Direction.NORTH, toyRobot.getFace());
    }



    @Test
    public void shouldMoveOneStepInNorthDirection() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.NORTH, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.NORTH, toyRobot.getFace());
        assertEquals(new Coordinate(1, 3), toyRobot.getPosition());
    }

    @Test
    public void shouldMoveOneStepInEastDirection() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.EAST, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.EAST, toyRobot.getFace());
        assertEquals(new Coordinate(2, 2), toyRobot.getPosition());
    }

    @Test
    public void shouldMoveOneStepInWestDirection() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.WEST, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.WEST, toyRobot.getFace());
        assertEquals(new Coordinate(0, 2), toyRobot.getPosition());
    }

    @Test
    public void shouldMoveOneStepInSouthDirection() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(1, 2), Direction.SOUTH, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.SOUTH, toyRobot.getFace());
        assertEquals(new Coordinate(1, 1), toyRobot.getPosition());
    }

    @Test
    public void shouldRotateAndMove() {
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
    public void shouldNotFallOfTableWhenMoving() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(new Coordinate(0, 0), Direction.SOUTH, tableTop);

        toyRobot.moveOneStep();

        assertEquals(Direction.SOUTH, toyRobot.getFace());
        assertEquals(new Coordinate(0, 0), toyRobot.getPosition());
    }

    @Test
    public void shouldIgnoreAllTheCommandsBeforeFirstPlaceCommand() throws Exception {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(null, null, tableTop);

        List<Command> commands = new ArrayList<Command>();
        Command moveCommand = Mockito.spy(new MoveCommand());
        Command rotateLeftCommand = Mockito.spy(new RotateLeftCommand());
        Command placeCommand = Mockito.spy(new PlaceCommand(new Coordinate(3, 4), Direction.SOUTH));

        commands.add(moveCommand);
        commands.add(rotateLeftCommand);
        commands.add(placeCommand);

        Coordinate lastPosition = toyRobot.roamingAround(commands);

        verify(moveCommand, never()).execute(toyRobot);
        verify(rotateLeftCommand, never()).execute(toyRobot);
        verify(placeCommand, times(1)).execute(toyRobot);

        assertEquals(new Coordinate(3, 4), lastPosition);
        assertEquals(Direction.SOUTH, toyRobot.getFace());
    }
}
