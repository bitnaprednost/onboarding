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
        return calculateIfConfigurationEqualsToValue(numbers.size() - 1, value);
    }

    private boolean calculateIfConfigurationEqualsToValue(int index, long value) {
        if (index == 0) return value == numbers.getFirst();

        long currentNumber = numbers.get(index);

        return calculateIfConfigurationEqualsToValue(index - 1, value - currentNumber) ||
                (value % currentNumber == 0 && calculateIfConfigurationEqualsToValue(index - 1, value / currentNumber));
    }

    public Long getValue() {
        return value;
    }
}
