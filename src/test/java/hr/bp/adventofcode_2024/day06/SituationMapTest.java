package hr.bp.adventofcode_2024.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode_2024.day06.TestUtils.getFirstInput;

/**
 * @author Ivan Tomičić
 */
public class SituationMapTest {

    @Test
    public void calculateDistinctPositions_givenInputOne_returnsCorrectValue() {
        String input = getFirstInput();
        SituationMap situationMap = new SituationMap(input);

        int expectedDistinctPositions = 41;

        int actualDistinctPositions = situationMap.countDistinctPositions();

        Assertions.assertEquals(expectedDistinctPositions, actualDistinctPositions);
    }
}
