package hr.bp.aoc2024.day7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equation {
    private static final int RESULT = 0;
    private static final Logger log = LoggerFactory.getLogger(Equation.class);

    public boolean isPossible;
    private long result;
    private List<Long> numbers;
    private boolean concatenation;

    public Equation(String[] data) {
        this(data, false);
    }

    public Equation(String[] data, boolean concatenation) {
        result = Long.parseLong(data[RESULT]);
        numbers = getNumbersFromData(data);
        this.concatenation = concatenation;
        isPossible = checkIfPossible();
    }

    private boolean checkIfPossible() {
        List<String> combinations = generateAllCombinations(numbers.size());

        if (checkIfCombinationCorrect(combinations))
            return true;


        return false;
    }

    private boolean checkIfCombinationCorrect(List<String> combinations) {
        for (String combination : combinations) {
            long combinationResult = combinationResult(combination.split(""));
            if (combinationResult == result) {
                log.debug("Equation {}:{} is true using this combination of operators {}",result, numbers, combination);

                return true;
            }
        }
        return false;
    }

    private long combinationResult(String[] combination) {
        long combinationResult = numbers.get(0);

        for (int index = 0; index < combination.length; index++) {
            if (Objects.equals(combination[index], "+")) {
                combinationResult += numbers.get(index + 1);
            } else if (Objects.equals(combination[index], "*")) {
                combinationResult *= numbers.get(index + 1);
            } else {
                combinationResult = concatenateDigit(combinationResult, numbers.get(index+1));
            }
        }
        return combinationResult;
    }

    private long concatenateDigit(long leftNumber, long rightNumber) {
        String leftPart = Long.toString(leftNumber);
        String rightPart = Long.toString(rightNumber);

        return Long.parseLong(leftPart+rightPart);
    }

    private List<String> generateAllCombinations(int n) {
        List<String> combinations = new ArrayList<>();

        if (n <= 1)
            return combinations;

        generateCombinationsHelper(combinations, "", n - 1);
        return combinations;
    }

    private void generateCombinationsHelper(List<String> combinations, String current, int operatorsNeeded) {
        if (operatorsNeeded == 0) {
            combinations.add(current);
            return;
        }

        generateCombinationsHelper(combinations, current + "+", operatorsNeeded - 1);
        generateCombinationsHelper(combinations, current + "*", operatorsNeeded - 1);
        if (concatenation)
            generateCombinationsHelper(combinations, current + "|", operatorsNeeded - 1);
    }

    private List<Long> getNumbersFromData(String[] data) {
        List<Long> numbers = new ArrayList<>();

        for (int i = 1; i < data.length; i++) {
            if (!data[i].isEmpty())
                numbers.add(Long.parseLong(data[i]));
        }

        return numbers;
    }

    public long getResult() {
        return result;
    }
}
