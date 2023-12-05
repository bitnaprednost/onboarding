package hr.bp.aoc.calorieCounting;

import java.util.List;

/**
 * @author Marko Krišković
 */
public class ElfVisitor {

    public int visitFood(Food food) {
        return food.accept(this);
    }
    public int acceptFood(List<Food> foodList){
        return foodList.stream().mapToInt(this::visitFood).sum();
    }

    public int visitElf(Elf elf) {
        return elf.accept(this);
    }

    public int acceptElf(List<Elf> elfList){
        return elfList.stream().mapToInt(this::visitElf).sum();
    }
}
