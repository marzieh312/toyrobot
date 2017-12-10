package com.jora.toyrobot;

public class ToyRobotPrinter {
    void print(Coordinate coordinate, Direction direction) {
        StringBuilder sb = new StringBuilder();
        sb.append("Output: ");
        sb.append(coordinate.toString());
        sb.append(",");
        sb.append(direction.toString());
        sb.append("\n");

        System.out.println(sb.toString());
    }
}
