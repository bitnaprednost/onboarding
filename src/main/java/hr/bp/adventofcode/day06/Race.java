package hr.bp.adventofcode.day06;

import org.graalvm.collections.Pair;

/**
 * @author Ivan Tomičić
 */
public class Race {

    RaceRecord raceRecord;

    public Race(RaceRecord raceRecord) {
        this.raceRecord = raceRecord;
    }

    public int calculateWaysToWinARace() {
        int maximumTime = raceRecord.maximumTime();
        int recordDistance = raceRecord.recordDistance();

        Pair<Double, Double> quadraticEquationResult = solveQuadraticEquation(maximumTime, recordDistance);

        Pair<Integer, Integer> extractedWholeNumbers = extractWholeNumbers(quadraticEquationResult);

        return extractedWholeNumbers.getRight() - extractedWholeNumbers.getLeft() + 1;
    }


    private Pair<Double, Double> solveQuadraticEquation(int maximumTime, int recordDistance) {
        Double rightValue = (((maximumTime*maximumTime) + Math.sqrt(maximumTime * maximumTime - 4 * recordDistance)) / 2);
        Double leftValue = (((maximumTime*maximumTime) - Math.sqrt(maximumTime*maximumTime - 4*recordDistance)) / 2);
        
        return Pair.create(leftValue, rightValue);
    }

    private Pair<Integer, Integer> extractWholeNumbers(Pair<Double, Double> quadraticEquationResult) {
        Double leftValue = quadraticEquationResult.getLeft();
        Double rightValue = quadraticEquationResult.getRight();

        Integer leftValueCeiled = (leftValue % 1 == 0)
                ? (int) Math.ceil(leftValue) + 1
                : (int) Math.ceil(leftValue);

        Integer rightValueFloored = (rightValue % 1 == 0)
                ? (int) Math.floor(rightValue) - 1
                : (int) Math.floor(rightValue);

        return Pair.create(leftValueCeiled, rightValueFloored);
    }

}
