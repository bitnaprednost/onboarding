package aoc_2024.day12;

import java.util.*;

public class CalculatePerimeterPrice extends GardenPlot {

    private int area = 0;
    private int perimeter = 0;

    public int calculateCost(String[] map, int startRow, int startCol) {
        getAreaAndPerimeter(map, startRow, startCol);

        int cost = area * perimeter;

        area = 0;
        perimeter = 0;
        return cost;
    }

    private void getAreaAndPerimeter(String[] map, int startRow, int startCol) {
        char plantType = map[startRow].charAt(startCol);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});

        // Directions for neighbors: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;
            area++;

            for (int[] dir : directions) {

                int[] neighbour = new int[] {row + dir[0], col + dir[1]};
                findNeighbours(neighbour, plantType, map, queue);
            }
        }
    }

    private void findNeighbours(int[] neighbour, char plantType, String[] map, Queue<int[]> queue){

        if (neighbour[0] >= 0 && neighbour[0] < rows && neighbour[1] >= 0 && neighbour[1] < cols) {
            if (map[neighbour[0]].charAt(neighbour[1]) == plantType) {
                if (!visited[neighbour[0]][neighbour[1]]) {
                    queue.add(new int[]{neighbour[0], neighbour[1]});
                }
            } else {
                perimeter++;
            }
        } else {
            perimeter++;
        }

    }
}
