package com.sergames;

import java.util.Scanner;

public class View {

    //UI Texts
    public static final String up="up", down="down", right="right", left="left", space=" ", help="help";
    public static final char start='S', end='E', player='P', road=' ', wall='#', bedrock='■', walked='+', axe = '?', bomb = '@';
    public static final String nextMove = "Next Action (Up, Down, Right, Left, Help): ";
    public static final String notMoveText = "You can't move";
    public static final String notValidInput = "Not valid input";
    public static final String winText = "You won!";
    public static final String loseText = "You lost!";
    public static final String collectedAxe = "You obtained an axe!!";
    public static final String useAxe = "Do you want to use the axe(y/n)?";
    public static final String notUseAxe = "Axe not used!!";
    public static final String brokenAxe = "Axe is broken!!";
    public static final String foundBomb = "You stepped a bomb!!";
    public static final String healthInfo = "Your health is: ";
    public static final String nextRoundSeparator = "_____________________________________________";
    public static final String n = "North", s = "South", e = "East", w = "West", ne = "North-east", nw = "North-west", se = "South-east", sw = "South-west";

    static String askAction(String textToDisplay){

        Scanner sc = new Scanner(System.in);
        System.out.print(textToDisplay);
        return sc.nextLine().toLowerCase();
    }

    static void print(Board board,Player player,Coordinate size){
        if (player.getHealth()>=0) System.out.println(View.healthInfo+player.getHealth());
        for (int row=0;row<size.getRow();row++){
            for (int col=0;col<size.getCol();col++){
                if (player.getLocation().getRow() == row && player.getLocation().getCol() == col){
                    System.out.print(View.player+space+space);
                }
                else System.out.print(board.getBoard()[row][col]+space+space);
            }
            System.out.println();
        }
    }
}
