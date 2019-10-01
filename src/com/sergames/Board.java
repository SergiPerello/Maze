package com.sergames;

public class Board {

    /*
    ' ' --> Road
    '#' --> Wall
    'S' --> Start
    'E' --> End
     */
    private char[][] board;

    public Board(Coordinate size, Coordinate start,char symbol) { //Visited maze
        board = new char[size.getRow()][size.getCol()];
        fillArrayBoarders(size,symbol);
        setVisited(start);
    }

    public Board(char[][] map) { //Discovered maze
        board = map;
    }

    public char[][] getBoard() {
        return board;
    }

    void fillArrayBoarders(Coordinate size,char symbol){
        for (int row = 0; row < size.getRow(); row++) {
            for (int col = 0; col < size.getCol(); col++) {
                if(row == 0 || (row == size.getRow()-1 || col==0 || col==size.getCol()-1)){
                    board[row][col] = symbol;
                }
            }
        }
    }
    public char isExplored(Coordinate position){
        return board[position.getRow()][position.getCol()];
    }
    public void setVisited(Coordinate position){
        int row = position.getRow();
        int col = position.getCol();
        board[row][col]=board[row][col];
    }


    public boolean isWall(Coordinate move){
        return board[move.getRow()][move.getCol()] == '#';
    }


}
