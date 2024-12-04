package hr.bp.adventofcode.day16;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    // takes about 2 hours to complete
    public static void main(String[] args) {
        String input = readInputForDay("day16");

        Contraption contraption = new Contraption(input);

        displayResult(contraption.countEnergizedTilesWhenBeamEntersAllDirections());
    }
}
