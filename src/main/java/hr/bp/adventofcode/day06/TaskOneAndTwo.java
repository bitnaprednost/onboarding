package hr.bp.adventofcode.day06;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readUserInputAsString;

/**
 * @author Ivan Tomičić
 */
public class TaskOneAndTwo {

    public static void main(String[] args) {
        String input = readUserInputAsString();
        RacesRunnerFirstTask racesRunnerFirstTask = new RacesRunnerFirstTask(input);

        long sum = racesRunnerFirstTask.multiplyResultsOfAllRaces();

        displayResult(sum);
    }
}
