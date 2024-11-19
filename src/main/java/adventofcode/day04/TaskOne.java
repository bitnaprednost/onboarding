package adventofcode.day04;

import adventofcode.Utils;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    private static final long MINIMUM_X = 200000000000000L;
    private static final long MINIMUM_Y = 200000000000000L;
    private static final long MAXIMUM_X = 400000000000000L;
    private static final long MAXIMUM_Y = 400000000000000L;

    public static void main(String[] args) {
        String input = Utils.readUserInputAsString();
        Experiment experiment = new Experiment(input, MINIMUM_X, MINIMUM_Y, MAXIMUM_X, MAXIMUM_Y);
        int sum = experiment.calculateNumberOfIntersectionsWithinTestArea();
        Utils.displayResult(sum);
    }
}
