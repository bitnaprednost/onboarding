package hr.bp.adventofcode.day13;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    public static void main(String[] args) {
        String input = readInputForDay("day13");

        ValleyOfPatterns valleyOfPatterns = new ValleyOfPatterns(input);

        displayResult(valleyOfPatterns.getSummarizationOfNotesWithoutASmudge());
    }
}
