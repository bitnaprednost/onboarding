package day2;

public class GameIDSum {
    public int gameIDSum (String game_document){
        int totalSum = 0;

        // Split the file content into lines
        String[] lines = game_document.split(System.lineSeparator());

        int red_limit = 12;
        int green_limit = 13;
        int blue_limit = 14;

        // Process each line
        for (String line : lines)
        {
            // Split game data into game ID and rounds
            String[] parts = line.split(": ");

            String gameIdPart = parts[0];
            // Extract the game ID
            int gameId = Integer.parseInt(gameIdPart.replace("Game ", "").trim());

            // Extract rounds
            String[] rounds = parts[1].split("; ");

            boolean isGamePossible = true;
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

                    // Increment the corresponding color count
                    switch (color)
                    {
                        case "red":
                            redCount += count;
                            break;
                        case "green":
                            greenCount += count;
                            break;
                        case "blue":
                            blueCount += count;
                            break;
                    }
                }

                // Check if the round exceeds any limit
                if (redCount > red_limit || greenCount > green_limit || blueCount > blue_limit)
                {
                    isGamePossible = false;
                    break;
                }
            }

            // If the game is possible, add the game ID to the total sum
            if (isGamePossible)
            {
                totalSum += gameId;
            }
        }

        // Return the total sum
        return totalSum;

    }
}

