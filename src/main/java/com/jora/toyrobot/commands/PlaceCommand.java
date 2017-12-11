package com.jora.toyrobot.commands;

import com.jora.toyrobot.models.Coordinate;
import com.jora.toyrobot.models.Direction;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaceCommand)) return false;

        PlaceCommand that = (PlaceCommand) o;

        if (coordinate != null ? !coordinate.equals(that.coordinate) : that.coordinate != null) return false;
        return direction == that.direction;
    }

    @Override
    public int hashCode() {
        int result = coordinate != null ? coordinate.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
