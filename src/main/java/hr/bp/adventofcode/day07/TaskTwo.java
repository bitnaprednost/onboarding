package hr.bp.adventofcode.day07;

import hr.bp.adventofcode.Utils;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {
    public static void main(String[] args) {
        String input = Utils.readUserInputAsString();
        Game game = new Game(input, true);

        int sum = game.calculateActualWinnings();

        Utils.displayResult(sum);
    }
}
