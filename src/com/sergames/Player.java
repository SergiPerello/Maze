package com.sergames;

import java.util.Random;

public class Player {

    private int health;
    private Coordinate location;

    public Player(Coordinate start,int Health) {
        this.location = start;
        this.health = Health;
    }

    public Coordinate getLocation(){
        return this.location;
    }

    public void moveUp(){
        getLocation().add(Coordinate.up);
    }
    public void moveDown(){
        getLocation().add(Coordinate.down);
    }
    public void moveRight(){
        getLocation().add(Coordinate.right);
    }
    public void moveLeft(){
        getLocation().add(Coordinate.left);
    }

    @Override
    public String toString() {
        return "Row:" + getLocation().getRow() + ", Col:" + getLocation().getCol() +'\n';
    }
}
