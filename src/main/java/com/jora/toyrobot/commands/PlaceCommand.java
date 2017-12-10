package com.jora.toyrobot.commands;

import com.jora.toyrobot.Coordinate;
import com.jora.toyrobot.Direction;
import com.jora.toyrobot.ToyRobot;

public class PlaceCommand implements Command {
    private Coordinate coordinate;
    private Direction direction;

    public PlaceCommand(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public void execute(ToyRobot toyRobot) {
        toyRobot.place(coordinate, direction);
    }
}
