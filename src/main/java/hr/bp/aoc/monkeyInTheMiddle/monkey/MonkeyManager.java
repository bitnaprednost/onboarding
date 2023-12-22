package hr.bp.aoc.monkeyInTheMiddle.monkey;

import hr.bp.aoc.hill.climbing.algorithm.Main;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * <p>MonkeyManager class.</p>
 *
 * @author Marko Krišković
 */
public class MonkeyManager {
    private static final Logger logger = LoggerFactory.getLogger(MonkeyManager.class);

    private final List<Monkey> monkeys;
    private final long magicNumber;
    private MonkeyManager(Monkey... monkeys) {
        this.monkeys = List.of(monkeys);

        this.magicNumber = Arrays.stream(monkeys).mapToInt(Monkey::getDivisibleBy).reduce(1,(prod, elem)->prod*elem);
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
        for(int i=0;i<rounds;i++) {
            monkeys.forEach(monkey -> monkey.inspectItems(magicNumber));
            //logger.info(i + ". " + monkeys);
        }
    }

    public void simulateRoundsNoRelief(int rounds) {
        for(int i=0;i<rounds;i++) {
            monkeys.forEach(monkey -> monkey.inspectItemsNoRelief(magicNumber));
            //logger.info(i + ". " + monkeys);
        }
    }

    public long getTimesInspectedItems(int id) {
        return monkeys.stream()
                .filter(m->m.getId()==id)
                .mapToLong(Monkey::getTimesInspectedItems)
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

    public Long getProductOfTopActiveMonkeys(int limit) {
        return getTopActiveMonkeys(limit).stream()
                .mapToLong(Monkey::getTimesInspectedItems)
                .reduce(1, (total, element) -> total * element);
    }
}
