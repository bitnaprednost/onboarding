package aoc_2024.day7;

import java.util.Objects;

public class CalibrationWithThreeOperators extends CalibrationWithTwoOperators{

    @Override
    protected boolean evaluateCombinations(int index, Long currentValue) {
        // Base case: If we reach the end of the numbers array, check if we matched the target.
        if (index == numbers.length)
        {
            return Objects.equals(currentValue, result);
        }

        // Recursive case: Try both addition and multiplication at the current step.
        return evaluateCombinations(index + 1, currentValue + numbers[index]) ||
                evaluateCombinations(index + 1, currentValue * numbers[index]) ||
                evaluateCombinations(index + 1, Long.parseLong(currentValue.toString().concat(Long.toString(numbers[index]))));
    }
}
