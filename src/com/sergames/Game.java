package com.sergames;

import java.util.Scanner;

public class Game {
    private static final Coordinate up = new Coordinate(0,-1);
    private static final Coordinate down = new Coordinate(0,1);
    private static final Coordinate right = new Coordinate(1,0);
    private static final Coordinate left = new Coordinate(-1,0);

    Board board = new Board();
    Player player;
    boolean exit = false;

    public Game() {
        player = new Player(board.getEntry());
        start();
    }

    void start(){
        while (!exit){
            print();
            String move = askAction();
            checkNextPlayerPosition(move);

            //test stuff
            System.out.print(player.toString());
        }
    }

    void print(){
        char array[][] = board.getBoard();
        for (int y=0;y<board.getHeight();y++){
            for (int x=0;x<board.getWidth();x++){
                if (player.getLocation().y == y && player.getLocation().x == x){
                    System.out.print('P'+" ");
                }
                else System.out.print(array[y][x] + " ");
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
        Coordinate next;
        switch (move){
            case "up":
                next = player.getNextCoordinate(up);
                if (board.isWall(next)) player.setNextCoordinate(next);
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
    }
}
