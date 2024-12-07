package hr.bp.adventofcode_2024.day07;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class CalibrationEquationSolver {

    private final Long targetValue;

    private final List<Long> operands;

    public CalibrationEquationSolver(long targetValue, List<Long> operands) {
        this.targetValue = targetValue;
        this.operands = operands;
    }

    public boolean isSolvable(boolean enableConcatenation) {
        return isConfigurationPossible(operands.size() - 1, targetValue, enableConcatenation);
    }

    private boolean isConfigurationPossible(int index, long targetValue, boolean enableConcatenation) {
        if (index == 0) return targetValue == operands.getFirst();

        long currentNumber = operands.get(index);

        long digits = (int) (Math.log10(Math.abs(currentNumber)) + 1);
        long tenRaisedToDigits = (long) Math.pow(10, digits);

        return isConfigurationPossible(index - 1, targetValue - currentNumber, enableConcatenation) ||
                (targetValue % currentNumber == 0 && isConfigurationPossible(index - 1, targetValue / currentNumber, enableConcatenation)) ||
                (enableConcatenation && (targetValue - currentNumber) % tenRaisedToDigits == 0 && isConfigurationPossible(index - 1, (targetValue - currentNumber) / tenRaisedToDigits, enableConcatenation));
    }

    public Long getTargetValue() {
        return targetValue;
    }
}
