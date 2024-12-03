package hr.bp.adventofcode.day14;

import static hr.bp.adventofcode.Utils.displayResult;
import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readInputForDay("day14");

        Platform platform = new Platform(input);
        platform.tilt(PlatformDirection.NORTH);

        displayResult(platform.calculateTotalLoad());
    }
}
