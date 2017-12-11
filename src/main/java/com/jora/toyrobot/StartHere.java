package com.jora.toyrobot;

import com.jora.toyrobot.commands.Command;
import com.jora.toyrobot.commands.CommandParser;

import java.util.List;

public class StartHere {
    public static void main(String[] args) {
        if(args.length == 0 || "".equals(args[0])) {
            throw new IllegalArgumentException("There is no input file specified as parameter.");
        }
        InputFileParser parser = new InputFileParser();
        try {
            List<String> commandLines = parser.parse(args[0]);
            CommandParser commandParser = new CommandParser();
            List<Command> commands = commandParser.parse(commandLines);

            ToyRobot toyRobot = new ToyRobot(new FiveUnitsTableTop());
            toyRobot.roamingAround(commands);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
