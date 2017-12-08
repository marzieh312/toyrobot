package com.jora.toyrobot;

import com.jora.toyrobot.commands.Command;

import java.util.List;

public class ToyRobot {
    private Coordinate coordinate;
    private Direction direction;

    public ToyRobot(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate roamingAround(List<Command> commands) {
        for(Command command: commands) {
            command.execute(this);
        }
        return this.coordinate;
    }

    public void moveOneStep() {
        this.coordinate = new Coordinate(this.coordinate.getX() + 1, this.coordinate.getY());
    }

    public Direction getFace() {
        return direction;
    }

    public void rotateLeft() {
        this.direction = this.direction.turnLeft();
    }
}
