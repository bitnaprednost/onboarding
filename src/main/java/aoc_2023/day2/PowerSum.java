package aoc_2023.day2;

public class PowerSum {
    public int powerSum (String game_document){
        int totalSum = 0;

        // Split the file content into lines
        String[] lines = game_document.split(System.lineSeparator());

        // Process each line
        for (String line : lines)
        {
            // Split game data into game ID and rounds
            String[] parts = line.split(": ");

            // Extract rounds
            String[] rounds = parts[1].split("; ");

            // Initialize minimum required cubes
            int minRed = 0, minGreen = 0, minBlue = 0;

            for (String round : rounds)
            {
                // Parse the cubes in the round
                String[] cubes = round.split(", ");
                int redCount = 0, greenCount = 0, blueCount = 0;

                for (String cube : cubes)
                {
                    String[] cubeInfo = cube.split(" ");

                    // Extract count
                    int count = Integer.parseInt(cubeInfo[0]);
                    // Extract color
                    String color = cubeInfo[1];

                    // Find the maximum for each color in this round
                    switch (color) {
                        case "red":
                            redCount = Math.max(redCount, count);
                            break;
                        case "green":
                            greenCount = Math.max(greenCount, count);
                            break;
                        case "blue":
                            blueCount = Math.max(blueCount, count);
                            break;
                    }
                }

                // Update the minimum required cubes across all rounds
                minRed = Math.max(minRed, redCount);
                minGreen = Math.max(minGreen, greenCount);
                minBlue = Math.max(minBlue, blueCount);
            }

            // Calculate the power of the minimum set of cubes
            int power = minRed * minGreen * minBlue;

            // Add the power to the total
            totalSum += power;
        }

        // Return the total power
        return totalSum;

    }
}
