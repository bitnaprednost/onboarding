package aoc.day6;

import aoc.io.ReadFile;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc/day6/race_data.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Solve task 1
        Race race = new Race();
        int totalSum = race.calculateWins(fileContent);

        System.out.println(totalSum);

        // Solve task 2
        totalSum = race.calculateWins2(fileContent);
        System.out.println(totalSum);

    }
}
