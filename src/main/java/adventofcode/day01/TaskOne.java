package adventofcode.day01;

import adventofcode.Utils;

import java.util.List;

public class TaskOne {

    public static void main(String[] args) {
        List<String> lines = Utils.collectUserInputLines();

        CalibrationDocument simpleCalibrationDocument = new CalibrationDocument(lines, new SimpleCalibrationValueLineProcessing());

        int sum = simpleCalibrationDocument.calculateCalibrationValuesSum();
        Utils.displayResult(sum);
    }

}
