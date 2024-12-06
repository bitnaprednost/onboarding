package aoc_2024.day6;

import java.util.*;

public class GuardLoopDetector extends GuardMappedArea {

    public GuardLoopDetector(String filename) {
        super(filename);
    }

    public int findLoopObstructions() {
        findCurrentPosition();
        map[currentPosition[0]][currentPosition[1]] = '.';

        List<int[]> possibleObstructions = getPossibleObstructions();

        return getValidObstructions(possibleObstructions);
    }

    private List<int[]> getPossibleObstructions(){
        List<int[]> possibleObstructions = new ArrayList<>();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (map[i][j] == '.')
                {
                    possibleObstructions.add(new int[]{i, j});
                }
            }
        }
        return possibleObstructions;
    }

    private int getValidObstructions(List<int[]> possibleObstructions){
        int startRow = currentPosition[0];
        int startCol = currentPosition[1];

        int validObstructionCount = 0;
        for (int[] obstruction : possibleObstructions)
        {
            int obstructRow = obstruction[0];
            int obstructCol = obstruction[1];

            // Place the obstruction temporarily
            map[obstructRow][obstructCol] = '#';

            if (guardGetsStuck(startRow, startCol))
            {
                validObstructionCount++;
            }

            map[obstructRow][obstructCol] = '.';
        }
        return validObstructionCount;
    }

    private boolean guardGetsStuck(int startRow, int startCol) {
        // Directions
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int currentDirection = 0;
        int guardRow = startRow, guardCol = startCol;

        // Track visited positions with direction
        Set<String> visited = new HashSet<>();

        while (true)
        {
            String state = guardRow + "," + guardCol + "," + currentDirection;

            if (visited.contains(state))
            {
                // If the state has been visited before, the guard is in a loop
                return true;
            }

            visited.add(state);

            int newRow = guardRow + dRow[currentDirection];
            int newCol = guardCol + dCol[currentDirection];

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols)
            {
                return false;
            }

            // Check for obstacles
            if (map[newRow][newCol] == '#')
            {
                currentDirection = (currentDirection + 1) % 4;
            }
            else
            {
                guardRow = newRow;
                guardCol = newCol;
            }
        }
    }
}
