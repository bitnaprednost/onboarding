package hr.bp.aoc.calorieCounting.visitor;

import hr.bp.aoc.calorieCounting.Food;
import hr.bp.aoc.calorieCounting.visitor.Visitor;

import java.util.List;

/**
 * @author Marko Krišković
 */
public class FoodVisitor implements Visitor<Food> {
    public int visit(Food food) {
        return food.accept(this);
    }
    public int accept(Food food){
        return food.getCalories();
    }

    public int getSum(List<Food> foodList){
        return foodList.stream().mapToInt(this::visit).sum();
    }
}
