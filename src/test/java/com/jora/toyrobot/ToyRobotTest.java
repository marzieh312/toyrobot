package com.jora.toyrobot;


import com.jora.toyrobot.commands.Command;
import com.jora.toyrobot.commands.MoveCommand;
import com.jora.toyrobot.commands.PlaceCommand;
import com.jora.toyrobot.commands.RotateLeftCommand;
import com.jora.toyrobot.commands.RotateRightCommand;
import com.jora.toyrobot.models.Coordinate;
import com.jora.toyrobot.models.Direction;
import com.jora.toyrobot.models.FiveUnitsTableTop;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;


public class ToyRobotTest {
   @Test
    public void shouldMoveInNorthDirection() {
        //Given
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(tableTop);

        //when
        List<Command> moves = new ArrayList<Command>();
        moves.add(new PlaceCommand(new Coordinate(1, 2), Direction.NORTH));
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
        ToyRobot toyRobot = new ToyRobot(tableTop);

        //when
        List<Command> moves = new ArrayList<Command>();
        moves.add(new PlaceCommand(new Coordinate(1, 2), Direction.EAST));
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
        ToyRobot toyRobot = new ToyRobot(tableTop);

        //when
        List<Command> commands = new ArrayList<Command>();
        commands.add(new PlaceCommand(new Coordinate(1, 2), Direction.NORTH));
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
        ToyRobot toyRobot = new ToyRobot(tableTop);

        //when
        List<Command> commands = new ArrayList<Command>();
        commands.add(new PlaceCommand(new Coordinate(1, 2), Direction.NORTH));
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
        ToyRobot toyRobot = new ToyRobot(tableTop);

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
        ToyRobot toyRobot = new ToyRobot(tableTop);

        //when
        List<Command> commands = new ArrayList<Command>();
        commands.add(new PlaceCommand(new Coordinate(3, 6), Direction.WEST));
        Coordinate lastPosition = toyRobot.roamingAround(commands);

        //Then
        assertNull(lastPosition);
        assertNull(toyRobot.getFace());
    }

    @Test
    public void shouldRotateAndMove() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(tableTop);

        List<Command> commands = new ArrayList<Command>();
        commands.add(new PlaceCommand(new Coordinate(1, 2), Direction.EAST));
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
        ToyRobot toyRobot = new ToyRobot(tableTop);

        List<Command> commands = new ArrayList<Command>();
        commands.add(new PlaceCommand(new Coordinate(0, 0), Direction.SOUTH));
        commands.add(new MoveCommand());

        toyRobot.roamingAround(commands);


        assertEquals(Direction.SOUTH, toyRobot.getFace());
        assertEquals(new Coordinate(0, 0), toyRobot.getPosition());
    }

    @Test
    public void shouldIgnoreAllTheCommandsBeforeFirstPlaceCommand() throws Exception {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(tableTop);

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

    @Test
    public void shouldNotPlaceRobotIfNewPositionIsOutOfTableBorder() {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(tableTop);

        toyRobot.place(new Coordinate(5, 5), Direction.EAST);

        assertNull(toyRobot.getPosition());
        assertNull(toyRobot.getFace());

    }

    @Test
    public void shouldNotMoveIfNewPositionIsOutOfTableBorder() throws Exception {
        FiveUnitsTableTop tableTop = new FiveUnitsTableTop();
        ToyRobot toyRobot = new ToyRobot(tableTop);

        toyRobot.place(new Coordinate(0, 0), Direction.WEST);
        toyRobot.moveOneStep();

        assertEquals(new Coordinate(0, 0), toyRobot.getPosition());
        assertEquals(Direction.WEST, toyRobot.getFace());
    }
}
