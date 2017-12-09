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
        switch (direction) {
            case EAST:
                this.coordinate = new Coordinate(this.coordinate.getX() + 1, this.coordinate.getY());
                break;

            case WEST:
                this.coordinate = new Coordinate(this.coordinate.getX() - 1, this.coordinate.getY());
                break;

            case NORTH:
                this.coordinate = new Coordinate(this.coordinate.getX(), this.coordinate.getY() + 1);
                break;

            case SOUTH:
                this.coordinate = new Coordinate(this.coordinate.getX(), this.coordinate.getY() - 1);
                break;
        }
    }

    public Direction getFace() {
        return direction;
    }

    public void rotateLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void rotateRight() {
        this.direction = this.direction.turnRight();
    }

    public Coordinate getPosition() {
        return this.coordinate;
    }
}
