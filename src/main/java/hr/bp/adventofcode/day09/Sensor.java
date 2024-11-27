package hr.bp.adventofcode.day09;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Sensor {

    List<PolynomialEquation> history = new ArrayList<>();

    public Sensor(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        initializeHistory(input);
    }

    private void initializeHistory(String input) {
        for (String line : input.split("\\n")) {
            addPolynomialEquationToHistory(line);
        }
    }

    private void addPolynomialEquationToHistory(String line) {
        history.add(
                new PolynomialEquation(Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .toList()
                )
        );
    }

    public List<PolynomialEquation> getHistory() {
        return this.history;
    }

    public BigDecimal sumNextValues() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (PolynomialEquation polynomialEquation : history) {
            sum = sum.add(polynomialEquation.calculateNextValue());
        }
        return sum;
    }

    public BigDecimal sumPreviousValues() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (PolynomialEquation polynomialEquation : history) {
            sum = sum.add(polynomialEquation.calculatePreviousValue());
        }
        return sum;
    }
}
