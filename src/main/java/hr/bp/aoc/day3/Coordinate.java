package hr.bp.aoc.day3;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public List<Coordinate> getAdjacent() {
        List<Coordinate> adjacent = new ArrayList<>();

        adjacent.add(getLeftAdjacent());
        adjacent.add(getRightAdjacent());
        adjacent.add(getBottomAdjacent());
        adjacent.add(getUpperAdjacent());
        adjacent.add(getDiagonalBottomLAdjacent());
        adjacent.add(getDiagonalBottomRAdjacent());
        adjacent.add(getDiagonalUpperRAdjacent());
        adjacent.add(getDiagonalUpperLAdjacent());

        return adjacent;
    }

    private Coordinate getLeftAdjacent() {
        return new Coordinate(row, column-1);
    }

    private Coordinate getRightAdjacent() {
        return new Coordinate(row, column+1);
    }

    private Coordinate getBottomAdjacent() {
        return new Coordinate(row+1, column);
    }

    private Coordinate getUpperAdjacent() {
        return new Coordinate(row-1, column);
    }

    private Coordinate getDiagonalUpperRAdjacent() {
        return new Coordinate(row-1, column+1);
    }

    private Coordinate getDiagonalUpperLAdjacent() {
        return new Coordinate(row-1, column-1);
    }

    private Coordinate getDiagonalBottomRAdjacent() {
        return new Coordinate(row+1, column+1);
    }

    private Coordinate getDiagonalBottomLAdjacent() {
        return new Coordinate(row+1, column-1);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
