package aoc_2024.day6;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day6/Map.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        GuardMappedArea guardMappedArea = new GuardMappedArea(fileContent);
        int result = guardMappedArea.getNumDistinctPosition();

        logger.debug("Number of distinct positions is : {}", result);

        GuardLoopDetector guardLoopDetector = new GuardLoopDetector(fileContent);
        result = guardLoopDetector.findLoopObstructions();

        logger.debug("Number of loop obstructions is : {}", result);
    }
    static final Logger logger = LoggerFactory.getLogger(Main.class);
}
