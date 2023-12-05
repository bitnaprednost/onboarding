package hr.bp.aoc.calorieCounting;

import java.util.List;

/**
 * @author Marko Krišković
 */

//razdvoji u 2 faila
public class ElfVisitor implements Visitor<Elf>{

    public int visit(Elf elf) {
        return elf.accept(this);
    }

    public int accept(Elf elf){
        return elf.getCalories();
    }

    public int getSum(List<Elf> foodList){
        return foodList.stream().mapToInt(this::visit).sum();
    }
}
