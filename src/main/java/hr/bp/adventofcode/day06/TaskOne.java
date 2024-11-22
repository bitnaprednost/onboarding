package hr.bp.adventofcode.day06;

import static adventofcode.Utils.displayResult;
import static adventofcode.Utils.readUserInputAsString;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readUserInputAsString();
        RacesRunner racesRunner = new RacesRunner(input);

        long sum = racesRunner.multiplyResultsOfAllRaces();

        displayResult(sum);
    }
}
