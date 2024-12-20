package hr.bp.aoc2024.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.aoc2024.day7.TestUtil.*;

class CalibrationEquationTest {

    @Test
    void testOneCorrectOperator_190() {
        CalibrationEquationParser parser = new CalibrationEquationParser(getInput_190());
        CalibrationEquation calibrations = new CalibrationEquation(parser.parseInput());

        Assertions.assertEquals(190, calibrations.sumTrueEquations());
    }

    @Test
    void testTwoCorrectOperators_3267() {
        CalibrationEquationParser parser = new CalibrationEquationParser(getInput_3267());
        CalibrationEquation calibrations = new CalibrationEquation(parser.parseInput());

        Assertions.assertEquals(3267, calibrations.sumTrueEquations());
    }

    @Test
    void testIncorrectOperators_83() {
        CalibrationEquationParser parser = new CalibrationEquationParser(getInput_83());
        CalibrationEquation calibrations = new CalibrationEquation(parser.parseInput());

        Assertions.assertEquals(0, calibrations.sumTrueEquations());
    }

    @Test
    void testInputCalibrations() {
        CalibrationEquationParser parser = new CalibrationEquationParser(getTestInput());
        CalibrationEquation calibrations = new CalibrationEquation(parser.parseInput());

        Assertions.assertEquals(3749, calibrations.sumTrueEquations());
    }

    @Test
    void testFinalInputCalibration() {
        CalibrationEquationParser parser = new CalibrationEquationParser(getFinalInput());
        CalibrationEquation calibrations = new CalibrationEquation(parser.parseInput());

        Assertions.assertEquals(14711933466277L, calibrations.sumTrueEquations());
    }

    @Test
    void testInputCalibrations_concatenation() {
        CalibrationEquationParser parser = new CalibrationEquationParser(getTestInput());
        CalibrationEquation calibrations = new CalibrationEquation(parser.parseInput(), true);

        Assertions.assertEquals(11387, calibrations.sumTrueEquations());
    }

    @Test
    void testFinalInputCalibration_concatenation() {
        CalibrationEquationParser parser = new CalibrationEquationParser(getFinalInput());
        CalibrationEquation calibrations = new CalibrationEquation(parser.parseInput(), true);

        Assertions.assertEquals(286580387663654L, calibrations.sumTrueEquations());
    }
}
