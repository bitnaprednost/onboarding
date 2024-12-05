package aoc_2024.day1;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day1/locationIDs.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Calculate the total distance
        TotalDistance totalDistance = new TotalDistance();
        int totalSum = totalDistance.calculateTotalDistance(fileContent);

        logger.debug("Total distance is: {}", totalSum);

        SimilarityScore similarityScore = new SimilarityScore();
        totalSum = similarityScore.calculateSimilarityScore(fileContent);

        logger.debug("Total distance is: {}", totalSum);
    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}
