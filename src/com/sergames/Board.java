package com.sergames;

import java.util.Arrays;

public class Board {

    /*
    ' ' --> Road
    '#' --> Wall
    'S' --> Start
    'E' --> End
     */
    char[][] board = {
            {'#','#','#','#','#','#','#'},
            {'#','S','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#','E','#'},
            {'#','#','#','#','#','#','#'}
    };

    public char[][] getBoard() {
        return board;
    }

    private int numberRows = board.length;
    private int numberCols = board[0].length;
    private boolean[][] visited;
    private Coordinate start;
    private Coordinate end;

    public Board() {
        visited = new boolean[getNumberCols()][getNumberCols()];
        for (int row=0;row<getNumberRows();row++){
            for (int col=0; col<getNumberCols();col++) {
                if (board[row][col] == 'S') {
                    start = new Coordinate(row, col);
                }
                else if (board[row][col] == 'E') {
                    end = new Coordinate(row, col);
                }
            }
        }
    }

    public int getNumberRows() {
        return numberRows;
    }
    public int getNumberCols() {
        return numberCols;
    }

    public Coordinate getEntry(){
        return start;
    }
    public Coordinate getExit(){
        return end;
    }

    public boolean isStart(Coordinate move) {
        return start.equals(move);
    }
    public boolean isExit(Coordinate move) {
        return end.equals(move);
    }
    public boolean isWall(Coordinate move){
        return board[move.getRow()][move.getCol()] == '#';
    }

    public boolean isExplored(Coordinate move){
        return visited[move.getRow()][move.getCol()];
    }
    public void setVisited(Coordinate move, boolean value){
        visited[move.getRow()][move.getCol()]=value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("numberRows:"+getNumberRows()+", numberCols:"+getNumberCols()+'\n');
        for (int row=0;row<getNumberRows();row++){
            for (int col=0;col<getNumberCols();col++){
                result.append(board[row][col]);
                result.append(' ');
            }
            result.append('\n');
        }
        return result.toString();
    }
}
