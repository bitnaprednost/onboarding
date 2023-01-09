package hr.bp.aoc.day11;

import hr.bp.aoc.InputUtil;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MonkeyInTheMiddle {

    public static void main(String[] args) throws Exception {

        Path inputFilePath = InputUtil.getPath(MonkeyInTheMiddle.class, "inputday11.txt");
        Path filePath = inputFilePath.toAbsolutePath();
        List<String> input = new ArrayList<>(Arrays.asList(InputUtil.readLines(filePath)));

        List<Monkey> monkeys = createListOfMonkeys(input);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < monkeys.size(); j++) {
                Monkey currentMonkey = monkeys.get(j);
                for (Long item : currentMonkey.getItems()) {
                    currentMonkey.updateNumberOfInspections();
                    long newWorryLevel = recalculateWorryLevel(currentMonkey, item);
                    currentMonkey.setWorryLevel(item, newWorryLevel);
                    throwItem(newWorryLevel, currentMonkey, monkeys);
                }
                currentMonkey.removeItems();
            }
        }
        List<Integer> monkeyBusiness = new ArrayList<>();

        for (Monkey monkey : monkeys) {
            monkeyBusiness.add(monkey.getNumberOfInspections());
        }
        monkeyBusiness.sort(Collections.reverseOrder());
        System.out.println(monkeyBusiness.get(0) * monkeyBusiness.get(1));
    }

    private static List<Monkey> createListOfMonkeys(List<String> input) {
        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 0; i < input.size(); i += 7) {
            String itemsLine = input.get(i + 1).replaceAll("[^0-9]", " ");
            itemsLine = itemsLine.trim().replaceAll(" +", " ");

            List<String> items = List.of(itemsLine.split(" "));

            String[] operationLine = input.get(i + 2).trim().split(" ");
            String[] operation = {operationLine[4], operationLine[5]};

            String[] testLine = input.get(i + 3).trim().split(" ");
            String test = testLine[3];

            String[] trueLine = input.get(i + 4).trim().split(" ");
            String trueValue = trueLine[5];

            String[] falseLine = input.get(i + 5).trim().split(" ");
            String falseValue = falseLine[5];

            Monkey monkey = new Monkey(items, operation, test, trueValue, falseValue);
            monkeys.add(monkey);

        }
        return monkeys;
    }

    private static long recalculateWorryLevel(Monkey monkey, long item) {
        long newWorryLevel;
        String[] operation = monkey.getOperation();
        String arithmeticOperation = operation[0];
        long operator;

        if (operation[1].equals("old")) {
            operator = item;
        } else operator = Integer.parseInt(operation[1]);

        if (arithmeticOperation.equals("*")) {
            newWorryLevel = item * operator;
        } else {
            newWorryLevel = item + operator;
        }

        newWorryLevel /= 3;
        return newWorryLevel;
    }

    private static void throwItem(long newWorryLevel, Monkey currentMonkey, List<Monkey> monkeys) {
        if (newWorryLevel % currentMonkey.getTest() == 0) {
            monkeys.get(currentMonkey.getTrueValue()).addItem(newWorryLevel);
        } else {
            monkeys.get(currentMonkey.getFalseValue()).addItem(newWorryLevel);
        }
    }
}
