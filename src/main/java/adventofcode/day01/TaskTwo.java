package adventofcode.day01;

import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> lines = Utils.readUserInput();

        CalibrationDocument simpleCalibrationDocument = new CalibrationDocument(lines, new AdvancedCalibrationValueExtractionStrategy());
        int sum = simpleCalibrationDocument.calculateCalibrationValuesSum();
        Utils.displayCalibrationValuesSum(sum);
    }
}
