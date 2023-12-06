package hr.bp.aoc.calorieCounting;

import hr.bp.aoc.calorieCounting.visitor.ElfVisitor;
import hr.bp.aoc.calorieCounting.visitor.FoodVisitor;
import hr.bp.aoc.calorieCounting.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Elf class.</p>
 *
 * @author Marko Krišković
 */
public class Elf {
    private List<Food> foodList;

    private Elf(){
        foodList = new ArrayList<>();
    }

    private Elf(Food... foods) {
        foodList = List.of(foods);
    }

    Elf(List<Food> foodList) {
        this.foodList = foodList;
    }

    public static Elf of(Food... foods){
        return new Elf(foods);
    }

    public boolean hasCalories() {
        for(Food food : foodList) {
            if(food.hasCalories()) return true;
        }
        return false;
    }

    public Food getFood(int i) {
        return foodList.get(i);
    }

    public Integer getCalories() {
        FoodVisitor visitor = new FoodVisitor();

        for (Food food : foodList) {
            food.accept(visitor);
        }

        return visitor.getSum();
    }

    public void accept(Visitor visitor){
        visitor.accept(this.getCalories());
    }

    @Override
    public String toString() {
        return "Elf{" +
                "foodList=" + foodList +
                '}';
    }
}
