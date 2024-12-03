package hr.bp.adventofcode_2024.day03;

import static hr.bp.adventofcode_2024.Utils.displayResult;
import static hr.bp.adventofcode_2024.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readInputForDay("day03");

        Memory memory = new Memory(input);

        displayResult(memory.sumMultiplications());
    }
}
