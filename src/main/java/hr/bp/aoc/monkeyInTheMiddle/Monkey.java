package hr.bp.aoc.monkeyInTheMiddle;

import java.util.ArrayList;
import java.util.List;

public abstract class Monkey {
    private int id;
    private int timesInspectedItems = 0;
    List<Integer> items;

    protected Monkey(int id, List<Integer> items) {
        this.id = id;
        this.items = new ArrayList<>();
        this.items.addAll(items);
    }

    abstract Integer operation(Integer old);
    abstract void test();

    public void inspectItems(){
        int size = items.size();
        for (int i=0;i<size;i++){
            Integer updatedWorryLevel = operation(items.getFirst()) / 3;
            items.set(0, updatedWorryLevel);

            test();
            timesInspectedItems++;
        }
    }
    void throwToMonkey(Monkey monkey){
        Integer temp = items.getFirst();
        items.removeFirst();
        monkey.items.add(temp);
    }

    public int getId() {
        return id;
    }

    public int getTimesInspectedItems() {
        return timesInspectedItems;
    }

    @Override
    public String toString() {
        return "Monkey " + id + ": " + items;
    }
}
