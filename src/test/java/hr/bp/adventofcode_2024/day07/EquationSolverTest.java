package hr.bp.adventofcode_2024.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class EquationSolverTest {

    @Test
    public void findIfEquationHasSolution_givenInputOne_returnsCorrectResult() {
        long value = 190;
        List<Long> numbers = List.of(19L, 10L);
        EquationSolver equationSolver = new EquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = equationSolver.findSolution();

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }
}
