package hr.bp.adventofcode.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.day10.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day10.TestUtils.getFirstInputGrid;

/**
 * @author Ivan Tomičić
 */
public class PipeMazeTest {

    @Test
    public void parseInput_givenValidInputOne_parsesCorrectly() {
        String input = getFirstInput();
        PipeMaze pipeMaze = new PipeMaze(input);

        GridElement[][] expectedGrid = getFirstInputGrid();

        GridElement[][] actualGrid = pipeMaze.getGrid();

        Assertions.assertArrayEquals(expectedGrid, actualGrid);
    }
}
