package adventofcode.day01;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) {
        List<String> lines = Utils.readUserInput();

        CalibrationDocument simpleCalibrationDocument = new CalibrationDocument(lines, new SimpleCalibrationValueExtractionStrategy());
        int sum = simpleCalibrationDocument.calculateCalibrationValuesSum();
        Utils.displayCalibrationValuesSum(sum);
    }

}
