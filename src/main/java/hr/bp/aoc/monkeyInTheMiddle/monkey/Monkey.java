package hr.bp.aoc.monkeyInTheMiddle.monkey;

import hr.bp.aoc.monkeyInTheMiddle.CombinedFunctionalInterface;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Monkey class.</p>
 *
 * @author Marko Krišković
 */
public class Monkey {
    private final int id;
    private final Integer divisibleBy;
    private long timesInspectedItems = 0;
    private final List<BigInteger> items;
    private Monkey trueMonkey;
    private Monkey falseMonkey;
    private final CombinedFunctionalInterface function;

    public Monkey(Integer id, List<BigInteger> items, CombinedFunctionalInterface function, Integer divisibleBy) {
        this.id = id;
        this.items = new ArrayList<>();
        this.items.addAll(items);
        this.function = function;
        this.divisibleBy = divisibleBy;
    }

    private BigInteger operation(BigInteger old){
        return function.operation(old);
    }

    public void inspectItems(long magicNumber){
        inspectItems(magicNumber, true);
    }

    public void inspectItemsNoRelief(long magicNumber) {
        inspectItems(magicNumber, false);
    }

    private void inspectItems(long magicNumber, boolean relief){
        for (BigInteger item : items){
            item = operation(item);
            if(relief) item = item.divide(BigInteger.valueOf(3));
            item = item.mod(BigInteger.valueOf(magicNumber));

            if(item.mod(BigInteger.valueOf(divisibleBy)).equals(BigInteger.ZERO)) throwToMonkey(trueMonkey, item);
            else throwToMonkey(falseMonkey, item);

            timesInspectedItems++;
        }
        items.clear();
    }

    private void throwToMonkey(Monkey monkey, BigInteger item){
        monkey.items.add(item);
    }

    public int getId() {
        return id;
    }

    public long getTimesInspectedItems() {
        return timesInspectedItems;
    }

    public Integer getDivisibleBy() {
        return divisibleBy;
    }

    void setTrueMonkey(Monkey trueMonkey) {
        this.trueMonkey = trueMonkey;
    }

    void setFalseMonkey(Monkey falseMonkey) {
        this.falseMonkey = falseMonkey;
    }

    @Override
    public String toString() {
        return "Monkey " + id + ": "  + items +   ", numOfInspected: "+ timesInspectedItems;
    }
}
