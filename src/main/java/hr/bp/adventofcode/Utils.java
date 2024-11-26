package hr.bp.adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static List<String> collectUserInputLines() {
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

    public static String readUserInputAsString() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();

        while (true) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                break;
            }
            if (inputBuilder.length() > 0) {
                inputBuilder.append("\n");
            }
            inputBuilder.append(line);
        }

        return inputBuilder.toString();
    }

    public static void displayResult(Number sum) {
        System.out.printf("The result is %s.%n", sum);
    }
}
