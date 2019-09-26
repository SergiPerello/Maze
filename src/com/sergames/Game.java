package com.sergames;

import java.util.Scanner;

public class Game {


    Board board = new Board();
    Player player;
    boolean exit = false;

    public Game() {
        player = new Player(board.getEntry());
        start();
    }

    void start(){
        String move;
        while (!exit){
            print();
            System.out.print(player.toString());//test stuff
            move = askAction();
            checkNextPlayerPosition(move);

        }
    }

    void print(){
        char array[][] = board.getBoard();
        for (int row=0;row<board.getNumberRows();row++){
            for (int col=0;col<board.getNumberCols();col++){
                if (player.getLocation().getRow() == row && player.getLocation().getCol() == col){
                    System.out.print('P'+" ");
                }
                else System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }

    String askAction(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Next Action: (Up, Down, Right, Left)");
        return sc.nextLine().toLowerCase();
    }

    void checkNextPlayerPosition(String move){
        switch (move){
            case "up":
                if (board.isWall(player.getLocation().add(Coordinate.up))) player.moveUp();
                break;
            case "down":
                if (board.isWall(player.getLocation().add(Coordinate.down))) player.moveDown();
                break;
            case "right":
                if (board.isWall(player.getLocation().add(Coordinate.right))) player.moveRight();
                break;
            case "left":
                if (board.isWall(player.getLocation().add(Coordinate.left))) player.moveLeft();
                break;
            default:
                System.out.println("Not valid action");
                break;
        }
    }
}
