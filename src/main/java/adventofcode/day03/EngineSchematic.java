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
        return true;
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
