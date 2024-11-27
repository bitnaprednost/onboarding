package hr.bp.adventofcode.day09;

import hr.bp.adventofcode.Utils;

import java.math.BigDecimal;

import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskTwo {

    public static void main(String[] args) {
        String input = readInputForDay("day09");
        Sensor sensor = new Sensor(input);

        BigDecimal sum = sensor.sumPreviousValues();

        Utils.displayResult(sum);
    }

}
