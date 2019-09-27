package com.sergames;

import java.util.Scanner;

public class Game {
    Board board = new Board();
    Player player;
    boolean exit = false;

    //UI Texts
    public static final String up="up", down="down", right="right", left="left";
    public static final String nextMove = "Next Action: (Up, Down, Right, Left)";
    public static final String notMoveText = "You can't move";
    public static final String notValidInput = "Not valid input";

    public Game() {
        player = new Player(board.getEntry(),5);
        start();
    }

    void start(){
        String move;
        while (!exit){
            print();
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
        System.out.println(nextMove);
        return sc.nextLine().toLowerCase();
    }

    void checkNextPlayerPosition(String move){
        switch (move){
            case up:
                if (board.isWall(player.getLocation().check(Coordinate.up))) {
                    player.moveUp();
                } else System.out.println(notMoveText);
                break;
            case down:
                if (!board.isWall(player.getLocation().check(Coordinate.down))) {
                    player.moveDown();
                } else System.out.println(notMoveText);
                break;
            case right:
                if (!board.isWall(player.getLocation().check(Coordinate.right))) {
                    player.moveRight();
                } else System.out.println(notMoveText);
                break;
            case left:
                if (!board.isWall(player.getLocation().check(Coordinate.left))) {
                    player.moveLeft();
                } else System.out.println(notMoveText);
                break;
            default:
                System.out.println(notValidInput);
                break;
        }
    }
}
