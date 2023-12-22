package hr.bp.aoc.monkeyInTheMiddle.monkey;

import hr.bp.aoc.monkeyInTheMiddle.CombinedFunctionalInterface;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;
import java.util.List;

/**
 * <p>MonkeyBuilder class.</p>
 *
 * @author Marko Krišković
 */
public class MonkeyBuilder {
    private Integer id;
    private Integer divisibleBy;
    private Integer monkeyTrueId;
    private Integer monkeyFalseId;
    private List<BigInteger> items;
    private CombinedFunctionalInterface function;

    public List<BigInteger> getItems() {
        return items;
    }

    public MonkeyBuilder items(List<BigInteger> items) {
        this.items = items;
        return this;
    }

    public MonkeyBuilder id(Integer id) {
        Validate.isTrue(id>=0, "Id must be positive");

        this.id = id;
        return this;
    }

    public MonkeyBuilder divisibleBy(Integer divisibleBy) {
        Validate.isTrue(divisibleBy>0 ,"Divisible number must be positive");

        this.divisibleBy = divisibleBy;
        return this;
    }

    public MonkeyBuilder function(CombinedFunctionalInterface function) {
        this.function = function;
        return this;
    }

    public MonkeyBuilder trueId(Integer monkeyTrueId) {
        this.monkeyTrueId = monkeyTrueId;
        return this;
    }

    public MonkeyBuilder falseId(Integer monkeyFalseId) {
        this.monkeyFalseId = monkeyFalseId;
        return this;
    }

    public Monkey build() {
        return new Monkey(id, items, function, divisibleBy);
    }

    public void monkeysToThrow(Monkey[] monkeys) {
        monkeys[id].setTrueMonkey(monkeys[monkeyTrueId]);
        monkeys[id].setFalseMonkey(monkeys[monkeyFalseId]);
    }
}
