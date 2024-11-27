package hr.bp.adventofcode.day09;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class PolynomialEquationTest {

    @Test
    public void findDegreeOfPolynomial_givenSimpleSequence_returnsCorrectExponent() {
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
    public void calculateCoefficients_givenSimpleSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(1,2,3,4,5,6,7,8,9);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        RealVector expectedCoefficients = new ArrayRealVector(new double[]{0,1});

        RealVector actualCoefficients = polynomialEquation.getCoefficients();

        double tolerance = 1e-6;
        Assertions.assertTrue(VectorUtils.areVectorsEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateCoefficients_givenQuadraticSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(1,4,9,16,25,36,49,64,81,100);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        RealVector expectedCoefficients = new ArrayRealVector(new double[]{0,0,1});

        RealVector actualCoefficients = polynomialEquation.getCoefficients();

        double tolerance = 1e-6;
        Assertions.assertTrue(VectorUtils.areVectorsEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateCoefficients_givenQuadraticSequenceShifted_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(2,5,10,17,26,37,50,65,82,101);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        RealVector expectedCoefficients = new ArrayRealVector(new double[]{1,0,1});

        RealVector actualCoefficients = polynomialEquation.getCoefficients();

        double tolerance = 1e-6;
        Assertions.assertTrue(VectorUtils.areVectorsEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateCoefficients_givenQuinticSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(1,32,243,1024,3125,7776,16807,32768);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        RealVector expectedCoefficients = new ArrayRealVector(new double[]{0,0,0,0,0,1});

        RealVector actualCoefficients = polynomialEquation.getCoefficients();

        double tolerance = 1e-6;
        Assertions.assertTrue(VectorUtils.areVectorsEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }

    @Test
    public void calculateCoefficients_givenConstantSequence_returnsCorrectCoefficients() {
        List<Integer> listOfNumbers = List.of(4,4,4,4,4,4,4,4,4,4);
        PolynomialEquation polynomialEquation = new PolynomialEquation(listOfNumbers);

        RealVector expectedCoefficients = new ArrayRealVector(new double[]{4});

        RealVector actualCoefficients = polynomialEquation.getCoefficients();

        double tolerance = 1e-6;
        Assertions.assertTrue(VectorUtils.areVectorsEqual(expectedCoefficients, actualCoefficients, tolerance),
                "The coefficients do not match within the tolerance.");
    }
}
