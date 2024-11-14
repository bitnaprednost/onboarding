package adventofcode.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<String> readUserInput() {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine.isBlank()) {
                break;
            }
            lines.add(inputLine);
        }
        return lines;
    }


    public static void displayCalibrationValuesSum(int sum) {
        System.out.printf("Sum of calibration values is %s.%n", sum);
    }
}
