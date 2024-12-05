package aoc_2023.day5;

import io.ReadFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2023/day5/seeds.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Solve task 1
        Seed seedClass = new Seed(fileContent);
        ArrayList<Long> seeds = seedClass.parseSeeds();
        SeedToLocation location = new SeedToLocation();
        long lowestLocation = location.seedToLocation(fileContent, seeds);
        logger.debug("Lowest location is: {}", lowestLocation);

        // Solve task 2
        Seed seedClass2 = new Seed(fileContent);
        List<Range> seedRanges = seedClass2.parseSeedRanges();
        long lowestLocation2 = location.seedToLocationFromRanges(fileContent, seedRanges);
        logger.debug("Lowest location from ranges is: {}", lowestLocation2);

    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}

