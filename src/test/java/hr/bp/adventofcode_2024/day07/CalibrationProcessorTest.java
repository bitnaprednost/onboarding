package hr.bp.adventofcode_2024.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode_2024.Utils.readInputForDay;
import static hr.bp.adventofcode_2024.day07.TestUtils.getFirstInput;

/**
 * @author Ivan Tomičić
 */
public class CalibrationProcessorTest {

    @Test
    public void calculateTotalCalibrationValue_givenInputOne_returnsCorrectResult() {
        String input = getFirstInput();
        CalibrationProcessor calibrationProcessor = new CalibrationProcessor(input);

        long expectedSum = 3749;

        long actualSum = calibrationProcessor.calculateTotalCalibrationValue(false);

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateTotalCalibrationValue_givenTaskInput_returnsCorrectResult() {
        String input = readInputForDay("day07");
        CalibrationProcessor calibrationProcessor = new CalibrationProcessor(input);

        long expectedSum = 3598800864292L;

        long actualSum = calibrationProcessor.calculateTotalCalibrationValue(false);

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateTotalCalibrationValueWithConcatenationEnabled_givenInputOne_returnsCorrectResult() {
        String input = getFirstInput();
        CalibrationProcessor calibrationProcessor = new CalibrationProcessor(input);

        long expectedSum = 11387;

        long actualSum = calibrationProcessor.calculateTotalCalibrationValue(true);

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateTotalCalibrationValueWithConcatenationEnabled_givenTaskInput_returnsCorrectResult() {
        String input = readInputForDay("day07");
        CalibrationProcessor calibrationProcessor = new CalibrationProcessor(input);

        long expectedSum = 340362529351427L;

        long actualSum = calibrationProcessor.calculateTotalCalibrationValue(true);

        Assertions.assertEquals(expectedSum, actualSum);
    }
}
