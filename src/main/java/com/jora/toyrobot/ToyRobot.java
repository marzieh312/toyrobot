package com.jora.toyrobot;

import com.jora.toyrobot.commands.Command;

import java.util.List;

public class ToyRobot {
    private FiveUnitsTableTop tableTop;
    private Coordinate currentPosition;
    private Direction currentDirection;
    private ToyRobotPrinter printer = new ToyRobotPrinter();


    public ToyRobot(Coordinate currentPosition, Direction currentDirection, FiveUnitsTableTop tableTop) {
        this.currentPosition = currentPosition;
        this.tableTop = tableTop;
        this.currentDirection = currentDirection;
    }

    public Coordinate roamingAround(List<Command> commands) {
        for(Command command: commands) {
            command.execute(this);
        }
        return this.currentPosition;
    }

    public void moveOneStep() {
        Coordinate newPosition = this.currentPosition.getNewPosition(currentDirection.getDeltaX(),
                currentDirection.getDeltaY());
        if(tableTop.insideTableBorder(newPosition)) {
            this.currentPosition = newPosition;
        }
    }

    public Direction getFace() {
        return currentDirection;
    }

    public void rotateLeft() {
        this.currentDirection = this.currentDirection.turnLeft();
    }

    public void rotateRight() {
        this.currentDirection = this.currentDirection.turnRight();
    }

    public Coordinate getPosition() {
        return this.currentPosition;
    }

    public void place(Coordinate newPosition, Direction newDirection) {
        if(tableTop.insideTableBorder(newPosition)) {
            this.currentPosition = newPosition;
            this.currentDirection= newDirection;
        }
    }

    public void report() {
        printer.print(this.currentPosition, this.currentDirection);
    }
}
