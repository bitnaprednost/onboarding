package aoc_2024.day3;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day3/CorruptedMemory.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // solve task 1
        MulSequence mulSequence = new MulSequence();
        int mulSum = mulSequence.findMulSequence(fileContent, "mul\\((\\d+),(\\d+)\\)");

        logger.debug("Result of multiplication is: {}", mulSum);

        // solve task 2
        MulSequenceWithEnable mulSequenceWithEnable = new MulSequenceWithEnable();
        mulSum = mulSequenceWithEnable.findMulSequence(fileContent, "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");

        logger.debug("Result of enabled multiplication is: {}", mulSum);

    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}
