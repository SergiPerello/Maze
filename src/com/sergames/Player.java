package com.sergames;

public class Player {

    private int health;
    private Coordinate location;
    private boolean axe;

    public Player(Coordinate start,int Health) {
        this.location = start;
        this.health = Health;
        this.axe = false;
    }

    public boolean hasAxe() {
        return axe;
    }

    public void addAxe() {
        this.axe = true;
        System.out.println(Displayer.collectedAxe);
    }
    public void removeAxe() {
        this.axe = false;
        System.out.println(Displayer.brokeAxe);
    }

    public Coordinate getLocation(){
        return location;
    }
    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public void move(Coordinate move){
        setLocation(move);
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
