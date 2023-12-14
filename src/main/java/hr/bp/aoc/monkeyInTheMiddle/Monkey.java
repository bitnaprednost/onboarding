package hr.bp.aoc.monkeyInTheMiddle;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private int id;
    private Integer divisibleBy;
    private int timesInspectedItems = 0;
    private List<Integer> items;
    private Monkey trueMonkey;
    private Monkey falseMonkey;
    private CombinedFunctionalInterface function;

    public Monkey(Integer id, List<Integer> items, CombinedFunctionalInterface function, Integer divisibleBy) {
        this.id = id;
        this.items = new ArrayList<>();
        this.items.addAll(items);
        this.function = function;
        this.divisibleBy = divisibleBy;
    }

    private Integer operation(Integer old){
        return function.operation(old);
    }

    public void inspectItems(){
        for (Integer item : items){
            Integer updatedItem = operation(item);
            updatedItem = Math.floorDiv(updatedItem, 3);

            if(updatedItem%divisibleBy==0) throwToMonkey(trueMonkey, updatedItem);
            else throwToMonkey(falseMonkey, updatedItem);

            timesInspectedItems++;
        }
        items.clear();
    }

    private void throwToMonkey(Monkey monkey, Integer item){
        monkey.items.add(item);
    }

    public int getId() {
        return id;
    }

    public int getTimesInspectedItems() {
        return timesInspectedItems;
    }

    public void setTrueMonkey(Monkey trueMonkey) {
        this.trueMonkey = trueMonkey;
    }

    public void setFalseMonkey(Monkey falseMonkey) {
        this.falseMonkey = falseMonkey;
    }

    @Override
    public String toString() {
        return "Monkey " + id + ": " + items +  ", numOfInspected: " + timesInspectedItems;
    }
}
