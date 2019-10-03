package com.sergames;

import java.util.Random;

public class Player {

    private int health;
    private Coordinate location;
    private boolean axe;

    public Player(Coordinate start,int Health) {
        this.location = start;
        this.health = Health;
        this.axe = false;
    }

    public void addAxe() {
        this.axe = true;
    }
    public void removeAxe() {
        this.axe = false;
    };

    public Coordinate getLocation(){
        return location;
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
