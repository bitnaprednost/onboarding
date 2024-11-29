package hr.bp.adventofcode.day11;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    public static void main(String[] args) {
        String input = readInputForDay("day11");
        Universe universe = new Universe(input);

        long sum = universe.getSumOfShortestPathsForExpansionFactor(1_000_000);

        displayResult(sum);
    }
}
