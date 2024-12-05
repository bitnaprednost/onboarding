package aoc_2023.day2;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2023/day2/games.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Calculate the sum of games Ids
        GameIDSum gameID = new GameIDSum();
        int totalSum = gameID.gameIDSum(fileContent);

        logger.debug("Total sum of game IDs is: {}", totalSum);

        // Calculate the power sum
        PowerSum power = new PowerSum();
        int totalPowerSum = power.powerSum(fileContent);

        logger.debug("Total sum of the power of sets: {}", totalPowerSum);
    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}
