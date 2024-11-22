package hr.bp.adventofcode.day02;

import java.util.List;
import java.util.Map;

public class GameRunnerPartTwo {
    InputParser inputParser;

    public GameRunnerPartTwo(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int calculateSumOfPowerOfSets(String input) {
        Map<Integer, List<Map<Color, Integer>>> parsedInput = inputParser.parse(input);
        int sum = 0;
        for (List<Map<Color, Integer>> line : parsedInput.values()) {
            sum += getPowerOfSetOfCubes(line);
        }
        return sum;
    }

    private int getPowerOfSetOfCubes(List<Map<Color, Integer>> setOfCubes) {
        int minimumRed = getMinimumCubesForColor(setOfCubes, Color.RED);
        int minimumGreen = getMinimumCubesForColor(setOfCubes, Color.GREEN);
        int minimumBlue = getMinimumCubesForColor(setOfCubes, Color.BLUE);
        return minimumRed * minimumGreen * minimumBlue;
    }

    private int getMinimumCubesForColor(List<Map<Color, Integer>> setOfCubes, Color color) {
        int minimum = 0;
        for (Map<Color, Integer> entry : setOfCubes) {
            minimum = Math.max(minimum, entry.getOrDefault(color, 0));
        }
        return minimum;
    }
}
