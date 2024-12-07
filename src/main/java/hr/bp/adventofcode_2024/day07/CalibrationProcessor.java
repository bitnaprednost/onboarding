package hr.bp.adventofcode_2024.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class CalibrationProcessor {

    private final List<CalibrationEquationSolver> calibrationEquationSolvers = new ArrayList<>();

    public CalibrationProcessor(String input) {

        for (String line : input.split("\\n")) {
            long value = Long.parseLong(line.split(":")[0]);

            String[] numbersAsStrings = line.split(":")[1].strip().split("\\s+");
            List<Long> numbers = Arrays.stream(numbersAsStrings).map(Long::parseLong).toList();

            calibrationEquationSolvers.add(new CalibrationEquationSolver(value, numbers));
        }
    }


    public long calculateTotalCalibrationValue(boolean allowConcatenationOperator) {
        return calibrationEquationSolvers.stream()
                .filter(e -> e.isSolvable(allowConcatenationOperator))
                .mapToLong(CalibrationEquationSolver::getTargetValue)
                .sum();
    }
}
