package aoc.day2;

import aoc.io.ReadFile;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc/day2/games.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Calculate the sum of games Ids
        GameIDSum gameID = new GameIDSum();
        int totalSum = gameID.gameIDSum(fileContent);

        System.out.println("Total sum of game IDs is: " + totalSum);

        // Calculate the power sum
        PowerSum power = new PowerSum();
        int totalPowerSum = power.powerSum(fileContent);

        System.out.println("Total sum of the power of sets: " + totalPowerSum);
    }
}
