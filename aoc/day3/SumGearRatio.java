package day3;

public class SumGearRatio {

    public int sumGearRatio(String filename) {
        int totalSum = 0;

        // Split the file content into lines
        String[] lines = filename.split(System.lineSeparator());

        // Define the size of lines
        int rows = lines.length;
        int cols = lines[0].length();

        // Define the directions to check for adjacency
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Loop through lines row by row
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (lines[i].charAt(j) == '*')
                {
                    int[] adjacentNumbers = new int[2];
                    int adjacentCount = 0;

                    // Check all 8 directions for adjacent numbers
                    for (int d = 0; d < 8; d++)
                    {
                        int ni = i + dx[d];
                        int nj = j + dy[d];

                        // Ensure the adjacent cell is within bounds
                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols)
                        {
                            // Check if the adjacent cell contains a digit
                            if (Character.isDigit(lines[ni].charAt(nj)))
                            {
                                String partNumber = parseNumber(lines, ni, nj);

                                // Only add unique numbers
                                if (!partNumber.isEmpty() && adjacentCount < 2)
                                {
                                    int number = Integer.parseInt(partNumber);

                                    // Prevent duplicate numbers for the same gear
                                    if (adjacentCount == 0 || adjacentNumbers[0] != number)
                                    {
                                        adjacentNumbers[adjacentCount] = number;
                                        adjacentCount++;
                                    }
                                }
                            }
                        }
                    }

                    // If exactly two part numbers are adjacent, compute the gear ratio
                    if (adjacentCount == 2)
                    {
                        int gearRatio = adjacentNumbers[0] * adjacentNumbers[1];
                        totalSum += gearRatio;
                    }
                }
            }
        }

        return totalSum;
    }

    // Helper function to parse a full number at a given position
    private String parseNumber(String[] lines, int row, int col) {
        StringBuilder number = new StringBuilder();

        // Traverse horizontally to get the full number
        int startCol = col;
        while (startCol >= 0 && Character.isDigit(lines[row].charAt(startCol)))
        {
            startCol--;
        }
        startCol++;

        int endCol = col;
        while (endCol < lines[row].length() && Character.isDigit(lines[row].charAt(endCol)))
        {
            endCol++;
        }

        // Extract the number from the string
        for (int k = startCol; k < endCol; k++)
        {
            number.append(lines[row].charAt(k));
        }

        return number.toString();
    }
}
