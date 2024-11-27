package hr.bp.adventofcode.day09;

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
}
