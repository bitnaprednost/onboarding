package hr.bp.adventofcode.day16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static hr.bp.adventofcode.Utils.readInputForDay;
import static hr.bp.adventofcode.day16.TestUtils.getFirstInput;

/**
 * @author Ivan Tomičić
 */
public class ContraptionTest {

    @Test
    public void countEnergizedTiles_givenInputOne_returnsCorrectEnergizedTiles() {
        String input = getFirstInput();
        Contraption contraption = new Contraption(input);

        int expectedCountOfEnergizedTiles = 46;

        int actualCountOfEnergizedTiles = contraption.getEnergizedTilesForUpperLeftBeam();

        Assertions.assertEquals(expectedCountOfEnergizedTiles, actualCountOfEnergizedTiles);
    }

    @Test
    public void countEnergizedTiles_givenTaskInput_rreturnsCorrectEnergizedTiles() {
        String input = readInputForDay("day16");
        Contraption contraption = new Contraption(input);

        int expectedCountOfEnergizedTiles = 7472;

        int actualCountOfEnergizedTiles = contraption.getEnergizedTilesForUpperLeftBeam();

        Assertions.assertEquals(expectedCountOfEnergizedTiles, actualCountOfEnergizedTiles);
    }

    @Test
    public void countEnergizedTilesWhenShineBeamFromAllDirections_givenInputOne_returnsCorrectEnergizedTiles() throws ExecutionException, InterruptedException {
        String input = getFirstInput();
        Contraption contraption = new Contraption(input);

        int expectedCountOfEnergizedTiles = 51;

        int actualCountOfEnergizedTiles = contraption.countEnergizedTilesWhenBeamEntersAllDirections();

        Assertions.assertEquals(expectedCountOfEnergizedTiles, actualCountOfEnergizedTiles);
    }
}
