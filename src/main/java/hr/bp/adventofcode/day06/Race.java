package hr.bp.adventofcode.day06;

import hr.bp.adventofcode.Pair;

import java.util.Objects;

/**
 * @author Ivan Tomičić
 */
public class Race {

    RaceRecord raceRecord;

    public Race(RaceRecord raceRecord) {
        this.raceRecord = raceRecord;
    }

    public long calculateWaysToWinARace() {
        long maximumTime = raceRecord.maximumTime();
        long recordDistance = raceRecord.recordDistance();

        Pair<Double, Double> quadraticEquationResult = solveQuadraticEquation(maximumTime, recordDistance);

        Pair<Long, Long> extractedWholeNumbers = extractWholeNumbers(quadraticEquationResult);

        return extractedWholeNumbers.right() - extractedWholeNumbers.left() + 1;
    }


    private Pair<Double, Double> solveQuadraticEquation(long maximumTime, long recordDistance) {
        Double rightValue = (((maximumTime*maximumTime) + Math.sqrt(maximumTime * maximumTime - 4 * recordDistance)) / 2);
        Double leftValue = (((maximumTime*maximumTime) - Math.sqrt(maximumTime*maximumTime - 4*recordDistance)) / 2);
        
        return new Pair<>(leftValue, rightValue);
    }

    private Pair<Long, Long> extractWholeNumbers(Pair<Double, Double> quadraticEquationResult) {
        Double leftValue = quadraticEquationResult.left();
        Double rightValue = quadraticEquationResult.right();

        Long leftValueCeiled = (leftValue % 1 == 0)
                ? (long) Math.ceil(leftValue) + 1
                : (long) Math.ceil(leftValue);

        Long rightValueFloored = (rightValue % 1 == 0)
                ? (long) Math.floor(rightValue) - 1
                : (long) Math.floor(rightValue);

        return new Pair<>(leftValueCeiled, rightValueFloored);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Race race)) return false;
        return Objects.equals(raceRecord, race.raceRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(raceRecord);
    }
}
