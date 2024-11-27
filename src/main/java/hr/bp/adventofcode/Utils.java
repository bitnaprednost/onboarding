package hr.bp.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public static String readInputForDay(String day) {
        String filePath = "src/main/java/hr/bp/adventofcode/" + day + "/input.txt";

        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file: " + e.getMessage(), e);
        }
    }
}
