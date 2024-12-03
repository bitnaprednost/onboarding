package hr.bp.adventofcode_2024.day03;

import hr.bp.adventofcode_2024.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ivan Tomičić
 */
public class Memory {

    private final Map<Integer, Pair<Integer, Integer>> multiplicationInstructions = new HashMap<>();

    private final Map<Integer, Boolean> conditions = new HashMap<>();

    public Memory(String input) {
        parseInput(input);
    }

    private void parseInput(String input) {
        extractMultiplications(input);
        extractConditions(input);
    }

    private void extractConditions(String line) {
        conditions.put(0, true);

        String regex = "do\\(\\)|don't\\(\\)";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            boolean isDo = matcher.group().equals("do()");
            conditions.put(matcher.end() - 1, isDo);
        }
    }

    private void extractMultiplications(String line) {
        String regex = "mul\\((\\d+),(\\d+)\\)";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            String match = matcher.group();

            Integer leftNumber = Integer.parseInt(match.split(",")[0].split("\\(")[1]);
            Integer rightNumber = Integer.parseInt(match.split(",")[1].split("\\)")[0]);

            int startIndex = matcher.start();

            multiplicationInstructions.put(startIndex, new Pair<>(leftNumber, rightNumber));
        }
    }

    public long sumMultiplications() {
        long sum = 0;
        for (Pair<Integer, Integer> pair : multiplicationInstructions.values()) {
            sum += (long) pair.left() * pair.right();
        }
        return sum;
    }

    public long sumMultiplicationsWithConditions() {
        long sum = 0;
        for (Map.Entry<Integer, Pair<Integer, Integer>> entry : multiplicationInstructions.entrySet()) {
            boolean condition = findNearestCondition(entry.getKey());
            if (condition) {
                Pair<Integer, Integer> pair = entry.getValue();
                sum += (long) pair.left() * pair.right();
            }
        }
        return sum;
    }

    private boolean findNearestCondition(int index) {
        while (index >= 0) {
            if (conditions.get(index) != null) return conditions.get(index);
            index--;
        }
        return true;
    }

    public Map<Integer, Pair<Integer, Integer>> getMultiplicationInstructions() {
        return multiplicationInstructions;
    }
}
