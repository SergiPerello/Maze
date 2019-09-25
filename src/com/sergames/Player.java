package com.sergames;

import java.util.Random;

public class Player {
    private Coordinate up = new Coordinate(0,-1);
    private Coordinate down = new Coordinate(0,1);
    private Coordinate right = new Coordinate(1,0);
    private Coordinate left = new Coordinate(-1,0);
    private Coordinate location;

    public Player(Coordinate start) {
        location = start;
    }

    public Coordinate getLocation(){
        return location;
    }

    public void moveUp(){
        location.add(up);
    }
    public void moveDown(){
        location.add(down);
    }
    public void moveRight(){
        location.add(right);
    }
    public void moveLeft(){
        location.add(left);
    }

    @Override
    public String toString() {
        return "Row:" + getLocation().getRow() + ", Col:" + getLocation().getCol() +'\n';
    }
}
