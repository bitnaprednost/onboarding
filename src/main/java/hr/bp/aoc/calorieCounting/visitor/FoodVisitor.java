package hr.bp.aoc.calorieCounting.visitor;

import hr.bp.aoc.calorieCounting.Food;
import hr.bp.aoc.calorieCounting.visitor.Visitor;

import java.util.List;

/**
 * @author Marko Krišković
 */
public class FoodVisitor implements Visitor<Food> {

    private int sum = 0;
    public void accept(int calories){
        sum += calories;
    }

    public int getSum(){
        return sum;
    }
}
