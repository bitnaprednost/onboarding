package hr.bp.aoc.calorieCounting;

import java.util.ArrayList;
import java.util.List;

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
        foodList.add(Food.from(food));
        return this;
    }
    
    public Elf build(){
        return new Elf(foodList);
    }
}
