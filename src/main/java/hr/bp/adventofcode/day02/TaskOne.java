package hr.bp.adventofcode.day02;

import static adventofcode.Utils.displayResult;
import static adventofcode.Utils.readUserInputAsString;

public class TaskOne {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        GameRunner gameRunner = new GameRunner(inputParser);
        Bag bag = new Bag(12, 13, 14);

        String userInput = readUserInputAsString();
        int result = gameRunner.calculateSumOfPossibleGameIds(userInput, bag);

        displayResult(result);
    }
}
