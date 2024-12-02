package hr.bp.adventofcode_2024.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static hr.bp.adventofcode_2024.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TestLocationList {

    @Test
    public void testCalculatingDistances_givenValidInputOne_returnsCorrectSumOfDistances() {
        LocationList locationList = new LocationList(TestUtils.inputOne());

        long expectedSumOfDistances = 11;

        long actualSumOfDistances = locationList.getSumOfDistances();

        Assertions.assertEquals(expectedSumOfDistances, actualSumOfDistances);
    }

    @Test
    public void testCalculatingDistances_givenTaskInput_returnsCorrectSumOfDistances() {
        LocationList locationList = new LocationList(readInputForDay("day01"));

        long expectedSumOfDistances = 936063;

        long actualSumOfDistances = locationList.getSumOfDistances();

        Assertions.assertEquals(expectedSumOfDistances, actualSumOfDistances);
    }

    @Test
    public void testCalculatingSimilarityScore_givenValidInputOne_returnsCorrectSimilarityScore() {
        LocationList locationList = new LocationList(TestUtils.inputOne());

        long expectedSumOfDistances = 31;

        long actualSumOfDistances = locationList.getSimilarityScore();

        Assertions.assertEquals(expectedSumOfDistances, actualSumOfDistances);
    }

    @Test
    public void testCalculatingSimilarityScore_givenTaskInput_returnsCorrectSimilarityScore() {
        LocationList locationList = new LocationList(readInputForDay("day01"));

        long expectedSumOfDistances = 23150395;

        long actualSumOfDistances = locationList.getSimilarityScore();

        Assertions.assertEquals(expectedSumOfDistances, actualSumOfDistances);
    }
}
