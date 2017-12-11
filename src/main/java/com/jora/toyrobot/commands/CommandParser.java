package com.jora.toyrobot.commands;

import com.jora.toyrobot.Coordinate;
import com.jora.toyrobot.Direction;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
    private static Map<String, Command> commandTemplates = new HashMap<String, Command>() {{
        put("LEFT", new RotateLeftCommand());
        put("RIGHT", new RotateRightCommand());
        put("MOVE", new MoveCommand());
        put("REPORT", new ReportCommand());
    }};

    public Command parse(String commandStr) throws Exception {
        if(isPlaceCommand(commandStr)) {
            return getPlaceCommand(commandStr);
        }
        Command command = commandTemplates.get(commandStr);
        if(command == null) {
            throw new Exception(commandStr + " is an invalid command ");
        }
        return command;
    }

    private boolean isPlaceCommand(String command) {
        return "PLACE".equals(command.trim().split(" ")[0]);
    }

    private Command getPlaceCommand(String command) throws Exception {
        String[] placeCmdParts = command.trim().split(" ");
        if(placeCmdParts.length != 2) {
            throw new Exception("Invalid place command");
        }

        String[] placeCmdInfo = placeCmdParts[1].split(",");
        if(placeCmdInfo.length != 3) {
            throw new Exception("Invalid place command");
        }

        try {
            return new PlaceCommand(new Coordinate(Integer.parseInt(placeCmdInfo[0]),
                    Integer.parseInt(placeCmdInfo[1])),
                    Direction.valueOf(placeCmdInfo[2]));
        } catch (NumberFormatException exception) {
            throw new Exception("Invalid place command");
        }
    }
}
