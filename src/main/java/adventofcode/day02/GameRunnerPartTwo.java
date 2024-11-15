package adventofcode.day02;

import java.util.List;
import java.util.Map;

public class GameRunnerPartTwo {
    InputParser inputParser;

    public GameRunnerPartTwo(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int calculateSumOfPowerOfSets(String input) {
        Map<Integer, List<Map<ColorEnum, Integer>>> parsedInput = inputParser.parse(input);
        int sum = 0;
        for (List<Map<ColorEnum, Integer>> line : parsedInput.values()) {
            sum += getPowerOfSetOfCubes(line);
        }
        return sum;
    }

    private int getPowerOfSetOfCubes(List<Map<ColorEnum, Integer>> setOfCubes) {
        int minimumRed = getMinimumCubesForColor(setOfCubes, ColorEnum.RED);
        int minimumGreen = getMinimumCubesForColor(setOfCubes, ColorEnum.GREEN);
        int minimumBlue = getMinimumCubesForColor(setOfCubes, ColorEnum.BLUE);
        return minimumRed * minimumGreen * minimumBlue;
    }

    private int getMinimumCubesForColor(List<Map<ColorEnum, Integer>> setOfCubes, ColorEnum colorEnum) {
        int minimum = 0;
        for (Map<ColorEnum, Integer> entry : setOfCubes) {
            minimum = Math.max(minimum, entry.getOrDefault(colorEnum, 0));
        }
        return minimum;
    }
}
