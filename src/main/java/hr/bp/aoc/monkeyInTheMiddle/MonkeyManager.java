package hr.bp.aoc.monkeyInTheMiddle;

import java.util.Set;

public class MonkeyManager {
    private Set<Monkey> monkeys;
    private MonkeyManager(Monkey... monkeys) {
        this.monkeys = Set.of(monkeys);
    }

    public static MonkeyManager of(Monkey monkey0, Monkey monkey1, Monkey monkey2, Monkey monkey3) {
        return new MonkeyManager(monkey0, monkey1, monkey2, monkey3);
    }
}
