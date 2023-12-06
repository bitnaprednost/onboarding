package hr.bp.aoc.calorieCounting.visitor;

import hr.bp.aoc.calorieCounting.Elf;
import hr.bp.aoc.calorieCounting.visitor.Visitor;

import java.util.List;

/**
 * @author Marko Krišković
 */

public class ElfVisitor implements Visitor{

    private int sum = 0;

    @Override
    public void accept(int calories){
        sum += calories;
    }

    @Override
    public int getSum(){
        return sum;
    }

}
