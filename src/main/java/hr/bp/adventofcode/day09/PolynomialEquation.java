package hr.bp.adventofcode.day09;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @author Ivan Tomičić
 */
public class PolynomialEquation {

    private List<Integer> sequenceOfNumbers;

    private Integer degreeOfPolynomial;

    private BigDecimal[] coefficients;

    public PolynomialEquation(List<Integer> sequenceOfNumbers) {
        this.sequenceOfNumbers = sequenceOfNumbers;
        calculateDegreeOfPolynomial();
        calculateCoefficients();
    }

    public BigDecimal calculateNextValue() {
        BigDecimal result = BigDecimal.ZERO;

        BigDecimal x = BigDecimal.valueOf(sequenceOfNumbers.size() + 1);

        for (int i = 0; i < coefficients.length; i++) {
            BigDecimal xRaisedToTheExponent = x.pow(i);
            result = result.add(coefficients[i].multiply(xRaisedToTheExponent));
        }

        return result;
    }

    public BigDecimal calculatePreviousValue() {
        BigDecimal result = BigDecimal.ZERO;

        BigDecimal x = BigDecimal.ZERO;

        for (int i = 0; i < coefficients.length; i++) {
            BigDecimal xRaisedToTheExponent = x.pow(i);
            result = result.add(coefficients[i].multiply(xRaisedToTheExponent));
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
        RealVector solution = solver.solve(yVector);

        this.coefficients = new BigDecimal[solution.getDimension()];

        MathContext mathContext = new MathContext(20);
        for (int i = 0; i < solution.getDimension(); i++) {
            this.coefficients[i] = BigDecimal.valueOf(solution.getEntry(i)).round(mathContext);
        }
    }

    public BigDecimal[] getCoefficients() {
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
                Objects.deepEquals(getCoefficients(), that.getCoefficients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequenceOfNumbers, getDegreeOfPolynomial(), Arrays.hashCode(getCoefficients()));
    }
}
