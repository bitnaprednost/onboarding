package hr.bp.aoc.calorieCounting.visitor;

import hr.bp.aoc.calorieCounting.Elf;
import hr.bp.aoc.calorieCounting.visitor.Visitor;

import java.util.List;

/**
 * @author Marko Krišković
 */

public class ElfVisitor implements Visitor<Elf> {

    private int sum = 0;

    public void accept(int calories){
        sum += calories;
    }

    public int getSum(){
        return sum;
    }
}
