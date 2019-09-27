package com.sergames;

import java.util.Random;

public class Player {

    private int health;
    private Coordinate location;

    public Player(Coordinate start,int Health) {
        location = start;
        health = Health;
    }

    public Coordinate getLocation(){
        return location;
    }

    public void moveUp(){
        location.add(Coordinate.up);
    }
    public void moveDown(){
        location.add(Coordinate.down);
    }
    public void moveRight(){
        location.add(Coordinate.right);
    }
    public void moveLeft(){
        location.add(Coordinate.left);
    }

    @Override
    public String toString() {
        return "Row:" + getLocation().getRow() + ", Col:" + getLocation().getCol() +'\n';
    }
}
