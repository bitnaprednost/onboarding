package hr.bp.adventofcode.day09;

import hr.bp.adventofcode.Utils;

import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readInputForDay("day09");
        Sensor sensor = new Sensor(input);

        long sum = sensor.sumNextValues();

        Utils.displayResult(sum);
    }
}
