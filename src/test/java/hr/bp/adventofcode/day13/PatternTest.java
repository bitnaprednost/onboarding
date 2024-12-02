package hr.bp.adventofcode.day13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.day13.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day13.TestUtils.getSecondInput;

/**
 * @author Ivan Tomičić
 */
public class PatternTest {

    @Test
    public void getSymmetry_givenInputOne_returnsCorrectSymmetry() {
        String input = getFirstInput();
        Pattern pattern = new Pattern(input);

        SymmetryType expectedSymmetryType = new SymmetryType(4, SymmetryDirection.COLUMN);

        SymmetryType actualSymmetryType = pattern.getSymmetryType();

        Assertions.assertEquals(expectedSymmetryType, actualSymmetryType);
    }

    @Test
    public void getSymmetry_givenInputOne_returnsCorrectSymmetry() {
        String input = getSecondInput();
        Pattern pattern = new Pattern(input);

        SymmetryType expectedSymmetryType = new SymmetryType(3, SymmetryDirection.ROW);

        SymmetryType actualSymmetryType = pattern.getSymmetryType();

        Assertions.assertEquals(expectedSymmetryType, actualSymmetryType);
    }
}
