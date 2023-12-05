package hr.bp.aoc.calorieCounting;

import java.util.List;

/**
 * @author Marko Krišković
 */

//razdvoji u 2 faila
public class ElfVisitor {

    public int visitFood(Food food) {
        return food.accept(this);
    }
    public int acceptFood(Food food){
        return food.getCalories();
    }

    public int getFoodSum(List<Food> foodList){
        return foodList.stream().mapToInt(this::visitFood).sum();
    }

    public int visitElf(Elf elf) {
        return elf.accept(this);
    }

    public int acceptElf(Elf elf){
        return elf.getCalories();
    }

    public int getElfSum(List<Elf> foodList){
        return foodList.stream().mapToInt(this::visitElf).sum();
    }
}
