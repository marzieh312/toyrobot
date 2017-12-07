package com.jora.toyrobot;

import com.jora.toyrobot.commands.Command;

public class ToyRobot {
    private Coordinate coordinate;
    private Direction direction;

    public ToyRobot(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate roamingAround(Command command) {
        if(command != null) {
            command.execute(this);
        }
        return this.coordinate;
    }

    public void moveLeftOneStep() {
        this.coordinate = new Coordinate(this.coordinate.getX() - 1, this.coordinate.getY());
    }

    public void moveRightOneStep() {
        this.coordinate = new Coordinate(this.coordinate.getX() + 1, this.coordinate.getY());
    }

    public Direction getFace() {
        return direction;
    }

}
