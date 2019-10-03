package com.sergames;

public class Game {
    /*
    '■' --> Bedrock
    ' ' --> Road
    '#' --> Wall
    'S' --> Start
    'E' --> End
    'A' --> Axe
    'B' --> Bomb
     */
    char[][]hardCodedMap = {
            {'■','■','■','■','■','■','■','■','■'},
            {'■','S','#',' ','B',' ','#','E','■'},
            {'■',' ','#',' ','#','B','#',' ','■'},
            {'■',' ','#','A','#',' ',' ',' ','■'},
            {'■',' ','#',' ','#',' ','#','B','■'},
            {'■',' ',' ',' ','#',' ','#',' ','■'},
            {'■','■','■','■','■','■','■','■','■'}
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
        visited = new Board(tableSize,'#');
        player = new Player(start,5);
        start();
    }

    void start(){
        while (!exit){
            Displayer.print(visited,player,tableSize);
            playerNextStep(Displayer.askAction());
            if (isExit(player.getLocation())){
                exit = true;
                Displayer.print(maze,player,tableSize);
                System.out.println(Displayer.winText);
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
                    start = new Coordinate(row,col);
                }
                else if (hardCodedMap[row][col] == 'E') {
                    end = new Coordinate(row,col);
                }
                else if (hardCodedMap[row][col] == 'B') {
                    //bomb.setPosition(new Coordinate(row,col));
                }
            }
        }
    }

    void playerNextStep(String move){
        Coordinate nextMove = null;
        switch (move){
            case Displayer.up:
                nextMove = player.getLocation().check(Coordinate.up);
                break;
            case Displayer.down:
                nextMove = player.getLocation().check(Coordinate.down);
                break;
            case Displayer.right:
                nextMove = player.getLocation().check(Coordinate.right);
                break;
            case Displayer.left:
                nextMove = player.getLocation().check(Coordinate.left);
                break;
            default:
                System.out.println(Displayer.notValidInput);
                break;
        }
        if (nextMove != null){
            if (!maze.isWall(nextMove) && !maze.isBedrock(nextMove)) {
                player.move(nextMove);
                if (maze.isAxe(nextMove)) {
                    player.addAxe();
                }
            }
            else {
                if (player.hasAxe() && maze.isWall(nextMove)){
                    player.move(nextMove);
                    player.removeAxe();
                    maze.destroyWall(nextMove);
                    visited.destroyWall(nextMove);
                }
                else {
                    visited.setVisited(nextMove,maze.getVisited(nextMove));
                    System.out.println(Displayer.notMoveText);
                }
            }
        }
    }
}
