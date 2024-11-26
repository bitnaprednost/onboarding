package hr.bp.adventofcode.day02;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readUserInputAsString;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        GameRunnerPartOne gameRunnerPartOne = new GameRunnerPartOne(inputParser);
        Bag bag = new Bag(12, 13, 14);

        String userInput = readUserInputAsString();
        int result = gameRunnerPartOne.calculateSumOfPossibleGameIds(userInput, bag);

        displayResult(result);
    }
}
