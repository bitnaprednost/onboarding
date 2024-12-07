package hr.bp.adventofcode_2024.day07;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @author Ivan Tomičić
 */
public class EquationSolver {

    BiFunction<Long, Long, Long> ADD = Long::sum;

    BiFunction<Long, Long, Long> MULTIPLY = (a, b) -> a * b;

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
        if (index == 0) return value == numbers.get(index);

        long subtractedByNumber = value - numbers.get(index);

        boolean divisionMakesSense = value % numbers.get(index) == 0;
        long dividedByNumber = value / numbers.get(index);

        if (divisionMakesSense) {
            return calculateIfConfigurationEqualsToValue(index - 1, subtractedByNumber) || calculateIfConfigurationEqualsToValue(index - 1, dividedByNumber);
        }
        return calculateIfConfigurationEqualsToValue(index - 1, subtractedByNumber);
    }

    public Long getValue() {
        return value;
    }
}
