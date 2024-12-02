package aoc_2023.day3;

public class SumPartNumbers {
    public int sumPartNumbers (String filename) {
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
            int j = 0;

            // Define string number
            String current_num = "";

            while (j < cols)
            {
                // Build the current number
                if (Character.isDigit(lines[i].charAt(j)))
                {
                    current_num = current_num.concat(String.valueOf(lines[i].charAt(j)));
                    j++;

                    if (j != cols)
                    {
                        continue;
                    }
                }

                // Parse the full number if it exists
                if (!current_num.isEmpty())
                {
                    int number = Integer.parseInt(current_num);

                    // Check adjacency for the full number
                    boolean isPartNumber = false;

                    // Check all digits of the number for adjacency
                    for (int k = j - current_num.length(); k < j; k++)
                    {
                        int row = i;
                        int col = k;

                        for (int d = 0; d < 8; d++)
                        {
                            int ni = row + dx[d];
                            int nj = col + dy[d];

                            // Ensure the adjacent cell is within bounds
                            if (ni >= 0 && ni < rows && nj >= 0 && nj < cols)
                            {
                                char adjacent = lines[ni].charAt(nj);

                                // Check if the adjacent cell is a symbol
                                if (!Character.isDigit(adjacent) && adjacent != '.')
                                {
                                    isPartNumber = true;
                                    break;
                                }
                            }
                        }

                        if (isPartNumber)
                        {
                            break;
                        }
                    }

                    // Add the number to the sum if it is a part number
                    if (isPartNumber)
                    {
                        totalSum += number;
                    }
                }

                // Move to the next character if no number was processed
                current_num = "";
                j++;
            }
        }

        return totalSum;
    }
}
