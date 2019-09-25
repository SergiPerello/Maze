package com.sergames;

import java.util.Objects;

public class Coordinate {
    private int row,col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    public Coordinate add(Coordinate other){
        this.row += other.row;
        this.col += other.col;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row &&
                col == that.col;
    }
}
