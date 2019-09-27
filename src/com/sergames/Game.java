package com.sergames;

import java.util.Scanner;

public class Game {
    Board board = new Board();
    Player player;
    boolean exit = false;



    public Game() {
        player = new Player(board.getEntry(),5);
        start();
    }

    void start(){
        while (!exit){
            Displayer.print(board,player);
            checkNextPlayerPosition(Displayer.askAction());
        }
    }

    void checkNextPlayerPosition(String move){
        switch (move){
            case Displayer.up:
                if (board.isWall(player.getLocation().check(Coordinate.up))) {
                    player.moveUp();
                } else System.out.println(Displayer.notMoveText);
                break;
            case Displayer.down:
                if (!board.isWall(player.getLocation().check(Coordinate.down))) {
                    player.moveDown();
                } else System.out.println(Displayer.notMoveText);
                break;
            case Displayer.right:
                if (!board.isWall(player.getLocation().check(Coordinate.right))) {
                    player.moveRight();
                } else System.out.println(Displayer.notMoveText);
                break;
            case Displayer.left:
                if (!board.isWall(player.getLocation().check(Coordinate.left))) {
                    player.moveLeft();
                } else System.out.println(Displayer.notMoveText);
                break;
            default:
                System.out.println(Displayer.notValidInput);
                break;
        }
    }
}
