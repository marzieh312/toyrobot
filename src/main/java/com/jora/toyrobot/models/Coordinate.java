package com.jora.toyrobot.models;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Coordinate getNewPosition(int deltaX, int deltaY) {
        return new Coordinate(x + deltaX, y + deltaY);
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
