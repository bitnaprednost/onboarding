package hr.bp.adventofcode.day16;

import java.util.concurrent.ExecutionException;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String input = readInputForDay("day16");

        Contraption contraption = new Contraption(input);

        displayResult(contraption.countEnergizedTilesWhenBeamEntersAllDirections());
    }
}
