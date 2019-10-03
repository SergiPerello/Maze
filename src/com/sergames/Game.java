package com.sergames;

import java.util.ArrayList;

import static com.sergames.Displayer.*;

public class Game {
    /*
    '■' --> Bedrock
    ' ' --> Road
    '#' --> Wall
    'S' --> Start
    'E' --> End
    '?' --> Axe
    '@' --> Bomb
     */
    char[][]hardCodedMap = {
            {'■','■','■','■','■','■','■','■','■'},
            {'■','S','#',' ','@',' ','#','E','■'},
            {'■','@','#',' ','#','@','#',' ','■'},
            {'■','@','#','?','#',' ',' ',' ','■'},
            {'■','@','#',' ','#',' ','#','@','■'},
            {'■','@','@',' ','#',' ','#',' ','■'},
            {'■','■','■','■','■','■','■','■','■'}
    };
    private Coordinate tableSize;
    private Board maze;
    ArrayList<Coordinate> walked;
    private Board visited;
    private Player player;
    private Coordinate start;
    private Coordinate end;
    boolean exit = false;


    public Game() {
        tableSize = new Coordinate(hardCodedMap.length,hardCodedMap[0].length);
        maze = new Board(hardCodedMap);
        walked = new ArrayList<>();
        identifyMapLocations();
        visited = new Board(tableSize, wall);
        player = new Player(start,5);
        start();
    }
    void identifyMapLocations(){
        for (int row=0;row<tableSize.getRow();row++){
            for (int col=0; col<tableSize.getCol();col++) {
                if (hardCodedMap[row][col] == Displayer.start) {
                    start = new Coordinate(row,col);
                }
                else if (hardCodedMap[row][col] == Displayer.end) {
                    end = new Coordinate(row,col);
                }
            }
        }
    }

    void start(){
        while (!exit){
            print(visited,player,tableSize);
            playerNextStep(askAction(nextMove));
            exit = checkEndGame(exit);
        }
    }

    void playerNextStep(String move){
        Coordinate nextMove = null;
        switch (move){
            case up:
                nextMove = player.getLocation().check(Coordinate.up);
                break;
            case down:
                nextMove = player.getLocation().check(Coordinate.down);
                break;
            case right:
                nextMove = player.getLocation().check(Coordinate.right);
                break;
            case left:
                nextMove = player.getLocation().check(Coordinate.left);
                break;
            case help:
                //TODO:Help Assistant
                break;
            default:
                System.out.println(notValidInput);
                break;
        }
        if (nextMove != null){
            walked.add(player.getLocation());
            if (!maze.isWall(nextMove) && !maze.isBedrock(nextMove)) {
                visited.setVisited(player.getLocation(),Displayer.walked);
                player.move(nextMove);
                if (maze.isAxe(nextMove)) player.addAxe();
                if (maze.isBomb(nextMove)) player.harm();
            }
            else {
                if (player.hasAxe() && maze.isWall(nextMove)){
                    player.move(nextMove);
                    player.removeAxe();
                    maze.destroyWall(nextMove);
                    visited.destroyWall(nextMove);
                    visited.setVisited(player.getLocation(),Displayer.walked);
                }
                else {
                    visited.setVisited(nextMove,maze.getVisited(nextMove));
                    System.out.println(notMoveText);
                }
            }
        }
    }

    //EndGame related stuff
    public boolean isExit(Coordinate move) {
        return end.equals(move);
    }
    private boolean checkEndGame(boolean exit) {
        if (player.isDead()){
            exit = true;
            print(maze,player,tableSize);
            System.out.println(loseText);
        }
        else if (isExit(player.getLocation())){
            exit = true;
            print(maze,player,tableSize);
            System.out.println(winText);
        }
        return exit;
    }



}
