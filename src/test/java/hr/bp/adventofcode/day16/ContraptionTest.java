package hr.bp.adventofcode.day16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.Utils.readInputForDay;
import static hr.bp.adventofcode.day16.TestUtils.getFirstInput;

/**
 * @author Ivan Tomičić
 */
public class ContraptionTest {

    @Test
    public void countEnergizedTiles_givenInputOne_returnsCorrectCount() {
        String input = getFirstInput();
        Contraption contraption = new Contraption(input);

        int expectedCountOfEnergizedTiles = 46;

        int actualCountOfEnergizedTiles = contraption.countEnergizedTiles();

        Assertions.assertEquals(expectedCountOfEnergizedTiles, actualCountOfEnergizedTiles);
    }

    @Test
    public void countEnergizedTiles_givenTaskInput_returnsCorrectCount() {
        String input = readInputForDay("day16");
        Contraption contraption = new Contraption(input);

        int expectedCountOfEnergizedTiles = 7472;

        int actualCountOfEnergizedTiles = contraption.countEnergizedTiles();

        Assertions.assertEquals(expectedCountOfEnergizedTiles, actualCountOfEnergizedTiles);
    }
}
