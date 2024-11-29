package hr.bp.adventofcode.day11;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readInputForDay("day11");
        Universe universe = new Universe(input);
        universe.expand();

        int sum = universe.getSumOfShortestPaths();

        displayResult(sum);
    }
}
