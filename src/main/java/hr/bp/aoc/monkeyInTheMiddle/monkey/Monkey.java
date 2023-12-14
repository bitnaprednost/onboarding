package hr.bp.aoc.monkeyInTheMiddle.monkey;

import hr.bp.aoc.monkeyInTheMiddle.CombinedFunctionalInterface;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private final int id;
    private final Integer divisibleBy;
    private int timesInspectedItems = 0;
    private final List<Long> items;
    private Monkey trueMonkey;
    private Monkey falseMonkey;
    private final CombinedFunctionalInterface function;

    public Monkey(Integer id, List<Long> items, CombinedFunctionalInterface function, Integer divisibleBy) {
        this.id = id;
        this.items = new ArrayList<>();
        this.items.addAll(items);
        this.function = function;
        this.divisibleBy = divisibleBy;
    }

    private Long operation(Long old){
        return function.operation(old);
    }

    public void inspectItems(){
        for (Long item : items){
            Long updatedItem = Math.floorDiv(operation(item), 3);

            if(updatedItem%divisibleBy==0) throwToMonkey(trueMonkey, updatedItem);
            else throwToMonkey(falseMonkey, updatedItem);

            timesInspectedItems++;
        }
        items.clear();
    }

    private void throwToMonkey(Monkey monkey, Long item){
        monkey.items.add(item);
    }

    public int getId() {
        return id;
    }

    public int getTimesInspectedItems() {
        return timesInspectedItems;
    }

    void setTrueMonkey(Monkey trueMonkey) {
        this.trueMonkey = trueMonkey;
    }

    void setFalseMonkey(Monkey falseMonkey) {
        this.falseMonkey = falseMonkey;
    }

    @Override
    public String toString() {
        return "Monkey " + id + ": "  + items;// +   ", numOfInspected: "+ timesInspectedItems;
    }
}
