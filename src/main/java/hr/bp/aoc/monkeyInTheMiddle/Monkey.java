package hr.bp.aoc.monkeyInTheMiddle;

import java.util.ArrayList;
import java.util.List;

public abstract class Monkey {
    private int id;
    List<Integer> items;

    protected Monkey(int id, List<Integer> items) {
        this.id = id;
        this.items = new ArrayList<>();
        this.items.addAll(items);
    }

    abstract Integer operation(Integer old);
    abstract void test(int position);

    public void inspectItems(){
        int size = items.size();
        for (int i=0;i<size;i++){
            Integer updatedWorryLevel = operation(items.getFirst()) / 3;    //check if rounds down everytiem
            items.set(0, updatedWorryLevel);

            test(0);
        }
    }
    void throwToMonkey(int position, Monkey monkey){
        Integer temp = items.get(position);
        items.remove(position);
        monkey.items.add(temp);
    }

    @Override
    public String toString() {
        return "Monkey " + id + ": " + items;
    }
}
