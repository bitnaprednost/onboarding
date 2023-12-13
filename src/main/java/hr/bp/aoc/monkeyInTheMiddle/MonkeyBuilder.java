package hr.bp.aoc.monkeyInTheMiddle;

import org.apache.commons.lang3.Validate;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MonkeyBuilder {
    private Integer id;
    private Integer divisibleBy;
    private Monkey monkeyTrue;
    private Monkey monkeyFalse;
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

    public MonkeyBuilder setMonkeyTrue(Monkey monkeyTrue) {
        this.monkeyTrue = monkeyTrue;
        return this;
    }

    public MonkeyBuilder setMonkeyFalse(Monkey monkeyFalse) {
        this.monkeyFalse = monkeyFalse;
        return this;
    }

    public MonkeyBuilder setFunction(CombinedFunctionalInterface function) {
        this.function = function;
        return this;
    }

    public Monkey build() {
        return new Monkey(id, items) {
            @Override
            Integer operation(Integer old) {
                return switch (function.getFunctionMode()){
                    case 0 -> function.get();
                    case 1 ->  function.apply2(old);
                    case 2 -> function.apply(old, old);
                    default -> throw new UnsupportedOperationException();
                };
            }

            @Override
            void test() {
                if(items.getFirst()%divisibleBy==0) throwToMonkey(monkeyTrue);
                else throwToMonkey(monkeyFalse);
            }
        };
    }
}
