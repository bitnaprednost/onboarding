package aoc_2023.day6;

import io.ReadFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2023/day6/race_data.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Solve task 1
        Race race = new Race();
        int totalSum = race.calculateWins(fileContent);

        logger.debug("Total sum is: {}", totalSum);

        // Solve task 2
        totalSum = race.calculateWins2(fileContent);
        logger.debug("Total sum is: {}", totalSum);

    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}
