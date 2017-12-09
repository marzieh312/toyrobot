package com.jora.toyrobot;

public class FiveUnitsTableTop {
    Coordinate northEastCorner = new Coordinate(4, 4);
    Coordinate southWestCorner = new Coordinate(0, 0);


    public boolean insideTableBorder(Coordinate coordinate) {
        return coordinate.getX() >= southWestCorner.getX() && coordinate.getX() <= northEastCorner.getX()
                && coordinate.getY() >= southWestCorner.getY() && coordinate.getY() <= northEastCorner.getY() ;
    }
}
