package hr.bp.adventofcode.day08;

import hr.bp.adventofcode.Utils;

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
        NodeNetwork game = new NodeNetwork(input);

        int sum = game.stepThroughNetwork();

        Utils.displayResult(sum);
    }

    private static String readInputForTask() {
        String filePath = "src/main/java/hr/bp/adventofcode/day08/input-task01.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return String.join("\n", lines);
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file: " + e.getMessage(), e);
        }
    }
}
