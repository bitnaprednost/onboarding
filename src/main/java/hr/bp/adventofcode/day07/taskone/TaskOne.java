package hr.bp.adventofcode.day07.taskone;


import hr.bp.adventofcode.Utils;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {
    public static void main(String[] args) {
        String input = Utils.readUserInputAsString();
        Game game = new Game(input);

        int sum = game.calculateActualWinnings();

        Utils.displayResult(sum);
    }
}
