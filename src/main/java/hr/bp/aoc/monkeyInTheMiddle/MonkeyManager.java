package hr.bp.aoc.monkeyInTheMiddle;

import org.apache.commons.lang3.Validate;

import java.util.*;

public class MonkeyManager {
    private List<Monkey> monkeys;
    private MonkeyManager(Monkey... monkeys) {
        this.monkeys = List.of(monkeys);
    }

    public static MonkeyManager of(Monkey... monkeys) {
        return new MonkeyManager(monkeys);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Monkey monkey : monkeys){
            sb.append(monkey).append("\n");
        }

        return sb.toString();
    }

    public void simulateRounds(int rounds) {
        for(int i=0;i<rounds;i++) monkeys.forEach(Monkey::inspectItems);
    }

    public int getTimesInspectedItems(int id) {
        return monkeys.stream()
                .filter(m->m.getId()==id)
                .mapToInt(Monkey::getTimesInspectedItems)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Monkey> getTopActiveMonkeys(int limit) {
        Validate.isTrue(limit > 0, "Argument must be a positive number");

        return monkeys.stream()
                .sorted(Comparator.comparing(Monkey::getTimesInspectedItems).reversed())
                .limit(limit)
                .toList();
    }

    public Integer getProductOfTopActiveMonkeys(int limit) {
        return getTopActiveMonkeys(limit).stream()
                .mapToInt(Monkey::getTimesInspectedItems)
                .reduce(1, (total, element) -> total * element);

//        return monkeys.stream()
//                .mapToInt(Monkey::getTimesInspectedItems)
//                .boxed()
//                .sorted(Comparator.reverseOrder())
//                .limit(limit)
//                .reduce(1, (total, element) -> total * element);
    }
}
