package hr.bp.adventofcode.day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.Utils.readInputForDay;
import static hr.bp.adventofcode.day14.TestUtils.getFirstGridAfterOneCycle;
import static hr.bp.adventofcode.day14.TestUtils.getFirstGridAfterTiltNorth;
import static hr.bp.adventofcode.day14.TestUtils.getFirstInput;


/**
 * @author Ivan Tomičić
 */
public class PlatformTest {

    @Test
    public void tiltPlatformNorth_givenInputOne_correctlyTiltsPlatformNorth() {
        String input = getFirstInput();
        Platform platform = new Platform(input);
        platform.tilt(PlatformDirection.NORTH);

        char[][] expectedGridAfterTilt = getFirstGridAfterTiltNorth();

        char[][] actualGridAfterTilt = platform.getGrid();

        Assertions.assertArrayEquals(expectedGridAfterTilt, actualGridAfterTilt);
    }

    @Test
    public void calculateTotalLoad_givenInputOne_returnsCorrectLoad() {
        String input = getFirstInput();
        Platform platform = new Platform(input);
        platform.tilt(PlatformDirection.NORTH);

        int expectedLoad = 136;

        int actualLoad = platform.getLoad();

        Assertions.assertEquals(expectedLoad, actualLoad);
    }

    @Test
    public void calculateTotalLoad_givenTaskInput_returnsCorrectLoad() {
        String input = readInputForDay("day14");
        Platform platform = new Platform(input);
        platform.tilt(PlatformDirection.NORTH);

        int expectedLoad = 106990;

        int actualLoad = platform.getLoad();

        Assertions.assertEquals(expectedLoad, actualLoad);
    }

    @Test
    public void calculateTotalLoadAfter4Tilts_givenInputOne_returnsCorrectLoad() {
        String input = getFirstInput();
        Platform platform = new Platform(input);
        int numberOfCycles = 1_000_000_000;

        int expectedLoad = 64;

        int actualLoad = platform.getLoadForNCycles(numberOfCycles);

        Assertions.assertEquals(expectedLoad, actualLoad);
    }

    @Test
    public void makeOneCycle_givenInputOne_returnsCorrectGrid() {
        String input = getFirstInput();
        Platform platform = new Platform(input);
        int numberOfCycles = 1;

        platform.getLoadForNCycles(numberOfCycles);

        char[][] expectedGrid = getFirstGridAfterOneCycle();

        char[][] actualGrid = platform.getGrid();

        Assertions.assertArrayEquals(expectedGrid, actualGrid);
    }

    @Test
    public void getLoadAfterBillionCycles_givenTaskInput_returnsCorrectLoad() {
        String input = readInputForDay("day14");
        Platform platform = new Platform(input);
        int numberOfCycles = 1_000_000_000;

        int expectedLoad = 100531;

        int actualLoad = platform.getLoadForNCycles(numberOfCycles);

        Assertions.assertEquals(expectedLoad, actualLoad);
    }
}
