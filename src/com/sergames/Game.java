package com.sergames;

import java.util.Scanner;

public class Game {
    char[][]hardCodedMap = {
        {'#', '#', '#', '#', '#', '#', '#'},
        {'#', 'S', '#', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', 'E', '#'},
        {'#', '#', '#', '#', '#', '#', '#'}
    };
    private int numberRows = hardCodedMap.length;
    private int numberCols = hardCodedMap[0].length;
    private Coordinate start;
    private Coordinate end;

    Board maze = new Board(hardCodedMap);
    Board visited = new Board(numberRows,numberCols,start);
    Player player = new Player(start,5);;
    boolean exit = false;

    void start(){
        identifyMapLocations();
        while (!exit){
            Displayer.print(visited,player);
            playerNextStep(Displayer.askAction());
            if (maze.isExit(player.getLocation())){
                System.out.println(Displayer.winText);
                Displayer.print(maze,player);
                exit = true;
            }
        }
    }

    void identifyMapLocations(){
        for (int row=0;row<numberRows;row++){
            for (int col=0; col<numberCols;col++) {
                if (hardCodedMap[row][col] == 'S') {
                    start = new Coordinate(row, col);
                }
                else if (hardCodedMap[row][col] == 'E') {
                    end = new Coordinate(row, col);
                }
            }
        }
    }

    void playerNextStep(String move){
        switch (move){
            case Displayer.up:
                Coordinate nextMove = player.getLocation().check(Coordinate.up);
                if (!maze.isWall(nextMove)) player.moveUp();
                else {
                    System.out.println(Displayer.notMoveText);
                    visited.setVisited(nextMove);
                }
                break;
            case Displayer.down:
                if (!maze.isWall(player.getLocation().check(Coordinate.down))) {
                    player.moveDown();
                } else System.out.println(Displayer.notMoveText);
                break;
            case Displayer.right:
                if (!maze.isWall(player.getLocation().check(Coordinate.right))) {
                    player.moveRight();
                } else System.out.println(Displayer.notMoveText);
                break;
            case Displayer.left:
                if (!maze.isWall(player.getLocation().check(Coordinate.left))) {
                    player.moveLeft();
                } else System.out.println(Displayer.notMoveText);
                break;
            default:
                System.out.println(Displayer.notValidInput);
                break;
        }
    }
}
