package com.sergames;

import java.util.Scanner;

public class Game {
    Board board = new Board();
    Player player = new Player(board.getEntry(),5);;
    boolean exit = false;

    void start(){
        while (!exit){
            Displayer.print(board,player);
            playerNextStep(Displayer.askAction());
            if (board.isExit(player.getLocation())){
                System.out.println(Displayer.winText);
                Displayer.print(board,player);
                exit = true;
            }
        }
    }

    void playerNextStep(String move){
        switch (move){
            case Displayer.up:
                if (!board.isWall(player.getLocation().check(Coordinate.up))) {
                    player.moveUp();
                    System.out.println("a");
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
