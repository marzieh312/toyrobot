package com.jora.toyrobot;

public class ToyRobot {
    private Coordinate coordinate;
    private Direction direction;

    public ToyRobot(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate roamingAround(String move) {
        if("RIGHT".equals(move)) {
            moveRightOneStep();
        } else if("LEFT".equals(move)) {
            moveLeftOneStep();
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
