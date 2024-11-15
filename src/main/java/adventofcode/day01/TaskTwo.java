package adventofcode.day01;

import adventofcode.Utils;

import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> lines = Utils.collectUserInputLines();

        CalibrationDocument advancedCalibrationDocument = new CalibrationDocument(lines, new WordsToDigitsDecorator(new SimpleCalibrationValueLineProcessing()));

        int sum = advancedCalibrationDocument.calculateCalibrationValuesSum();
        Utils.displayResult(sum);
    }
}
