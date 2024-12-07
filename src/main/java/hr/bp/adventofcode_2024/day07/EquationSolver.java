package hr.bp.adventofcode_2024.day07;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class EquationSolver {

    private final Long value;

    private final List<Long> numbers;

    public EquationSolver(long value, List<Long> numbers) {
        this.value = value;
        this.numbers = numbers;
    }

    public boolean hasSolution() {
        return calculateIfConfigurationIsPossibleWithSumAndMultiply(numbers.size() - 1, value);
    }

    public boolean hasSolutionWithTheAdditionalOperator() {
        return calculateIfConfigurationIsPossibleWithSumAndMultiplyAndConcatenation(numbers.size() - 1, value);
    }

    // 442796525811358 wrong for task 2
    private boolean calculateIfConfigurationIsPossibleWithSumAndMultiplyAndConcatenation(int index, long value) {
        if (index == 0) return value == numbers.getFirst();

        long currentNumber = numbers.get(index);

        long digits = (int) (Math.log10(Math.abs(currentNumber)) + 1);

        long tenRaisedToDigits = 1;

        while (digits-- > 0) tenRaisedToDigits *= 10;

        return calculateIfConfigurationIsPossibleWithSumAndMultiplyAndConcatenation(index - 1, value - currentNumber) ||
                (value % currentNumber == 0 && calculateIfConfigurationIsPossibleWithSumAndMultiplyAndConcatenation(index - 1, value / currentNumber)) ||
                ((value - currentNumber) % tenRaisedToDigits == 0 && calculateIfConfigurationIsPossibleWithSumAndMultiplyAndConcatenation(index - 1, (value - currentNumber) / tenRaisedToDigits));

    }

    private boolean calculateIfConfigurationIsPossibleWithSumAndMultiply(int index, long value) {
        if (index == 0) return value == numbers.getFirst();

        long currentNumber = numbers.get(index);

        return calculateIfConfigurationIsPossibleWithSumAndMultiply(index - 1, value - currentNumber) ||
                (value % currentNumber == 0 && calculateIfConfigurationIsPossibleWithSumAndMultiply(index - 1, value / currentNumber));
    }

    public Long getValue() {
        return value;
    }
}
