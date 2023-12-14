package hr.bp.aoc.monkeyInTheMiddle;

import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.List;

public class MonkeyParser{

    private MonkeyParser(){}

    private static void validateForm(String[] split) {
        Validate.matchesPattern(split[0], "Monkey \\d+:", "First line doesn't match contracted form: %s", split[0]);
        Validate.matchesPattern(split[1], " +Starting items: \\d+(, \\d+)*", "Second line doesn't match contracted form: %s", split[1]);
        Validate.matchesPattern(split[2], " +Operation: new = .+", "Third line doesn't match contracted form: %s", split[2]);
        Validate.matchesPattern(split[3], " +Test: divisible by \\d+", "Fourth line doesn't match contracted form: %s", split[3]);
        Validate.matchesPattern(split[4], " +If true: throw to monkey \\d+", "Fifth line doesn't match contracted form: %s", split[4]);
        Validate.matchesPattern(split[5], " +If false: throw to monkey \\d+", "Sixth line doesn't match contracted form: %s", split[5]);
    }

    private static CombinedFunctionalInterface parseFunction(String input) {
        String functionString = input.trim().substring(17);
        String[] split = Arrays.stream(functionString.split(" ")).map(String::trim).toArray(String[]::new);

        CombinedFunctionalInterface cfi = null;

        if(split[0].matches("\\d+")){
            Integer integer1 = Integer.valueOf(split[0]);
            if(split[2].matches("\\d+")) {
                Integer integer2 = Integer.valueOf(split[2]);
                cfi = Operation.from(split[1]).initializeFunction(integer1, integer2, 0);
            }
            else if(split[2].matches("old")){
                cfi = Operation.from(split[1]).initializeFunction(integer1, null, 1);
            }
        }
        else if(split[0].matches("old")){
            if(split[2].matches("\\d+")) {
                Integer integer2 = Integer.valueOf(split[2]);
                cfi = Operation.from(split[1]).initializeFunction(integer2, null, 1);
            }
            else if(split[2].matches("old")){
                cfi = Operation.from(split[1]).initializeFunction(null, null, 2);
            }
        }

        return cfi;
    }

    private static MonkeyBuilder parseToMonkey(String input) {
        String[] split = input.split("\n");
        validateForm(split);

        Integer id = Integer.valueOf(split[0].substring(0, split[0].length()-1).substring(7));
        List<Integer> items = Arrays.stream(split[1].trim().substring(16).split(", ")).mapToInt(Integer::valueOf).boxed().toList();
        CombinedFunctionalInterface function = parseFunction(split[2]);
        Integer divisibleBy = Integer.valueOf(split[3].trim().substring(19));
        Integer throwTrueId = Integer.valueOf(split[4].trim().substring(25));
        Integer throwFalseId = Integer.valueOf(split[5].trim().substring(26));

        return buildMonkey(id, items, function, divisibleBy, throwTrueId, throwFalseId);
    }

    private static MonkeyBuilder buildMonkey(Integer id, List<Integer> items, CombinedFunctionalInterface function, Integer divisibleBy, Integer throwTrueId, Integer throwFalseId) {
        MonkeyBuilder builder = new MonkeyBuilder();

        return builder.setId(id)
                .setItems(items)
                .setFunction(function)
                .setMonkeyTrueId(throwTrueId)
                .setMonkeyFalseId(throwFalseId)
                .setDivisibleBy(divisibleBy);
    }


    public static Monkey[] parseToMonkies(String input) {
        String[] split = input.split("\n\n");

        Monkey[] monkeys = new Monkey[split.length];
        MonkeyBuilder[] monkeyBuildders = new MonkeyBuilder[split.length];
        for (int i=0;i<monkeys.length;i++){
            MonkeyBuilder monkey = parseToMonkey(split[i]);
            monkeyBuildders[i] = monkey;
            monkeys[i] = monkey.build();
        }

        for(int i=0;i<monkeys.length;i++){
            monkeys[i].setTrueMonkey(monkeys[monkeyBuildders[i].getMonkeyTrueId()]);
            monkeys[i].setFalseMonkey(monkeys[monkeyBuildders[i].getMonkeyFalseId()]);
        }

        return monkeys;
    }
}
