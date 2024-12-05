package aoc_2023.day1;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2023/day1/calibration_document.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Calculate the sum of calibration values
        CalibrationSum calibration = new CalibrationSum();
        int totalSum = calibration.calibrationSum(fileContent);

        // Print the total sum
        logger.debug("Total sum of calibration values: {}" , totalSum);

        // Calculate the sum of calibration values with spelled numbers
        CalibrationSumWithSpelling calibrationSpelled = new CalibrationSumWithSpelling();
        int totalSumspelled = calibrationSpelled.calibrationSumWithSpelling(fileContent);

        // Print the total sum
        logger.debug("Total sum of calibration values: {}" , totalSumspelled);
    }

    static final Logger logger = LoggerFactory.getLogger(Main.class);
}
