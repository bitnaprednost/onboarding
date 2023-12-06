package hr.bp.aoc.calorieCounting.visitor;

/**
 * @author Marko Krišković
 */
public interface Visitor{
    void accept(int calories);

    int getSum();
}
