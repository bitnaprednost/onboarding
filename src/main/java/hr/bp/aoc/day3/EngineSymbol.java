package hr.bp.aoc.day3;

import java.util.List;

public class EngineSymbol {
    private int row;
    private int column;
    private String value;
    private Coordinate coordinate;

    public EngineSymbol(int row, int column, String value) {
        this.row = row;
        this.column = column;
        this.value = value;
        coordinate = new Coordinate(row, column);
    }

    public List<Coordinate> getAdjacantNumCoordinates() {
        return coordinate.getAdjacent();
    }
}
