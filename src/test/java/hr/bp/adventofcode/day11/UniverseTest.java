package hr.bp.adventofcode.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.Utils.readInputForDay;
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

    @Test
    public void calculateSumOfShortestPaths_givenValidInputOne_correctlyCalculatesTheSum() {
        String input = getFirstInput();
        Universe universe = new Universe(input);
        universe.expand();

        int expectedSumOfShortestPaths = 374;

        int actualSumOfShortestPaths = universe.getSumOfShortestPaths();

        Assertions.assertEquals(expectedSumOfShortestPaths, actualSumOfShortestPaths);
    }

    @Test
    public void calculateSumOfShortestPaths_givenTaskInput_correctlyCalculatesTheSum() {
        String input = readInputForDay("day11");
        Universe universe = new Universe(input);
        universe.expand();

        int expectedSumOfShortestPaths = 9608724;

        int actualSumOfShortestPaths = universe.getSumOfShortestPaths();

        Assertions.assertEquals(expectedSumOfShortestPaths, actualSumOfShortestPaths);
    }

    @Test
    public void calculateSumOfShortestPathsAfterExpansionBy10_givenTaskInput_correctlyCalculatesTheSum() {
        String input = getFirstInput();
        Universe universe = new Universe(input);
        int expansionFactor = 10;

        long expectedSumOfShortestPaths = 1030;

        long actualSumOfShortestPaths = universe.getSumOfShortestPathsForExpansionFactor(expansionFactor);

        Assertions.assertEquals(expectedSumOfShortestPaths, actualSumOfShortestPaths);
    }

    @Test
    public void calculateSumOfShortestPathsAfterExpansionBy100_givenTaskInput_correctlyCalculatesTheSum() {
        String input = getFirstInput();
        Universe universe = new Universe(input);
        int expansionFactor = 100;

        long expectedSumOfShortestPaths = 8410;

        long actualSumOfShortestPaths = universe.getSumOfShortestPathsForExpansionFactor(expansionFactor);

        Assertions.assertEquals(expectedSumOfShortestPaths, actualSumOfShortestPaths);
    }
}
