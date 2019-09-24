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

    int width = board[0].length;
    int height = board.length;
    boolean[][] visited;
    Coordinate start;
    Coordinate end;

    public Board() {
        visited = new boolean[getWidth()][getHeight()];
        for (int x=0;x<getWidth();x++){
            for (int y=0; y<getHeight();y++) {
                if (board[y][x] == 'S') {
                    start = new Coordinate(x, y);
                }
                if (board[y][x] == 'E') {
                    end = new Coordinate(x, y);
                }
            }
        }
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public Coordinate getEntry(){
        return start;
    }
    public Coordinate getExit(){
        return end;
    }

    public boolean isStart(Coordinate move) {
        return move.x == start.getX() && move.y == start.getY();
    }
    public boolean isExit(Coordinate move) {
        return move.x == end.getX() && move.y == end.getY();
    }

    public boolean isExplored(Coordinate move){
        return visited[move.x][move.y];
    }
    public boolean isWall(Coordinate move){
        return board[move.x][move.y] == '#';
    }

    public void setVisited(Coordinate move, boolean value){
        visited[move.x][move.y]=value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Width:"+getWidth()+", Height:"+getHeight()+'\n');
        for (int i=0;i<getHeight();i++){
            for (int j=0;j<getWidth();j++){
                result.append(board[i][j]);
                result.append(' ');
            }
            result.append('\n');
        }
        return result.toString();
    }
}
