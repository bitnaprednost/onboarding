package hr.bp.adventofcode.day16;

import java.util.concurrent.ExecutionException;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    // WARNING: takes about 10 minutes to complete, utilizes all CPU cores.
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String input = readInputForDay("day16");

        Contraption contraption = new Contraption(input);

        displayResult(contraption.countEnergizedTilesWhenBeamEntersAllDirections());
    }
}
