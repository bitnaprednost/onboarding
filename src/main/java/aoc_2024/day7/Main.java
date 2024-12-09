package aoc_2024.day7;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day7/CalibrationEquation.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        CalibrationWithTwoOperators calibration = new CalibrationWithTwoOperators();
        Long result = calibration.calculateCalibrationResult(fileContent);

        logger.debug("Total calibration result is: {}", result);

        CalibrationWithThreeOperators calibration2 = new CalibrationWithThreeOperators();
        result = calibration2.calculateCalibrationResult(fileContent);

        logger.debug("Total calibration result is: {}", result);
    }
    static final Logger logger = LoggerFactory.getLogger(Main.class);
}
