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

        SymmetryLine expectedSymmetryLine = new SymmetryLine(4, SymmetryDirection.COLUMN);

        SymmetryLine actualSymmetryLine = pattern.getSymmetryType();

        Assertions.assertEquals(expectedSymmetryLine, actualSymmetryLine);
    }

    @Test
    public void getSymmetry_givenInputTwo_returnsCorrectSymmetry() {
        String input = getSecondInput();
        Pattern pattern = new Pattern(input);

        SymmetryLine expectedSymmetryLine = new SymmetryLine(3, SymmetryDirection.ROW);

        SymmetryLine actualSymmetryLine = pattern.getSymmetryType();

        Assertions.assertEquals(expectedSymmetryLine, actualSymmetryLine);
    }
}
