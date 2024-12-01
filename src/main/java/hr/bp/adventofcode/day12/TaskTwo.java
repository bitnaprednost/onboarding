package hr.bp.adventofcode.day12;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    public static void main(String[] args) {
        String input = readInputForDay("day12");
        Game game = new Game(input);
        game.unfoldSprings();

        long sum = game.calculateSumOfDifferentArrangements();

        displayResult(sum);
    }
}
