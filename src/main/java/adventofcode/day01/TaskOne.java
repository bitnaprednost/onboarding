package adventofcode.day01;


import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine.isBlank()) {
                break;
            }
            stringBuilder.append(inputLine);
        }
        CalibrationDocument calibrationDocument = new CalibrationDocument();
        calibrationDocument.setLinesFromInputString(stringBuilder.toString());
        int sum = calibrationDocument.calculateCalibrationValuesSum();
        calibrationDocument.displayCalibrationValuesSum(sum);
    }
}
