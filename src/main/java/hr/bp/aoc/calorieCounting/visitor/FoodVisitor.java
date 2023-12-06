package hr.bp.aoc.calorieCounting.visitor;

/**
 * @author Marko Krišković
 */
public class FoodVisitor implements Visitor {
    private int sum = 0;

    @Override
    public void accept(int calories){
        sum += calories;
    }

    @Override
    public int getSum(){
        return sum;
    }
}
