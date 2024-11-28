package hr.bp.adventofcode.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.Utils.readInputForDay;
import static hr.bp.adventofcode.day10.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day10.TestUtils.getFirstInputGrid;
import static hr.bp.adventofcode.day10.TestUtils.getFourthInput;
import static hr.bp.adventofcode.day10.TestUtils.getSecondInput;
import static hr.bp.adventofcode.day10.TestUtils.getThirdInput;

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

    @Test
    public void walkThroughMaze_givenValidTaskInput_returnsCorrectFarthestPosition() {
        String input = readInputForDay("day10");
        PipeMaze pipeMaze = new PipeMaze(input);

        int expectedFarthestPosition= 6717;

        int actualFarthestPosition = pipeMaze.findFarthestPosition();

        Assertions.assertEquals(expectedFarthestPosition, actualFarthestPosition);
    }

    @Test
    public void calculateAreaOfTheMainLoop_givenValidInputTwo_returnsCorrectArea() {
        String input = getSecondInput();
        PipeMaze pipeMaze = new PipeMaze(input);

        int expectedArea= 1;

        int actualArea = pipeMaze.calculateAreaOfTheMainLoop();

        Assertions.assertEquals(expectedArea, actualArea);
    }

    @Test
    public void calculateAreaOfTheMainLoop_givenValidInputThree_returnsCorrectArea() {
        String input = getThirdInput();
        PipeMaze pipeMaze = new PipeMaze(input);

        int expectedArea= 4;

        int actualArea = pipeMaze.calculateAreaOfTheMainLoop();

        Assertions.assertEquals(expectedArea, actualArea);
    }

    @Test
    public void calculateAreaOfTheMainLoop_givenValidInputFour_returnsCorrectArea() {
        String input = getFourthInput();
        PipeMaze pipeMaze = new PipeMaze(input);

        int expectedArea= 8;

        int actualArea = pipeMaze.calculateAreaOfTheMainLoop();

        Assertions.assertEquals(expectedArea, actualArea);
    }
}
