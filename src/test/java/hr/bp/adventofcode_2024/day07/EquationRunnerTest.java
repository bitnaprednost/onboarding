package hr.bp.adventofcode_2024.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode_2024.Utils.readInputForDay;
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

        long actualSum = equationRunner.sumSolvableEquations(false);

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void findIfEquationHasSolution_givenTaskInput_returnsCorrectResult() {
        String input = readInputForDay("day07");
        EquationRunner equationRunner = new EquationRunner(input);

        long expectedSum = 3598800864292L;

        long actualSum = equationRunner.sumSolvableEquations(false);

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void findIfEquationHasSolutionWithAdditionalOperator_givenInputOne_returnsCorrectResult() {
        String input = getFirstInput();
        EquationRunner equationRunner = new EquationRunner(input);

        long expectedSum = 11387;

        long actualSum = equationRunner.sumSolvableEquations(true);

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void findIfEquationHasSolutionWithAdditionalOperator_givenTaskInput_returnsCorrectResult() {
        String input = readInputForDay("day07");
        EquationRunner equationRunner = new EquationRunner(input);

        long expectedSum = 340362529351427L;

        long actualSum = equationRunner.sumSolvableEquations(true);

        Assertions.assertEquals(expectedSum, actualSum);
    }
}
