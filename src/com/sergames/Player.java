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
    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public void moveUp(){

    }

    public void moveDown(){

    }

    public void moveRight(){

    }
    public void moveLeft(){

    }

    public Coordinate getNextCoordinate(Coordinate move) {
        return new Coordinate(location.getRow() + move.getRow(), location.getCol() + move.getCol());
    }
    public void setNextCoordinate(Coordinate move) {
        setLocation(move).getRow() += move.getRow();
        setLocation().getCol() += move.getCol();
    }

    @Override
    public String toString() {
        return "Row:" + getLocation().getRow() + ", Col:" + getLocation().getCol() +'\n';
    }
}
