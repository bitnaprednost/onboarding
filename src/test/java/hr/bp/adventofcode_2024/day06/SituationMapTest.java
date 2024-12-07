package hr.bp.adventofcode_2024.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode_2024.Utils.readInputForDay;
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

    @Test
    public void calculateDistinctPositions_givenTaskInput_returnsCorrectValue() {
        String input = readInputForDay("day06");
        SituationMap situationMap = new SituationMap(input);

        int expectedDistinctPositions = 5145;

        int actualDistinctPositions = situationMap.countDistinctPositions();

        Assertions.assertEquals(expectedDistinctPositions, actualDistinctPositions);
    }

    @Test
    public void calculateWaysToMakeALoop_givenInputOne_returnsCorrectValue() {
        String input = getFirstInput();
        SituationMap situationMap = new SituationMap(input);

        int expectedWaysToMakeALoop = 6;

        int actualWaysToMakeALoop = situationMap.countWaysToMakeALoop();

        Assertions.assertEquals(expectedWaysToMakeALoop, actualWaysToMakeALoop);
    }
}
