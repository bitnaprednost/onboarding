package hr.bp.adventofcode.day04;

import adventofcode.Utils;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = Utils.readUserInputAsString();
        Game game = new Game(input);

        int sum = game.calculateTotalPoints();

        Utils.displayResult(sum);
    }
}
