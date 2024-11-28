package aoc.day5;

import aoc.io.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "src/main/resources/aoc/day5/seeds.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Solve task 1
        Seed seedClass = new Seed(fileContent);
        ArrayList<Long> seeds = seedClass.parseSeeds();
        SeedToLocation location = new SeedToLocation();
        long lowestLocation = location.seedToLocation(fileContent, seeds);
        System.out.println("Lowest location is: " + lowestLocation);

        // Solve task 2
        Seed seedClass2 = new Seed(fileContent);
        List<Range> seedRanges = seedClass2.parseSeedRanges();
        long lowestLocation2 = location.seedToLocationFromRanges(fileContent, seedRanges);
        System.out.println("Lowest location from ranges is: " + lowestLocation2);

    }
}

