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

    public void move(Coordinate move) {
        setLocation(move);
    }

    //Location related stuff
    public Coordinate getLocation(){
        return location;
    }
    public void setLocation(Coordinate location) {
        this.location = location;
    }

    //Axe related stuff
    public boolean hasAxe() {
        return axe;
    }
    public void addAxe() {
        this.axe = true;
        System.out.println(Displayer.collectedAxe);
    }
    public void removeAxe() {
        this.axe = false;
        System.out.println(Displayer.brokenAxe);
    }

    //Health related stuff
    public int getHealth() {
        return health;
    }
    public void harm() {
        this.health = --health;
        System.out.println(Displayer.foundBomb);
    }
    public boolean isDead() {
        return health < 0;
    }


    @Override
    public String toString() {
        return "Row:" + getLocation().getRow() + ", Col:" + getLocation().getCol() +'\n';
    }
}
