package aoc_2023.day4;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2023/day4/scratchcard.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Solve task 1
        TotalPoint ScratchcardSum = new TotalPoint();
        int totalSum = ScratchcardSum.totalPoint(fileContent);

        logger.debug("Total sum for task 1: {}",totalSum);

        // Solve task 2
        TotalCardNumber ScratchcardNum = new TotalCardNumber();
        totalSum = ScratchcardNum.totalCardNumber(fileContent);

        logger.debug("Total sum for task 1: {}",totalSum);
    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}