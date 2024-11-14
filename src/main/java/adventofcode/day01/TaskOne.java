package adventofcode.day01;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine.isBlank()) {
                break;
            }
            lines.add(inputLine);
        }

        CalibrationDocument calibrationDocument = new CalibrationDocument();
        calibrationDocument.setLines(lines);
        int sum = calibrationDocument.calculateCalibrationValuesSum();
        calibrationDocument.displayCalibrationValuesSum(sum);
    }
}
