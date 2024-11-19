package adventofcode.day04;

import adventofcode.Utils;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    private static final int MINIMUM_X = 7;
    private static final int MINIMUM_Y = 7;
    private static final int MAXIMUM_X = 27;
    private static final int MAXIMUM_Y = 27;

    public static void main(String[] args) {
        String input = Utils.readUserInputAsString();
        Experiment experiment = new Experiment(input, MINIMUM_X, MINIMUM_Y, MAXIMUM_X, MAXIMUM_Y);
        int sum = experiment.calculateNumberOfIntersectionsWithinTestArea();
        Utils.displayResult(sum);
    }
}
