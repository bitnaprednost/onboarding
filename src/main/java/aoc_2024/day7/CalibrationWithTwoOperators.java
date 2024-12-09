package aoc_2024.day7;

import java.util.*;

public class CalibrationWithTwoOperators {

    protected long result;
    protected long[] numbers;

    public long calculateCalibrationResult(String calibrationEquation){

        // Split file content into lines
        String[] lines = calibrationEquation.split(System.lineSeparator());
        return parseInput(lines);
    }

    private long parseInput(String[] lines){

        long CalibrationResult = 0L;
        for (String line : lines)
        {
            String[] parts = line.split(":");
            result = Long.parseLong(parts[0].trim());
            String[] numStrings = parts[1].trim().split(" ");
            numbers = Arrays.stream(numStrings).mapToLong(Long::parseLong).toArray();

            if (canProduceTestValue())
            {
                CalibrationResult += result;
            }
        }
        return CalibrationResult;
    }

    protected boolean canProduceTestValue() {
        return evaluateCombinations(1, numbers[0]);
    }

    protected boolean evaluateCombinations(int index, Long currentValue) {
        // Base case: If we reach the end of the numbers array, check if we matched the target.
        if (index == numbers.length)
        {
            return Objects.equals(currentValue, result);
        }

        // Recursive case: Try both addition and multiplication at the current step.
        return evaluateCombinations(index + 1, currentValue + numbers[index]) ||
                evaluateCombinations(index + 1, currentValue * numbers[index]);
    }
}
