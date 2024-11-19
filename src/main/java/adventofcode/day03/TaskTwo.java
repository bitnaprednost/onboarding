package adventofcode.day03;

import adventofcode.Utils;

public class TaskTwo {
    public static void main(String[] args) {
        String input = Utils.readUserInputAsString();
        EngineSchematic engineSchematic = new EngineSchematic(input);
        int sum = engineSchematic.calculateSumOfGearRatios();
        Utils.displayResult(sum);
    }
}
