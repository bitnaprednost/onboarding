package hr.bp.aoc.calorieCounting;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>ElfBuilder class.</p>
 *
 * @author Marko Krišković
 */
public class ElfBuilder {
    private List<Food> foodList;
    public ElfBuilder() {
        foodList = new ArrayList<>();
    }
    
    public ElfBuilder append(Food food){
        foodList.add(food);
        return this;
    }

    public ElfBuilder append(int food){
        foodList.add(Food.of(food));
        return this;
    }
    
    public Elf build(){
        return new Elf(foodList);
    }
}
