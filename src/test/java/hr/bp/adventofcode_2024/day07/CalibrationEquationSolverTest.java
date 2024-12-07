package hr.bp.adventofcode_2024.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class CalibrationEquationSolverTest {

    @Test
    public void findIfIsSolvable_givenInputOne_returnsCorrectResult() {
        long value = 190;
        List<Long> numbers = List.of(19L, 10L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(false);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfIsSolvable_givenInputTwo_returnsCorrectResult() {
        long value = 3267;
        List<Long> numbers = List.of(81L, 40L, 27L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(false);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfIsSolvable_givenInputThree_returnsCorrectResult() {
        long value = 292;
        List<Long> numbers = List.of(11L, 6L, 16L, 20L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(false);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfIsSolvable_givenInputFour_returnsCorrectResult() {
        long value = 161011;
        List<Long> numbers = List.of(16L, 10L, 13L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = false;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(false);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfIsSolvable_givenInputFive_returnsCorrectResult() {
        long value = 192;
        List<Long> numbers = List.of(17L, 8L,14L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = false;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(false);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfIsSolvable_givenInputSix_returnsCorrectResult() {
        long value = 83;
        List<Long> numbers = List.of(17L, 5L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = false;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(false);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfIsSolvable_givenInputSeven_returnsCorrectResult() {
        long value = 156;
        List<Long> numbers = List.of(15L, 6L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = false;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(false);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfIsSolvableWithAdditionalOperator_givenInputSeven_returnsCorrectResult() {
        long value = 156;
        List<Long> numbers = List.of(15L, 6L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(true);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfIsSolvableWithAdditionalOperator_givenInputEight_returnsCorrectResult() {
        long value = 7290;
        List<Long> numbers = List.of(6L, 8L, 6L, 15L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(true);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }

    @Test
    public void findIfIsSolvableWithAdditionalOperator_givenInputFive_returnsCorrectResult() {
        long value = 192;
        List<Long> numbers = List.of(17L, 8L, 14L);

        CalibrationEquationSolver calibrationEquationSolver = new CalibrationEquationSolver(value, numbers);

        boolean expectedEquationHasSolution = true;

        boolean actualEquationHasSolution = calibrationEquationSolver.isSolvable(true);

        Assertions.assertEquals(expectedEquationHasSolution, actualEquationHasSolution);
    }
}
