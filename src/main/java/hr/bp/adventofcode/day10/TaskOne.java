package hr.bp.adventofcode.day10;

import java.util.Arrays;

import static hr.bp.adventofcode.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {
    public static void main(String[] args) {
        String input = readInputForDay("day10");
        PipeMaze pipeMaze = new PipeMaze(input);

        System.out.println(Arrays.deepToString(pipeMaze.getGrid()));
    }
}
