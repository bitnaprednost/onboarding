package hr.bp.aoc.day11;

import java.util.List;
import java.util.ArrayList;

public class Monkey {
    private List<Long> items = new ArrayList<>();
    private final String[] operation;
    private final int test;
    private final int trueValue;
    private final int falseValue;
    private int numberOfInspections = 0;


    public Monkey(List<String> items, String[] operation, String test, String trueValue, String falseValue) {
        for (String item : items) {
            this.addItem(Integer.parseInt(item));
        }
        this.operation = operation;
        this.test = Integer.parseInt(test);
        this.trueValue = Integer.parseInt(trueValue);
        this.falseValue = Integer.parseInt(falseValue);
    }

    public void addItem(long item) {
        items.add(item);
    }


    public int getNumberOfInspections() {
        return numberOfInspections;
    }

    public List<Long> getItems() {
        return items;
    }


    public String[] getOperation() {
        return operation;
    }

    public int getTest() {
        return test;
    }

    public int getTrueValue() {
        return trueValue;
    }

    public int getFalseValue() {
        return falseValue;
    }

    public void setWorryLevel(long item, long worryLevel) {
        int index = this.items.indexOf(item);
        if (index >= 0) {
            this.items.set(index, worryLevel);
        }
    }

    public void updateNumberOfInspections(){
       numberOfInspections++;
    }

    public void removeItems(){
        items.clear();
    }
}
