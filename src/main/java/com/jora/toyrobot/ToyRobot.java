package com.jora.toyrobot;

import com.jora.toyrobot.commands.Command;

import java.util.List;

public class ToyRobot {
    private Coordinate coordinate;
    private FiveUnitsTableTop tableTop;
    private Direction direction;

    public ToyRobot(Coordinate coordinate, Direction direction, FiveUnitsTableTop tableTop) {
        this.coordinate = coordinate;
        this.tableTop = tableTop;
        this.direction = direction;
    }

    public Coordinate roamingAround(List<Command> commands) {
        for(Command command: commands) {
            command.execute(this);
        }
        return this.coordinate;
    }

    public void moveOneStep() {
        // check for invalid direction
        Coordinate newPosition = new Coordinate(0, 0);
        switch (direction) {
            case EAST:
                newPosition = new Coordinate(this.coordinate.getX() + 1, this.coordinate.getY());
                break;

            case WEST:
                newPosition = new Coordinate(this.coordinate.getX() - 1, this.coordinate.getY());
                break;

            case NORTH:
                newPosition = new Coordinate(this.coordinate.getX(), this.coordinate.getY() + 1);
                break;

            case SOUTH:
                newPosition = new Coordinate(this.coordinate.getX(), this.coordinate.getY() - 1);
                break;
        }
        if(tableTop.insideTableBorder(newPosition)) {
            this.coordinate = newPosition;
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
