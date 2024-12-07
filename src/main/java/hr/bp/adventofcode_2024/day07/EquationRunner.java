package hr.bp.adventofcode_2024.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class EquationRunner {

    private final List<EquationSolver> equationSolvers = new ArrayList<>();

    public EquationRunner(String input) {

        for (String line : input.split("\\n")) {
            long value = Long.parseLong(line.split(":")[0]);

            String[] numbersAsStrings = line.split(":")[1].strip().split("\\s+");
            List<Long> numbers = Arrays.stream(numbersAsStrings).map(Long::parseLong).toList();

            equationSolvers.add(new EquationSolver(value, numbers));
        }
    }


    public long sumSolvableEquations() {
        return equationSolvers.stream()
                .filter(EquationSolver::hasSolution)
                .mapToLong(EquationSolver::getValue)
                .sum();
    }
}
