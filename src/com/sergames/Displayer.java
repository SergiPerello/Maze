package com.sergames;

import java.util.Scanner;

public class Displayer {

    //UI Texts
    public static final String up="up", down="down", right="right", left="left", space=" ", help="help";
    public static final char start='S', end='E', player='P', road=' ', wall='#', bedrock='■', walked='+', axe = '?', bomb = '@';
    public static final String nextMove = "Next Action: (Up, Down, Right, Left)";
    public static final String notMoveText = "You can't move";
    public static final String notValidInput = "Not valid input";
    public static final String winText = "You won!";
    public static final String collectedAxe = "You obtained an axe!!";
    public static final String brokeAxe = "Axe is broken!!";

    static String askAction(String topText){
        System.out.println("_____________________________________________");
        Scanner sc = new Scanner(System.in);
        System.out.println(topText);
        return sc.nextLine().toLowerCase();
    }

    static void print(Board board,Player player,Coordinate size){
        for (int row=0;row<size.getRow();row++){
            for (int col=0;col<size.getCol();col++){
                if (player.getLocation().getRow() == row && player.getLocation().getCol() == col){
                    System.out.print(Displayer.player+space);
                }
                else System.out.print(board.getBoard()[row][col]+space);
            }
            System.out.println();
        }

    }
}
