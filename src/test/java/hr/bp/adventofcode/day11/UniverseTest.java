package hr.bp.adventofcode.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.Utils.readInputForDay;
import static hr.bp.adventofcode.day11.TestUtils.getFirstImage;
import static hr.bp.adventofcode.day11.TestUtils.getFirstInput;

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
    public void calculateSumOfShortestPaths_givenValidInputOne_correctlyCalculatesTheSum() {
        String input = getFirstInput();
        Universe universe = new Universe(input);
        int expansionFactor = 2;

        long expectedSumOfShortestPaths = 374;

        long actualSumOfShortestPaths = universe.getSumOfShortestPathsForExpansionFactor(expansionFactor);

        Assertions.assertEquals(expectedSumOfShortestPaths, actualSumOfShortestPaths);
    }

    @Test
    public void calculateSumOfShortestPaths_givenTaskInput_correctlyCalculatesTheSum() {
        String input = readInputForDay("day11");
        Universe universe = new Universe(input);
        int expansionFactor = 2;

        long expectedSumOfShortestPaths = 9608724;

        long actualSumOfShortestPaths = universe.getSumOfShortestPathsForExpansionFactor(expansionFactor);

        Assertions.assertEquals(expectedSumOfShortestPaths, actualSumOfShortestPaths);
    }

    @Test
    public void calculateSumOfShortestPathsAfterExpansionBy10_givenValidInputOne_correctlyCalculatesTheSum() {
        String input = getFirstInput();
        Universe universe = new Universe(input);
        int expansionFactor = 10;

        long expectedSumOfShortestPaths = 1030;

        long actualSumOfShortestPaths = universe.getSumOfShortestPathsForExpansionFactor(expansionFactor);

        Assertions.assertEquals(expectedSumOfShortestPaths, actualSumOfShortestPaths);
    }

    @Test
    public void calculateSumOfShortestPathsAfterExpansionBy100_givenValidInputOne_correctlyCalculatesTheSum() {
        String input = getFirstInput();
        Universe universe = new Universe(input);
        int expansionFactor = 100;

        long expectedSumOfShortestPaths = 8410;

        long actualSumOfShortestPaths = universe.getSumOfShortestPathsForExpansionFactor(expansionFactor);

        Assertions.assertEquals(expectedSumOfShortestPaths, actualSumOfShortestPaths);
    }

    @Test
    public void calculateSumOfShortestPathsAfterExpansionBy1000000_givenTaskInput_correctlyCalculatesTheSum() {
        String input = readInputForDay("day11");
        Universe universe = new Universe(input);
        int expansionFactor = 1_000_000;

        long expectedSumOfShortestPaths = 904633799472L;

        long actualSumOfShortestPaths = universe.getSumOfShortestPathsForExpansionFactor(expansionFactor);

        Assertions.assertEquals(expectedSumOfShortestPaths, actualSumOfShortestPaths);
    }
}
