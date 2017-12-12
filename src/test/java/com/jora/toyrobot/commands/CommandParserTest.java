package com.jora.toyrobot.commands;

import com.jora.toyrobot.commands.Command;
import com.jora.toyrobot.commands.CommandParser;
import com.jora.toyrobot.commands.MoveCommand;
import com.jora.toyrobot.commands.PlaceCommand;
import com.jora.toyrobot.commands.ReportCommand;
import com.jora.toyrobot.commands.RotateLeftCommand;
import com.jora.toyrobot.commands.RotateRightCommand;
import com.jora.toyrobot.models.Coordinate;
import com.jora.toyrobot.models.Direction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CommandParserTest {

    @Test
    public void shouldParseListOfCommands() throws Exception {
        List<String> commands = new ArrayList<>();
        commands.add("PLACE 0,0,NORTH");
        commands.add("MOVE");

        List<Command> listOfCommands = CommandParser.parse(commands);
        assertEquals(listOfCommands.size(), 2);
        assertTrue(listOfCommands.get(0) instanceof PlaceCommand);
        assertTrue(listOfCommands.get(1) instanceof MoveCommand);

    }

    @Test
    public void shouldParsePlaceCommand() throws Exception {
        List<Command> actualCommand = CommandParser.parse(Arrays.asList("PLACE 0,0,NORTH"));

        Command expectedCommand = new PlaceCommand(new Coordinate(0, 0), Direction.NORTH);
        assertTrue(actualCommand.get(0) instanceof PlaceCommand);
        assertEquals(expectedCommand, actualCommand.get(0));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfInvalidPlaceCommand() throws Exception {
        CommandParser.parse(Arrays.asList("PLACE0,0,NORTH"));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfInvalidXYInPlaceCommand() throws Exception {
        CommandParser.parse(Arrays.asList("PLACE x,y,NORTH"));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfInvalidDirectionInPlaceCommand() throws Exception {
        CommandParser.parse(Arrays.asList("PLACE 0,1,BLAH"));
    }

    @Test
    public void shouldParseMoveCommand() throws Exception {
        List<Command> actualCommand = CommandParser.parse(Arrays.asList("MOVE"));

        assertTrue(actualCommand.get(0) instanceof MoveCommand);
    }

    @Test
    public void shouldParseRotateLeftCommand() throws Exception {
        List<Command> actualCommand = CommandParser.parse(Arrays.asList("LEFT"));

        assertTrue(actualCommand.get(0) instanceof RotateLeftCommand);
    }

    @Test
    public void shouldParseRotateRightCommand() throws Exception {
        List<Command> actualCommand = CommandParser.parse(Arrays.asList("RIGHT"));

        assertTrue(actualCommand.get(0) instanceof RotateRightCommand);
    }

    @Test
    public void shouldParseReportCommand() throws Exception {
        List<Command> actualCommand = CommandParser.parse(Arrays.asList("REPORT"));

        assertTrue(actualCommand.get(0) instanceof ReportCommand);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionForInvalidCommand() throws Exception {
        CommandParser.parse(Arrays.asList("BLAH"));
    }
}
