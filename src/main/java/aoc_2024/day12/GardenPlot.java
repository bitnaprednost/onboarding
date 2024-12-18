package aoc_2024.day12;

public abstract class GardenPlot {

    public int rows;
    public int cols;

    public boolean[][] visited;


    public int calculateTotalCost(String input) {

        // Split the file content into lines
        String[] lines = input.split(System.lineSeparator());

        rows = lines.length;
        cols = lines[0].length();

        visited = new boolean[rows][cols];
        int totalCost = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    totalCost += calculateCost(lines, i, j);
                }
            }
        }
        return totalCost;
    }

    abstract int calculateCost(String[] map, int startRow, int startCol);
}