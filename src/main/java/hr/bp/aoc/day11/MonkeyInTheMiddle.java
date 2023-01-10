package hr.bp.aoc.day11;

import hr.bp.aoc.InputUtil;

import java.math.BigInteger;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MonkeyInTheMiddle {

    private static final int numberOfRoundsPartOne = 20;
    private static final int divisorPartOne = 3;
    private static final int numberOfRoundsPartTwo = 10000;
    private static final int divisorPartTwo = 1;

    private static int mod;


    public static void main(String[] args) throws Exception {

        Path inputFilePath = InputUtil.getPath(MonkeyInTheMiddle.class, "inputday11.txt");
        Path filePath = inputFilePath.toAbsolutePath();
        List<String> input = new ArrayList<>(Arrays.asList(InputUtil.readLines(filePath)));

        BigInteger resultOne = levelOfMonkeyBusiness(createListOfMonkeys(input), numberOfRoundsPartOne, divisorPartOne);
        System.out.println(resultOne);

        BigInteger resultTwo = levelOfMonkeyBusiness(createListOfMonkeys(input), numberOfRoundsPartTwo, divisorPartTwo);
        System.out.println(resultTwo);
    }

    private static BigInteger levelOfMonkeyBusiness(List<Monkey> monkeys, int numberOfInspections, int divisor) {
        inspection(numberOfInspections, monkeys, divisor);
        List<Integer> monkeyBusiness = new ArrayList<>();
        for (Monkey monkey : monkeys) {
            monkeyBusiness.add(monkey.getNumberOfInspections());
        }
        System.out.println(monkeyBusiness);
        monkeyBusiness.sort(Collections.reverseOrder());
        BigInteger one = BigInteger.valueOf(monkeyBusiness.get(0));
        BigInteger two = BigInteger.valueOf(monkeyBusiness.get(1));
        return one.multiply(two);
    }

    private static void inspection(int numberOfInspections, List<Monkey> monkeys, int divisor) {
        for (int i = 0; i < numberOfInspections; i++) {
            startRound(monkeys, divisor);
        }
    }

    private static void startRound(List<Monkey> monkeys, int divisor) {
        for (int j = 0; j < monkeys.size(); j++) {
            Monkey currentMonkey = monkeys.get(j);
            String[] operation = currentMonkey.getOperation();
            String arithmeticOperation = operation[0];
            String operator = operation[1];
            for (BigInteger item : currentMonkey.getItems()) {
                currentMonkey.updateNumberOfInspections();
                BigInteger newWorryLevel = recalculateWorryLevel(operator, arithmeticOperation, item, divisor);
                currentMonkey.setWorryLevel(item, newWorryLevel);
                throwItem(newWorryLevel, currentMonkey, monkeys);
            }
            currentMonkey.removeItems();
        }
    }

    private static BigInteger recalculateWorryLevel(String operator, String arithmeticOperation, BigInteger item, int divisor) {
        BigInteger newWorryLevel;
        BigInteger element;

        if (operator.equals("old")) {
            element = item;
        } else {
            element = new BigInteger(operator);
        }

        if (arithmeticOperation.equals("*")) {
            newWorryLevel = item.multiply(element);
        } else {
            newWorryLevel = item.add(element);
        }

        newWorryLevel = newWorryLevel.divide(BigInteger.valueOf(divisor));
        newWorryLevel = (newWorryLevel.divideAndRemainder(BigInteger.valueOf(mod)))[1];
        return newWorryLevel;
    }


    private static void throwItem(BigInteger newWorryLevel, Monkey currentMonkey, List<Monkey> monkeys) {
        BigInteger[] answer = newWorryLevel.divideAndRemainder(BigInteger.valueOf(currentMonkey.getTest()));
        if (answer[1].equals(BigInteger.valueOf(0))) {
            monkeys.get(currentMonkey.getTrueValue()).addItem(newWorryLevel);
        } else {
            monkeys.get(currentMonkey.getFalseValue()).addItem(newWorryLevel);
        }
    }


    private static List<Monkey> createListOfMonkeys(List<String> input) {
        mod = 1;
        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 0; i < input.size(); i += 7) {
            List<String> monkeyInput = input.subList(i, i + 6);
            monkeys.add(createMonkey(monkeyInput));
        }

        return monkeys;
    }

    private static Monkey createMonkey(List<String> monkeyInput) {

        String itemsLine = monkeyInput.get(1).replaceAll("[^0-9]", " ");
        itemsLine = itemsLine.trim().replaceAll(" +", " ");

        List<String> items = List.of(itemsLine.split(" "));

        String[] operationLine = monkeyInput.get(2).trim().split(" ");
        String[] operation = {operationLine[4], operationLine[5]};

        String[] testLine = monkeyInput.get(3).trim().split(" ");
        String test = testLine[3];
        mod *= Integer.parseInt(test);

        String[] trueLine = monkeyInput.get(4).trim().split(" ");
        String trueValue = trueLine[5];

        String[] falseLine = monkeyInput.get(5).trim().split(" ");
        String falseValue = falseLine[5];

        return new Monkey(items, operation, test, trueValue, falseValue);
    }


}
