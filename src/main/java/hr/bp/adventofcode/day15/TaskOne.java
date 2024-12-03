package hr.bp.adventofcode.day15;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readInputForDay("day15");

        InitializationSequence initializationSequence = new InitializationSequence(input);

        displayResult(initializationSequence.getSumOfHashes());
    }
}
