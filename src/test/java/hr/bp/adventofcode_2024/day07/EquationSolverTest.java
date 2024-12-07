package hr.bp.adventofcode_2024.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class EquationSolverTest {

    @Test
    public void findIfHasSolution_givenInputOne_returnsCorrectResult() {
        long value = 190;
        List<Long> numbers = List.of(19L, 10L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = equationSolver.hasSolution();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfHasSolution_givenInputTwo_returnsCorrectResult() {
        long value = 3267;
        List<Long> numbers = List.of(81L, 40L, 27L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = equationSolver.hasSolution();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfHasSolution_givenInputThree_returnsCorrectResult() {
        long value = 292;
        List<Long> numbers = List.of(11L, 6L, 16L, 20L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = equationSolver.hasSolution();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfHasSolution_givenInputFour_returnsCorrectResult() {
        long value = 161011;
        List<Long> numbers = List.of(16L, 10L, 13L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = false;

        boolean actualEquationHasSolution = equationSolver.hasSolution();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfHasSolution_givenInputFive_returnsCorrectResult() {
        long value = 192;
        List<Long> numbers = List.of(17L, 8L,14L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = false;

        boolean actualEquationHasSolution = equationSolver.hasSolution();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfHasSolution_givenInputSix_returnsCorrectResult() {
        long value = 83;
        List<Long> numbers = List.of(17L, 5L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = false;

        boolean actualEquationHasSolution = equationSolver.hasSolution();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfHasSolution_givenInputSeven_returnsCorrectResult() {
        long value = 156;
        List<Long> numbers = List.of(15L, 6L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = false;

        boolean actualEquationHasSolution = equationSolver.hasSolution();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfHasSolutionWithAdditionalOperator_givenInputSeven_returnsCorrectResult() {
        long value = 156;
        List<Long> numbers = List.of(15L, 6L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = equationSolver.hasSolutionWithTheAdditionalOperator();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfHasSolutionWithAdditionalOperator_givenInputEight_returnsCorrectResult() {
        long value = 7290;
        List<Long> numbers = List.of(6L, 8L, 6L, 15L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = equationSolver.hasSolutionWithTheAdditionalOperator();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfHasSolutionWithAdditionalOperator_givenInputFive_returnsCorrectResult() {
        long value = 192;
        List<Long> numbers = List.of(17L, 8L, 14L);

        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = equationSolver.hasSolutionWithTheAdditionalOperator();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }
}
