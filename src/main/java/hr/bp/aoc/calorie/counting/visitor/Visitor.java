package hr.bp.aoc.calorie.counting.visitor;

/**
 * @author Marko Krišković
 */
public interface Visitor{
    void accept(int calories);

    int getSum();
}
