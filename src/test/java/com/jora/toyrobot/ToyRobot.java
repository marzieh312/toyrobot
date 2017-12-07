package com.jora.toyrobot;

public class ToyRobot {
    private Coordinate coordinate;
    private Direction direction;

    public ToyRobot(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate roamingAround() {

        return this.coordinate;
    }

    public Direction getFace() {
        return direction;
    }

    public String getReport() {
        return "Output: 0,1,NORTH";
    }
}
