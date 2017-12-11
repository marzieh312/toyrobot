package com.jora.toyrobot;

import com.jora.toyrobot.commands.Command;
import com.jora.toyrobot.commands.PlaceCommand;
import com.jora.toyrobot.models.Coordinate;
import com.jora.toyrobot.models.Direction;

import java.util.List;

public class ToyRobot {
    private FiveUnitsTableTop tableTop;
    private Coordinate currentPosition;
    private Direction currentDirection;
    private ToyRobotPrinter printer = new ToyRobotPrinter();


    public ToyRobot(FiveUnitsTableTop tableTop) {
        this.tableTop = tableTop;
    }

    public Coordinate roamingAround(List<Command> commands) {
        for(Command command: commands) {
            if(canExecuteCommand(command)) {
                command.execute(this);
            }
        }
        return this.currentPosition;
    }

    private boolean canExecuteCommand(Command command) {
        return command instanceof PlaceCommand || robotIsPlaced();
    }

    private boolean robotIsPlaced() {
        return currentDirection != null && currentPosition != null;
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
