package com.sergames;

import java.util.Random;

public class Player {
    private static final Coordinate Up = new Coordinate(1,0);
    private static final Coordinate Down = new Coordinate(-1,0);
    private static final Coordinate Right = new Coordinate(0,1);
    private static final Coordinate Left = new Coordinate(0,-1);



    Coordinate location;

    public int getLocationX() {
        return location.x;
    }
    public int getLocationY() {
        return location.y;
    }

    public Player(Coordinate start) {
        location = start;
    }

    private Coordinate getNextCoordinate(Coordinate location, Coordinate move) {
        return new Coordinate(location.x + move.getX(), location.y + move.getY());
    }

    @Override
    public String toString() {
        return "X:" + getLocationX() + ", Y:" + getLocationY();
    }
}
