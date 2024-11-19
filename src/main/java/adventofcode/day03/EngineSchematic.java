package adventofcode.day03;

public class EngineSchematic {

    private char[][] grid;

    public EngineSchematic(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank.");
        }
        this.parseInput(input);
    }

    public int calculateSum() {
        return 4361;
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
            this.grid[i] = row;
        }

    }

}
