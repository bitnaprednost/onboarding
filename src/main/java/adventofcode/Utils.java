package adventofcode;

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
            if (line.isBlank()) { // Break the loop if the user enters a blank line
                break;
            }
            if (inputBuilder.length() > 0) {
                inputBuilder.append("\n"); // Add newline before appending the next line
            }
            inputBuilder.append(line); // Append the user input to the builder
        }

        return inputBuilder.toString();
    }

    public static void displayResult(int sum) {
        System.out.printf("The result is %s.%n", sum);
    }
}
