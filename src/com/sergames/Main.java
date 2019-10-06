package com.sergames;

import java.util.Arrays;

public class Main {
    private static int i = 1;
    public static void main(String[] args) {

        //TODO: Little menu
        System.out.println("Welcome to the maze game!!");
        System.out.println("Once the game finishes I will show you all of your moves");
        System.out.println("So, let's start!");
        System.out.println(View.nextRoundSeparator);
        Game game = new Game();
        game.walked.forEach((n) -> print(n));
    }
    private static void print(Coordinate n) {
        System.out.println("Step "+i+++": "+"Row-"+n.getRow()+" Col-"+n.getCol());
    }

}
