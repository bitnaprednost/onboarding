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

    public boolean hasSolution(boolean allowConcatenationOperator) {
        return calculateIfConfigurationIsPossible(numbers.size() - 1, value, allowConcatenationOperator);
    }

    private boolean calculateIfConfigurationIsPossible(int index, long value, boolean allowConcatenationOperator) {
        if (index == 0) return value == numbers.getFirst();

        long currentNumber = numbers.get(index);

        long digits = (int) (Math.log10(Math.abs(currentNumber)) + 1);
        long tenRaisedToDigits = (long) Math.pow(10, digits);

        return calculateIfConfigurationIsPossible(index - 1, value - currentNumber, allowConcatenationOperator) ||
                (value % currentNumber == 0 && calculateIfConfigurationIsPossible(index - 1, value / currentNumber, allowConcatenationOperator)) ||
                (allowConcatenationOperator && (value - currentNumber) % tenRaisedToDigits == 0 && calculateIfConfigurationIsPossible(index - 1, (value - currentNumber) / tenRaisedToDigits, allowConcatenationOperator));

    }

    public Long getValue() {
        return value;
    }
}
