package com.sergames;

import java.util.Scanner;

public class Displayer {

    //UI Texts
    public static final String up="up", down="down", right="right", left="left";
    public static final String nextMove = "Next Action: (Up, Down, Right, Left)";
    public static final String notMoveText = "You can't move";
    public static final String notValidInput = "Not valid input";

    static String askAction(){
        Scanner sc = new Scanner(System.in);
        System.out.println(Displayer.nextMove);
        return sc.nextLine().toLowerCase();
    }

    static void print(Board board,Player player){
        for (int row=0;row<board.getNumberRows();row++){
            for (int col=0;col<board.getNumberCols();col++){
                if (player.getLocation().getRow() == row && player.getLocation().getCol() == col){
                    System.out.print('P'+" ");
                }
                else System.out.print(board.getBoard()[row][col] + " ");
            }
            System.out.println();
        }
    }
}
