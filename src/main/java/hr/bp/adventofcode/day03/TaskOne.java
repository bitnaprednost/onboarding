package hr.bp.adventofcode.day03;

import adventofcode.Utils;

public class TaskOne {

    public static void main(String[] args) {
        String input = Utils.readUserInputAsString();
        EngineSchematic engineSchematic = new EngineSchematic(input);

        int sum = engineSchematic.calculateSum();

        Utils.displayResult(sum);
    }
}
