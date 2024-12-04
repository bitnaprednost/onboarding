package hr.bp.adventofcode_2024.day04;

import static hr.bp.adventofcode_2024.Utils.displayResult;
import static hr.bp.adventofcode_2024.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    public static void main(String[] args) {
        String input = readInputForDay("day04");

        WordCounter wordCounter = new WordCounter(input);

        displayResult(wordCounter.countX_MASes());
    }
}
