package hr.bp.adventofcode.day09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static hr.bp.adventofcode.day09.TestUtils.areBigDecimalArraysEqual;
import static hr.bp.adventofcode.day09.TestUtils.areBigDecimalsEqual;

/**
 * @author Ivan Tomičić
 */
public class PolynomialEquationTest {

    @Test
    public void findDegreeOfPolynomial_givenLinearSequence_returnsCorrectExponent() {
        List<Integer> listOfNumbers = List.of(1,2,3,4,5,6);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        int expectedDegree = 1;

        int actualDegree = polynomialEquation.getDegreeOfPolynomial();

        Assertions.assertEquals(expectedDegree, actualDegree);
    }

    @Test
    public void findDegreeOfPolynomial_givenQuadraticSequence_returnsCorrectExponent() {
        List<Integer> listOfNumbers = List.of(1,4,9,16,25,36,49,64,81,100);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        int expectedDegree = 2;

        int actualDegree = polynomialEquation.getDegreeOfPolynomial();

        Assertions.assertEquals(expectedDegree, actualDegree);
    }

    @Test
    public void findDegreeOfPolynomial_givenQuinticSequence_returnsCorrectExponent() {
        List<Integer> listOfNumbers = List.of(1,32,243,1024,3125,7776,16807,32768);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        int expectedDegree = 5;

        int actualDegree = polynomialEquation.getDegreeOfPolynomial();

        Assertions.assertEquals(expectedDegree, actualDegree);
    }

    @Test
    public void findDegreeOfPolynomial_givenSepticSequence_returnsCorrectExponent() {
        List<Integer> listOfNumbers = List.of(1,1024,59049,1048576,9765625,60466176,282475249,1073741824);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        int expectedDegree = 7;

        int actualDegree = polynomialEquation.getDegreeOfPolynomial();

        Assertions.assertEquals(expectedDegree, actualDegree);
    }

    @Test
    public void calculateCoefficients_givenLinearSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(1,2,3,4,5,6,7,8,9);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal[] expectedCoefficients = new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ONE};

        BigDecimal[]  actualCoefficients = polynomialEquation.getCoefficients();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalArraysEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateCoefficients_givenQuadraticSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(1,4,9,16,25,36,49,64,81,100);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal[]  expectedCoefficients = new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ONE};

        BigDecimal[]  actualCoefficients = polynomialEquation.getCoefficients();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalArraysEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateCoefficients_givenQuadraticSequenceShifted_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(2,5,10,17,26,37,50,65,82,101);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal[]  expectedCoefficients = new BigDecimal[]{BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE};

        BigDecimal[]  actualCoefficients = polynomialEquation.getCoefficients();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalArraysEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateCoefficients_givenQuinticSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(1,32,243,1024,3125,7776,16807,32768);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal[]  expectedCoefficients = new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ONE};

        BigDecimal[]  actualCoefficients = polynomialEquation.getCoefficients();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalArraysEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateCoefficients_givenConstantSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(4,4,4,4,4,4,4,4,4,4);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal[]  expectedCoefficients = new BigDecimal[]{BigDecimal.valueOf(4)};

        BigDecimal[]  actualCoefficients = polynomialEquation.getCoefficients();

        BigDecimal a = new BigDecimal(1);

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalArraysEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }



    @Test
    public void calculateNextNumber_givenConstantSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(4,4,4,4,4,4,4,4,4,4);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal expectedNextNumber = BigDecimal.valueOf(4);

        BigDecimal actualNextNumber = polynomialEquation.calculateNextValue();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalsEqual(expectedNextNumber, actualNextNumber, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateNextNumber_givenLinearSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(5,6,7,8,9,10,11,12,13,14);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal expectedNextNumber = BigDecimal.valueOf(15);

        BigDecimal actualNextNumber = polynomialEquation.calculateNextValue();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalsEqual(expectedNextNumber, actualNextNumber, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateNextNumber_givenQuadraticSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(36,25,16,9,4,1,0,1,4,9,16,25,36,49,64,81,100);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal expectedNextNumber = BigDecimal.valueOf(121);

        BigDecimal actualNextNumber = polynomialEquation.calculateNextValue();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalsEqual(expectedNextNumber, actualNextNumber, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateNextNumber_givenDescendingLinearSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(-1,-2,-3,-4,-5,-6,-7,-8);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal expectedNextNumber = BigDecimal.valueOf(-9);

        BigDecimal actualNextNumber = polynomialEquation.calculateNextValue();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalsEqual(expectedNextNumber, actualNextNumber, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateNextNumber_givenDescendingCubicSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(-8, -27, -64, -125, -216, -343);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        BigDecimal expectedNextNumber = BigDecimal.valueOf(-512);

        BigDecimal actualNextNumber = polynomialEquation.calculateNextValue();

        double tolerance = 1e-6;
        Assertions.assertTrue(areBigDecimalsEqual(expectedNextNumber, actualNextNumber, tolerance),
                "The coefficients do not match within the tolerance.");
    }
}
