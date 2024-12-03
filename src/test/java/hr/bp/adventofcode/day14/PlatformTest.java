package hr.bp.adventofcode.day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
