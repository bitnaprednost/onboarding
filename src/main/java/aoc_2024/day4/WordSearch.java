package aoc_2024.day4;

public class WordSearch {

    protected int rows;
    protected int cols;
    private final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int wordSearch(String filename) {
        int totalSum = 0;

        // Split the file content into lines
        String[] lines = filename.split(System.lineSeparator());

        rows = lines.length;
        cols = lines[0].length();

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                int sum = findX(lines, i ,j);

                totalSum += sum;
            }
        }
        return totalSum;
    }

    protected int findX(String[] lines, int i, int j){
        int sum = 0;
        if (lines[i].charAt(j) == 'X')
        {
            // Check all 8 directions
            for (int d = 0; d < 8; d++)
            {
                // Check if the word "XMAS" fits in this direction
                boolean found = findMAS(lines, i, j, d);

                // If "XMAS" is found in this direction, increment the count
                if (found)
                {
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean findMAS(String[] lines, int ni, int nj, int d){
        boolean found = true;
        String word = "XMAS";

        for (int k = 1; k < word.length(); k++)
        {
            ni += dx[d];
            nj += dy[d];

            // Check bounds
            if (ni < 0 || ni >= rows || nj < 0 || nj >= cols)
            {
                found = false;
                break;
            }

            // Check if the character matches
            if (lines[ni].charAt(nj) != word.charAt(k))
            {
                found = false;
                break;
            }
        }
        return found;
    }
}

