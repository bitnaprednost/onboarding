package hr.bp.adventofcode.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.day10.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day10.TestUtils.getFirstInputGrid;
import static hr.bp.adventofcode.day10.TestUtils.getSecondInput;

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

    @Test
    public void walkThroughMaze_givenValidInputOne_returnsCorrectFarthestPosition() {
        String input = getFirstInput();
        PipeMaze pipeMaze = new PipeMaze(input);

        int expectedFarthestPosition= 8;

        int actualFarthestPosition = pipeMaze.findFarthestPosition();

        Assertions.assertEquals(expectedFarthestPosition, actualFarthestPosition);
    }

    @Test
    public void walkThroughMaze_givenValidInputTwo_returnsCorrectFarthestPosition() {
        String input = getSecondInput();
        PipeMaze pipeMaze = new PipeMaze(input);

        int expectedFarthestPosition= 4;

        int actualFarthestPosition = pipeMaze.findFarthestPosition();

        Assertions.assertEquals(expectedFarthestPosition, actualFarthestPosition);
    }
}
