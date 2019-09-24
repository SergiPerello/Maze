package com.sergames;

import java.util.Scanner;

public class Game {
    Board board = new Board();
    Player player;
    boolean exit = false;

    void start(){
        while (!exit){
            print();
            System.out.print(player.toString());
        }
    }

    public Game() {
        player = new Player(board.getEntry());
    }

    void print(){
        char array[][] = board.getBoard();
        for (int y=0;y<board.getHeight();y++){
            for (int x=0;x<board.getWidth();x++){
                if (player.location.y == y && player.location.x == x){
                    System.out.print('P'+" ");
                }
                else{
                    System.out.print(array[y][x]+" ");
                }

            }
            System.out.println();
        }
    }

    String nextAction(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Next Action: (Up, Down, Right, Left)");
        return sc.nextLine();
    }
}
