package hr.bp.adventofcode_2024.day03;

import hr.bp.adventofcode_2024.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ivan Tomičić
 */
public class Memory {

    private final List<Pair<Integer, Integer>> multiplicationInstructions = new ArrayList<>();

    public Memory(String input) {
        parseInput(input);
    }

    private void parseInput(String input) {
        for (String line : input.split("\\n")) {
            addMultiplicationsToList(line);
        }
    }

    private void addMultiplicationsToList(String line) {
        String regex = "mul\\((\\d+),(\\d+)\\)";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(line);

        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        for (String match : matches) {
            Integer leftNumber = Integer.parseInt(match.split(",")[0].split("\\(")[1]);
            Integer rightNumber = Integer.parseInt(match.split(",")[1].split("\\)")[0]);
            multiplicationInstructions.add(new Pair<>(leftNumber, rightNumber));
        }
    }

    public long sumMultiplications() {
        long sum = 0;
        for (Pair<Integer, Integer> pair : multiplicationInstructions) {
            sum += (long) pair.left() * pair.right();
        }
        return sum;
    }

    public List<Pair<Integer, Integer>> getMultiplicationInstructions() {
        return multiplicationInstructions;
    }
}
