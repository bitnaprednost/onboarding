package hr.bp.adventofcode.day01;

import adventofcode.Utils;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {
    public static void main(String[] args) {
        List<String> lines = Utils.collectUserInputLines();

        CalibrationValueExtractionStrategy simpleStrategy = new SimpleCalibrationValueExtractionStrategy();
        CalibrationValueExtractionStrategy advancedStrategy = new WordsToDigitsDecorator(simpleStrategy);

        CalibrationDocument advancedCalibrationDocument = new CalibrationDocument(lines, advancedStrategy);

        int sum = advancedCalibrationDocument.calculateCalibrationValuesSum();
        Utils.displayResult(sum);
    }
}
