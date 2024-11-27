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

        for(PolynomialEquation p : sensor.getHistory()) {
            System.out.println(p.getCoefficients());
        }

        Utils.displayResult(sum);
    }
}
// 1934898160
// 191084735742
// 191084735652