package hr.bp.aoc.monkeyInTheMiddle;

import org.apache.commons.lang3.Validate;

import java.util.List;

public class MonkeyBuilder {
    private Integer id;
    private Integer divisibleBy;
    private Integer monkeyTrueId;
    private Integer monkeyFalseId;
    private List<Integer> items;
    private CombinedFunctionalInterface function;

    public List<Integer> getItems() {
        return items;
    }

    public MonkeyBuilder setItems(List<Integer> items) {
        this.items = items;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public MonkeyBuilder setId(Integer id) {
        Validate.isTrue(id>=0, "Id must be positive");

        this.id = id;
        return this;
    }

    public Integer getDivisibleBy() {
        return divisibleBy;
    }

    public MonkeyBuilder setDivisibleBy(Integer divisibleBy) {
        Validate.isTrue(divisibleBy>0 ,"Divisible number must be positive");

        this.divisibleBy = divisibleBy;
        return this;
    }

    public MonkeyBuilder setFunction(CombinedFunctionalInterface function) {
        this.function = function;
        return this;
    }

    public Integer getMonkeyTrueId() {
        return monkeyTrueId;
    }

    public MonkeyBuilder setMonkeyTrueId(Integer monkeyTrueId) {
        this.monkeyTrueId = monkeyTrueId;
        return this;
    }

    public Integer getMonkeyFalseId() {
        return monkeyFalseId;
    }

    public MonkeyBuilder setMonkeyFalseId(Integer monkeyFalseId) {
        this.monkeyFalseId = monkeyFalseId;
        return this;
    }

    public Monkey build() {
        return new Monkey(id, items, function, divisibleBy);
    }
}
