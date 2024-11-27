package hr.bp.adventofcode.day08;

import hr.bp.adventofcode.Utils;

import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    public static void main(String[] args) {
        String input = readInputForDay("day08");
        NodeNetwork game = new NodeNetwork(input);

        int sum = game.stepThroughNetworkInParallel();

        Utils.displayResult(sum);
    }
}
