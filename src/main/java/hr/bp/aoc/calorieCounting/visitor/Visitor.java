package hr.bp.aoc.calorieCounting.visitor;

import java.util.List;

/**
 * @author Marko Krišković
 */
public interface Visitor <T>{
    void accept(int calories);

    int getSum();
}
