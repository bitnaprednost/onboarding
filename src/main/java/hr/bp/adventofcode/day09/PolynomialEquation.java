package hr.bp.adventofcode.day09;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @author Ivan Tomičić
 */
public class PolynomialEquation {

    private List<Integer> sequenceOfNumbers;

    private Integer degreeOfPolynomial;

    private RealVector coefficients;

    public PolynomialEquation(List<Integer> sequenceOfNumbers) {
        this.sequenceOfNumbers = sequenceOfNumbers;
        calculateDegreeOfPolynomial();
        calculateCoefficients();
    }

    public Long calculateNextValue() {
        long result = 0;

        long x = sequenceOfNumbers.size() + 1;

        for (int i = 0; i < coefficients.getDimension(); i++) {
            long xRaisedToTheExponent = getXRaisedToTheExponent(x, i);
            result += (long) (coefficients.getEntry(i) * xRaisedToTheExponent);
        }
        return result;
    }

    private long getXRaisedToTheExponent(long x, int i) {
        long result = 1;
        for (int k = 0; k < i; k++) {
            result *= x;
        }
        return result;
    }

    private void calculateDegreeOfPolynomial() {
        List<Integer> oldSequence = new ArrayList<>(sequenceOfNumbers);

        int degreeOfPolynomial = 0;

        while(!sequenceContainsAllZeroes(oldSequence)) {
            List<Integer> newSequence = new ArrayList<>();

            for (int i = 0; i < oldSequence.size() - 1; i++) {
                newSequence.add(oldSequence.get(i+1) - oldSequence.get(i));
            }

            oldSequence = newSequence;
            degreeOfPolynomial++;
        }

        this.degreeOfPolynomial = degreeOfPolynomial - 1;
    }

    private boolean sequenceContainsAllZeroes(List<Integer> oldSequence) {
        return oldSequence.stream().allMatch(n -> n == 0);
    }

    private void calculateCoefficients() {
        int degree = this.degreeOfPolynomial;

        double[] x = IntStream.rangeClosed(1, sequenceOfNumbers.size())
                .mapToDouble(i -> i)
                .toArray();

        double[] y = sequenceOfNumbers.stream()
                .mapToDouble(Integer::doubleValue)
                .toArray();

        double[][] vandermonde = new double[x.length][degree + 1];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j <= degree; j++) {
                vandermonde[i][j] = Math.pow(x[i], j);
            }
        }

        RealMatrix vandermondeMatrix = new Array2DRowRealMatrix(vandermonde);
        RealVector yVector = new ArrayRealVector(y);

        DecompositionSolver solver = new QRDecomposition(vandermondeMatrix).getSolver();

        this.coefficients = solver.solve(yVector);
    }

    public RealVector getCoefficients() {
        return this.coefficients;
    }

    public int getDegreeOfPolynomial() {
        return degreeOfPolynomial;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PolynomialEquation that)) return false;
        return Objects.equals(sequenceOfNumbers, that.sequenceOfNumbers) &&
                Objects.equals(getDegreeOfPolynomial(), that.getDegreeOfPolynomial()) &&
                Objects.equals(getCoefficients(), that.getCoefficients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequenceOfNumbers, getDegreeOfPolynomial(), getCoefficients());
    }
}
