package day1;

import java.util.ArrayList;
import java.util.List;

public class Elf {
    private List<Food> foodList;

    public Elf(){
        foodList = new ArrayList<>();
    }

    public Elf(Food... foods) {
        foodList = List.of(foods);
    }

    public Elf(int[] calories) {
        foodList = new ArrayList<>();

        for(int calorie : calories){
            foodList.add(new Food(calorie));
        }
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
        return foodList.stream().mapToInt(Food::getCalories).filter(a->a>=0).sum();
    }
}
