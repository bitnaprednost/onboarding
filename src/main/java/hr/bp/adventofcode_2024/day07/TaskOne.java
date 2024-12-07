package hr.bp.adventofcode_2024.day07;

import static hr.bp.adventofcode_2024.Utils.displayResult;
import static hr.bp.adventofcode_2024.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readInputForDay("day07");

        CalibrationProcessor calibrationProcessor = new CalibrationProcessor(input);

        displayResult(calibrationProcessor.calculateTotalCalibrationValue(false));
    }
}
