package hr.bp.adventofcode.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.day11.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day11.TestUtils.getFirstImage;

/**
 * @author Ivan Tomičić
 */
public class UniverseTest {

    @Test
    public void parseInput_givenValidInputOne_correctlyParsesData() {
        String input = getFirstInput();
        Universe universe = new Universe(input);

        char[][] expectedImage = getFirstImage();

        char[][] actualImage = universe.getImage();

        Assertions.assertArrayEquals(expectedImage, actualImage);
    }
}
