package adventofcode.day02;

import static adventofcode.Utils.displayResult;
import static adventofcode.Utils.readUserInputAsString;

public class TaskTwo {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        GameRunnerPartTwo gameRunner = new GameRunnerPartTwo(inputParser);

        String userInput = readUserInputAsString();
        int result = gameRunner.calculateSumOfPowerOfSets(userInput);

        displayResult(result);


    }
}
