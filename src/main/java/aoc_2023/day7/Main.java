package aoc_2023.day7;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2023/day7/camelCards.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Solve task 1
        CamelCards camelCards = new CamelCards();
        int win = camelCards.calculateWinning(fileContent);

        logger.debug("Total win is: {}",win);

        // Solve task 2
        CamelCardsWithJoker camelCardsWithJoker = new CamelCardsWithJoker();
        win = camelCardsWithJoker.calculateWinning(fileContent);

        logger.debug("Total win is: {}", win);
    }
    static final Logger logger = LoggerFactory.getLogger(Main.class);
}