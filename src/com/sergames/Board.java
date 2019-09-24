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
                      {'#','S','#','#','#'},
                      {'#',' ',' ',' ','#'},
                      {'#','#','#','E','#'}
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

    public boolean isStart(int x, int y) {
        return x == start.getX() && y == start.getY();
    }
    public boolean isExit(int x, int y) {
        return x == end.getX() && y == end.getY();
    }

    public boolean isExplored(int x, int y){
        return visited[x][y];
    }
    public boolean isWall(int x,int y){
        return board[x][y] == '#';
    }

    public void setVisited(int x, int y, boolean value){
        visited[x][y]=value;
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
