package hr.bp.aoc.calorieCounting;

import java.util.List;

/**
 * @author Marko Krišković
 */
public class ElfVisitor {

    public int visitFood(Food food) {
        return food.accept(this);
    }

    public int accept(List<Food> foodList){
        return foodList.stream().mapToInt(this::visitFood).sum();
    }
}
