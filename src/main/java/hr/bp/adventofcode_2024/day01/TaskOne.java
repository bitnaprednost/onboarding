package hr.bp.adventofcode_2024.day01;

import static hr.bp.adventofcode_2024.Utils.displayResult;
import static hr.bp.adventofcode_2024.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readInputForDay("day01");

        LocationList locationList = new LocationList(input);

        displayResult(locationList.getSumOfDistances());
    }
}
