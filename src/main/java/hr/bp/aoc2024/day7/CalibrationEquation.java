package hr.bp.aoc2024.day7;

import java.util.ArrayList;
import java.util.List;

public class CalibrationEquation {
    List<Equation> equations;

    public CalibrationEquation(List<String> data) {
        this(data, false);
    }

    public CalibrationEquation(List<String> data, boolean concatenation) {
        this.equations = getEquationsFromData(data, concatenation);
    }

    private static List<Equation> getEquationsFromData(List<String> data, boolean concatenation) {
        List<Equation> equations = new ArrayList<>();

        for (String line : data) {
            equations.add(new Equation(line.split(" "), concatenation));
        }

        return equations;
    }

    public long sumTrueEquations() {
        return equations.stream().filter(equation -> equation.isPossible)
                .map(Equation::getResult)
                .mapToLong(Long::longValue).sum();
    }

}
