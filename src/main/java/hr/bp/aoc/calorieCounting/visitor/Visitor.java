package hr.bp.aoc.calorieCounting.visitor;

import java.util.List;

/**
 * @author Marko Krišković
 */
public interface Visitor{
    void accept(int calories);

    int getSum();
}
