package hr.bp.adventofcode.day24;

import hr.bp.adventofcode.Utils;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    // TODO: 2nd part is very tricky, you have to assume perhaps that there will be some 2 points that
    //  whose trajectories lie on a same plane (https://www.reddit.com/r/adventofcode/comments/18pnycy/comment/kgrlm39) which would simplify finding the solution.
    //  https://chatgpt.com/c/673cbb70-5884-8010-a071-0c7b11a7b9d4

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
