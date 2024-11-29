package hr.bp.adventofcode.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.day11.TestUtils.getFirstImageExpanded;
import static hr.bp.adventofcode.day11.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day11.TestUtils.getFirstImage;
import static hr.bp.adventofcode.day11.TestUtils.getSecondImageExpanded;
import static hr.bp.adventofcode.day11.TestUtils.getSecondInput;

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

    @Test
    public void expandUniverse_givenValidInputOne_correctlyExpandsUniverse() {
        String input = getFirstInput();
        Universe universe = new Universe(input);
        universe.expand();

        char[][] expectedImageAfterExpansion = getFirstImageExpanded();

        char[][] actualImageAfterExpansion = universe.getImage();

        Assertions.assertArrayEquals(expectedImageAfterExpansion, actualImageAfterExpansion);
    }

    @Test
    public void expandUniverse_givenValidInputTwo_correctlyExpandsUniverse() {
        String input = getSecondInput();
        Universe universe = new Universe(input);
        universe.expand();

        char[][] expectedImageAfterExpansion = getSecondImageExpanded();

        char[][] actualImageAfterExpansion = universe.getImage();

        Assertions.assertArrayEquals(expectedImageAfterExpansion, actualImageAfterExpansion);
    }
}
