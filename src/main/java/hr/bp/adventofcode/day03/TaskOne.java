package hr.bp.adventofcode.day03;

import hr.bp.adventofcode.Utils;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = Utils.readUserInputAsString();
        EngineSchematic engineSchematic = new EngineSchematic(input);

        int sum = engineSchematic.calculateSum();

        Utils.displayResult(sum);
    }
}
