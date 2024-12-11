package aoc_2024.day7;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalibrationWithThreeOperatorsTest {
    CalibrationWithThreeOperators calibration = new CalibrationWithThreeOperators();

    @Test
    void calculateCalibrationResult_example() {

        String input = """
                190: 10 19
                3267: 81 40 27
                83: 17 5
                156: 15 6
                7290: 6 8 6 15
                161011: 16 10 13
                192: 17 8 14
                21037: 9 7 18 13
                292: 11 6 16 20
                """;

        assertEquals(11387, calibration.calculateCalibrationResult(input));
    }

    @Test
    void calculateCalibrationResult_input_puzzle() {

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day7/CalibrationEquation.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        assertEquals(581941094529163L, calibration.calculateCalibrationResult(fileContent));
    }

}