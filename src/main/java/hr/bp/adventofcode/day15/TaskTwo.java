package hr.bp.adventofcode.day15;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    public static void main(String[] args) {
        String input = readInputForDay("day15");

        LensConfiguration lensConfiguration = new LensConfiguration(input);

        displayResult(lensConfiguration.getFocusingPower());
    }
}
