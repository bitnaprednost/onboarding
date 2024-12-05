package hr.bp.adventofcode_2024.day05;

import static hr.bp.adventofcode_2024.Utils.displayResult;
import static hr.bp.adventofcode_2024.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    public static void main(String[] args) {
        String input = readInputForDay("day05");

        PageProcessor pageProcessor = new PageProcessor(input);

        displayResult(pageProcessor.calculateSumOfMiddleNumbersForUnorderedPages());
    }
}
