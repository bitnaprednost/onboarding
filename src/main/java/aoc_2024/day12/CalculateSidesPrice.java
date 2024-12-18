package aoc_2024.day12;

public class CalculateSidesPrice extends GardenPlot {

    private int area = 0;
    private int perimeter = 0;

    public int calculateCost(String[] map, int startRow, int startCol) {
        getAreaAndPerimeter(map, startRow, startCol);
        int cost = area * perimeter;

        area = 0;
        perimeter = 0;
        return cost;
    }

    private void getAreaAndPerimeter(String[] map, int startRow, int startCol) {}
}

