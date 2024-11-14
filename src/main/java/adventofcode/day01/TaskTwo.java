package adventofcode.day01;

import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> lines = Utils.readUserInput();

        CalibrationValueExtractionStrategy simpleStrategy = new SimpleCalibrationValueExtractionStrategy();
        CalibrationValueExtractionStrategy advancedStrategy = new WordsToNumbersDecorator(simpleStrategy);

        CalibrationDocument advancedCalibrationDocument = new CalibrationDocument(lines, advancedStrategy);

        int sum = advancedCalibrationDocument.calculateCalibrationValuesSum();
        Utils.displayCalibrationValuesSum(sum);
    }
}
