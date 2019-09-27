package com.sergames;

public class Board {

    /*
    ' ' --> Road
    '#' --> Wall
    'S' --> Start
    'E' --> End
     */
    private char[][] board;



    public Board(int rows, int cols, Coordinate start) { //Visited maze
        board = new char[rows][cols];
        fillArrayBoarders(board);
        setVisited(start);
    }

    public Board(char[][] map) { //Discovered maze
        board = map;
    }

    public char[][] getBoard() {
        return board;
    }

    //Visited stuff
    void fillArrayBoarders(char[][]array){
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array.length; col++) {
                if(row == 0 || (row == array.length-1 || col==0 || col==array.length-1)){
                    array[row][col] = board[row][col];
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

    public boolean isStart(Coordinate move) {
        return start.equals(move);
    }
    public boolean isExit(Coordinate move) {
        return end.equals(move);
    }
    public boolean isWall(Coordinate move){
        return board[move.getRow()][move.getCol()] == '#';
    }


}
