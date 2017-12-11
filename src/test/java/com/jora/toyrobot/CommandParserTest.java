package com.jora.toyrobot;

import com.jora.toyrobot.commands.Command;
import com.jora.toyrobot.commands.CommandParser;
import com.jora.toyrobot.commands.MoveCommand;
import com.jora.toyrobot.commands.PlaceCommand;
import com.jora.toyrobot.commands.ReportCommand;
import com.jora.toyrobot.commands.RotateLeftCommand;
import com.jora.toyrobot.commands.RotateRightCommand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CommandParserTest {
    private CommandParser parser = new CommandParser();

    @Test
    public void shouldParseListOfCommands() throws Exception {
        List<String> commands = new ArrayList<>();
        commands.add("PLACE 0,0,NORTH");
        commands.add("MOVE");

        List<Command> listOfCommands = parser.parse(commands);
        assertEquals(listOfCommands.size(), 2);
        assertTrue(listOfCommands.get(0) instanceof PlaceCommand);
        assertTrue(listOfCommands.get(1) instanceof MoveCommand);

    }

    @Test
    public void shouldParsePlaceCommand() throws Exception {
        Command actualCommand = parser.parse("PLACE 0,0,NORTH");

        Command expectedCommand = new PlaceCommand(new Coordinate(0, 0), Direction.NORTH);
        assertTrue(actualCommand instanceof PlaceCommand);
        assertEquals(expectedCommand, actualCommand);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfInvalidPlaceCommand() throws Exception {
        parser.parse("PLACE0,0,NORTH");
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfInvalidXYInPlaceCommand() throws Exception {
        parser.parse("PLACE x,y,NORTH");
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfInvalidDirectionInPlaceCommand() throws Exception {
        parser.parse("PLACE 0,1,BLAH");
    }

    @Test
    public void shouldParseMoveCommand() throws Exception {
        Command actualCommand = parser.parse("MOVE");

        assertTrue(actualCommand instanceof MoveCommand);
    }

    @Test
    public void shouldParseRotateLeftCommand() throws Exception {
        Command actualCommand = parser.parse("LEFT");

        assertTrue(actualCommand instanceof RotateLeftCommand);
    }

    @Test
    public void shouldParseRotateRightCommand() throws Exception {
        Command actualCommand = parser.parse("RIGHT");

        assertTrue(actualCommand instanceof RotateRightCommand);
    }

    @Test
    public void shouldParseReportCommand() throws Exception {
        Command actualCommand = parser.parse("REPORT");

        assertTrue(actualCommand instanceof ReportCommand);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionForInvalidCommand() throws Exception {
        parser.parse("BLAH");
    }
}
