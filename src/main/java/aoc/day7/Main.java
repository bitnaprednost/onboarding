package aoc.day7;

import aoc.io.ReadFile;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc/day7/camelCards.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Solve task 1
        CamelCards camelCards = new CamelCards();
        int win = camelCards.calculateWinning(fileContent);

        System.out.println(win);

        // Solve task 2
        CamelCardsWithJoker camelCardsWithJoker = new CamelCardsWithJoker();
        win = camelCardsWithJoker.calculateWinning(fileContent);

        System.out.println(win);
    }
}