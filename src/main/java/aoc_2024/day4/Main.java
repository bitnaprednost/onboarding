package aoc_2024.day4;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day4/WordSearch.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        WordSearch search = new WordSearch();
        int totalSum = search.wordSearch(fileContent);

        logger.debug("Total times that XMAS appear is: {}", totalSum);

        WordSearch2 search2 = new WordSearch2();
        totalSum = search2.wordSearch(fileContent);

        logger.debug("Total times that MAS appear is: {}", totalSum);
    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}
