package hr.bp.adventofcode.day09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class PolynomialEquation {

    private List<Integer> sequenceOfNumbers;
    private Integer degreeOfPolynomial;


    public PolynomialEquation(List<Integer> sequenceOfNumbers) {
        this.sequenceOfNumbers = sequenceOfNumbers;
        calculateDegreeOfPolynomial();
    }

    public int getDegreeOfPolynomial() {
        return degreeOfPolynomial;
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
}
