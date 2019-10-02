package com.sergames;

public class Board {

    private char[][] board;

    //Visited maze
    public Board(Coordinate size,char symbol) {
        board = new char[size.getRow()][size.getCol()];
        fillArrayBoarders(size,symbol);
    }

    //Discovered maze
    public Board(char[][] map) {
        board = map;
    }

    public char[][] getBoard() {
        return this.board;
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

    public char getVisited(Coordinate position){
        return this.board[position.getRow()][position.getCol()];
    }
    public void setVisited(Coordinate position, char symbol){
        this.board[position.getRow()][position.getCol()]=symbol;
    }

    public boolean isWall(Coordinate move){
        return board[move.getRow()][move.getCol()] == '#';
    }


}
