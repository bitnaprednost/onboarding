package hr.bp.adventofcode_2024.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode_2024.day07.TestUtils.getFirstInput;

/**
 * @author Ivan Tomičić
 */
public class EquationRunnerTest {

    @Test
    public void findIfEquationHasSolution_givenInputOne_returnsCorrectResult() {
        String input = getFirstInput();
        EquationRunner equationRunner = new EquationRunner(input);

        long expectedSum = 3749;

        long actualSum = equationRunner.sumSolvableEquations();

        Assertions.assertEquals(expectedSum, actualSum);
    }
}
