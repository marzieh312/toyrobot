package com.jora.toyrobot;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InputFileParserTest {
    @Test
    public void shouldReturnCommands() throws Exception {
        InputFileParser parser = new InputFileParser();

        List<String> commands = parser.parse("valid-input.txt");

        assertEquals(commands.size(), 6);
        assertEquals(commands.get(0), "PLACE 1,2,EAST");
        assertEquals(commands.get(5), "REPORT");
    }

    @Test
    public void shouldReturnEmptyListIfFileEmpty() throws Exception {
        InputFileParser parser = new InputFileParser();

        List<String> commands = parser.parse("empty-input.txt");

        assertEquals(commands.size(), 0);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfFileDoesNotExist() throws Exception{
        InputFileParser parser = new InputFileParser();

        parser.parse("non-existent.txt");
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfInvalidInputFileName() throws Exception{
        InputFileParser parser = new InputFileParser();

        parser.parse(null);
    }
}