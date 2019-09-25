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
                if (player.getLocation().getRow() == row && player.getLocation().row == col){
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
        Coordinate next = null;
        switch (move){
            case "up":
                next = player.getNextCoordinate(up);
                break;
            case "down":
                next = player.getNextCoordinate(down);
                break;
            case "right":
                next = player.getNextCoordinate(right);
                break;
            case "left":
                next = player.getNextCoordinate(left);
                break;
            default:
                System.out.println("Not valid action");
                break;
        }
        if (next != null){
            if (board.isWall(next)) player.setNextCoordinate(next);
        }
    }
}
