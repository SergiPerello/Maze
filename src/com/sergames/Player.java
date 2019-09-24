package com.sergames;

import java.util.Random;

public class Player {

    private Coordinate location;

    public Player(Coordinate start) {
        location = start;
    }

    public Coordinate getLocation(){
        return location;
    }

    public Coordinate getNextCoordinate(Coordinate move) {
        return new Coordinate(location.x + move.getX(), location.y + move.getY());
    }
    public void setNextCoordinate(Coordinate move) {
        location.x += move.getX();
        location.y += move.getY();
    }

    @Override
    public String toString() {
        return "X:" + getLocation().x + ", Y:" + getLocation().y +'\n';
    }
}
