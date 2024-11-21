package adventofcode.day05;

import adventofcode.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {
    public static void main(String[] args) {
        String input = readInputForTask();
        Almanac almanac = new Almanac(input);
        long sum = almanac.findLowestLocationNumber();
        Utils.displayResult(sum);
    }

    private static String readInputForTask() {
        String filePath = "src/main/java/adventofcode/day05/input-task01.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return String.join("\n", lines);
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file: " + e.getMessage(), e);
        }
    }
}
