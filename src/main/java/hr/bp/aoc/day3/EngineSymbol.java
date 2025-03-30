package hr.bp.aoc.day3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EngineSymbol {
    private String value;
    private Coordinate coordinate;
    private Set<EngineNumber> adjacentNumbers = new HashSet<>();

    public int getSumAdjacentNum() {
        int sum = 0;

        for (EngineNumber adjacentNumber : adjacentNumbers) {
            sum += adjacentNumber.getValue();
        }

        return sum;
    }

    public int getGearRatio() {
        int gearRatio = 1;

        if (isGear()) {
            for (EngineNumber adjacentNumber : adjacentNumbers) {
                gearRatio *= adjacentNumber.getValue();
            }
            return gearRatio;
        }
        return 0;
    }

    private boolean isGear() {
        return value.equals("*")
                && adjacentNumbers.size() == 2;
    }

    public EngineSymbol(int row, int column, String value) {
        this.value = value;
        coordinate = new Coordinate(row, column);
    }

    public List<Coordinate> getAdjacantNumCoordinates() {
        return coordinate.getAdjacent();
    }

    public Set<EngineNumber> getAdjacentNumbers() {
        return adjacentNumbers;
    }
}
