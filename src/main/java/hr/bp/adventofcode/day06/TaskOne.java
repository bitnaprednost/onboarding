package hr.bp.adventofcode.day06;

import static adventofcode.Utils.displayResult;
import static adventofcode.Utils.readUserInputAsString;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readUserInputAsString();
        RacesRunnerFirstTask racesRunnerFirstTask = new RacesRunnerFirstTask(input);

        long sum = racesRunnerFirstTask.multiplyResultsOfAllRaces();

        displayResult(sum);
    }
}
