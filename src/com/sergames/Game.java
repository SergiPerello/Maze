package com.sergames;

import java.util.Scanner;

public class Game {
    char[][]hardCodedMap = {
        {'#', '#', '#', '#', '#', '#', '#'},
        {'#', 'S', '#', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', 'E', '#'},
        {'#', '#', '#', '#', '#', '#', '#'}
    };
    private Coordinate tableSize = new Coordinate(hardCodedMap.length,hardCodedMap[0].length);
    private Board maze = new Board(hardCodedMap);
    private Board visited;
    private Player player;
    private Coordinate start;
    private Coordinate end;
    boolean exit = false;

    public Game() {
        identifyMapLocations();
        visited = new Board(tableSize,start,'#');
        player = new Player(start,5);
        start();
    }

    void start(){
        while (!exit){
            Displayer.print(visited,player,tableSize);
            playerNextStep(Displayer.askAction());
            if (isExit(player.getLocation())){
                System.out.println(Displayer.winText);
                Displayer.print(maze,player,tableSize);
                exit = true;
            }
        }
    }
    public boolean isStart(Coordinate move) {
        return start.equals(move);
    }
    public boolean isExit(Coordinate move) {
        return end.equals(move);
    }

    void identifyMapLocations(){
        for (int row=0;row<tableSize.getRow();row++){
            for (int col=0; col<tableSize.getCol();col++) {
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
