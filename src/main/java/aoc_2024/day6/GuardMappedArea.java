package aoc_2024.day6;

public class GuardMappedArea {

    protected int rows;
    protected int cols;
    protected int[] currentPosition = new int[2];
    protected char[][] map;

    public GuardMappedArea(String filename) {
        // Split the file content into lines
        String[] lines = filename.split(System.lineSeparator());

        map = new char[lines.length][];
        for (int i = 0; i < lines.length; i++)
        {
            map[i] = lines[i].toCharArray();
        }
        rows = map.length;
        cols = map[0].length;
    }

    public int getNumDistinctPosition(){
        findCurrentPosition();
        TrackMoves();
        return calculateDistinctPosition();
    }

    protected void findCurrentPosition(){
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (map[i][j] == '^')
                {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                    map[i][j] = 'X';
                    return;
                }
            }
        }
    }

    private void TrackMoves() {
        int guardRow = currentPosition[0];
        int guardCol = currentPosition[1];

        // Directions
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int currentDirection = 0;

        while (true)
        {
            int newRow = guardRow + dRow[currentDirection];
            int newCol = guardCol + dCol[currentDirection];

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols)
            {
                break;
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

                map[guardRow][guardCol] = 'X';
            }
        }
    }

    private int calculateDistinctPosition(){
        int result = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (map[i][j] == 'X')
                {
                    result++;
                }
            }
        }
        return result;
    }
}
