package hr.bp.adventofcode.day03;

import java.util.ArrayList;
import java.util.List;

public class EngineSchematic {

    private char[][] grid;

    private List<NumberPosition> numberPositions;
    private List<GearPosition> gearPositions;

    public EngineSchematic(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank.");
        }

        numberPositions = new ArrayList<>();
        gearPositions = new ArrayList<>();

        parseInput(input);

        extractNumberPositions();
        extractGearPositions();
    }

    public int calculateSumOfGearRatios() {
        int sum = 0;

        for (GearPosition gearPosition : gearPositions) {
            sum += findGearRatioForGear(gearPosition);
        }
        return sum;
    }

    public int calculateSum() {
        int sum = 0;

        for (NumberPosition numberPosition : numberPositions) {
            if (isAdjacentToSymbol(numberPosition.row(), numberPosition.beginColumn(), numberPosition.endColumn())) {
                sum += numberPosition.value();
            }
        }
        return sum;
    }

    private int findGearRatioForGear(GearPosition gearPosition) {
        int ratio = 0;

        List<NumberPosition> numberPositionsAdjacentToGear = this.numberPositions.stream()
                .filter(numberPosition -> numberIsAdjacentToGearPosition(gearPosition, numberPosition))
                .toList();

        if (numberPositionsAdjacentToGear.size() == 2) {
            ratio = numberPositionsAdjacentToGear.get(0).value() * numberPositionsAdjacentToGear.get(1).value();
        }
        return ratio;
    }

    private boolean numberIsAdjacentToGearPosition(GearPosition gearPosition, NumberPosition numberPosition) {
        int rowDistance = getRowDistance(gearPosition, numberPosition);
        int columnDistance = getColumnDistance(gearPosition, numberPosition);
        return rowDistance <= 1 && columnDistance <= 1;
    }

    private int getColumnDistance(GearPosition gearPosition, NumberPosition numberPosition) {
        int distance = Integer.MAX_VALUE;

        for (int i = numberPosition.beginColumn(); i <= numberPosition.endColumn(); i++) {
            distance = Math.min(distance, Math.abs(i - gearPosition.column()));
        }
        return distance;
    }

    private int getRowDistance(GearPosition gearPosition, NumberPosition numberPosition) {
        return Math.abs(gearPosition.row() - numberPosition.row());
    }

    public boolean isAdjacentToSymbol(int rowIndex, int startColumnIndex, int endColumnIndex) {
        boolean isAdjacent = checkRowForSymbols(rowIndex, startColumnIndex, endColumnIndex);

        if (rowIndex > 0) {
            isAdjacent |= checkRowForSymbols(rowIndex - 1, startColumnIndex, endColumnIndex);
        }

        if (rowIndex < grid.length - 1) {
            isAdjacent |= checkRowForSymbols(rowIndex + 1, startColumnIndex, endColumnIndex);
        }
        return isAdjacent;
    }

    private boolean checkRowForSymbols(int rowIndex, int startColumnIndex, int endColumnIndex) {
        char[] row = grid[rowIndex];

        startColumnIndex = Math.max(0, startColumnIndex - 1);
        endColumnIndex = Math.min(row.length - 1, endColumnIndex + 1);

        for (int i = startColumnIndex; i <= endColumnIndex; i++) {
            if (isSymbol(row[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isSymbol(char c) {
        return !Character.isDigit(c) && !String.valueOf(c).equals(".");
    }

    private void parseInput(String input) {
        String[] rows = input.split("\n");

        grid = new char[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            char[] row = rows[i].toCharArray();
            grid[i] = row;
        }
    }

    private void extractNumberPositions() {
        for (int i = 0; i < grid.length; i++) {
            extractNumberPositionsFromRow(i);
        }
    }

    private void extractNumberPositionsFromRow(int rowIndex) {
        char[] row = grid[rowIndex];

        int number = 0;
        int numberBeginIndex = -1;

        for (int i = 0; i < row.length; i++) {
            if (Character.isDigit(row[i])) {
                if (numberBeginIndex == -1) {
                    numberBeginIndex = i;
                }
                number *= 10;
                number += Integer.parseInt(String.valueOf(row[i]));
            }
            if (!Character.isDigit(row[i]) || i == row.length - 1) {
                if (number != 0) {
                    numberPositions.add(new NumberPosition(number, rowIndex, numberBeginIndex, i - 1));
                }
                number = 0;
                numberBeginIndex = -1;
            }
        }
    }

    private void extractGearPositions() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (String.valueOf(grid[i][j]).equals("*")) {
                    gearPositions.add(new GearPosition(i, j));
                }
            }
        }
    }
}
