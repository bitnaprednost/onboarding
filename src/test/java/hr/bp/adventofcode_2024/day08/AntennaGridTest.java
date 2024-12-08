package hr.bp.adventofcode_2024.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode_2024.Utils.readInputForDay;
import static hr.bp.adventofcode_2024.day08.TestUtils.getFirstInput;

/**
 * @author Ivan Tomičić
 */
public class AntennaGridTest {

    @Test
    public void findAntinodes_givenInputOne_returnsCorrectResult() {
        String input = getFirstInput();
        AntennaGrid antennaGrid = new AntennaGrid(input);

        int expectedUniqueAntinodes = 14;

        int actualUniqueAntinodes = antennaGrid.findUniqueAntinodes(false);

        Assertions.assertEquals(expectedUniqueAntinodes, actualUniqueAntinodes);
    }

    @Test
    public void findAntinodes_givenTaskInput_returnsCorrectResult() {
        String input = readInputForDay("day08");
        AntennaGrid antennaGrid = new AntennaGrid(input);

        int expectedUniqueAntinodes = 371;

        int actualUniqueAntinodes = antennaGrid.findUniqueAntinodes(false);

        Assertions.assertEquals(expectedUniqueAntinodes, actualUniqueAntinodes);
    }

    @Test
    public void findAntinodesUsingResonantHarmonics_givenInputOne_returnsCorrectResult() {
        String input = getFirstInput();
        AntennaGrid antennaGrid = new AntennaGrid(input);

        int expectedUniqueAntinodes = 34;

        int actualUniqueAntinodes = antennaGrid.findUniqueAntinodes(true);

        Assertions.assertEquals(expectedUniqueAntinodes, actualUniqueAntinodes);
    }

    @Test
    public void findAntinodesUsingResonantHarmonics_givenTaskInput_returnsCorrectResult() {
        String input = readInputForDay("day08");
        AntennaGrid antennaGrid = new AntennaGrid(input);

        int expectedUniqueAntinodes = 1229;

        int actualUniqueAntinodes = antennaGrid.findUniqueAntinodes(true);

        Assertions.assertEquals(expectedUniqueAntinodes, actualUniqueAntinodes);
    }
}
