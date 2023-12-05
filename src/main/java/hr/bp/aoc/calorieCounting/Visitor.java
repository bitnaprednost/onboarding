package hr.bp.aoc.calorieCounting;

import java.util.List;

/**
 * @author Marko Krišković
 */
public interface Visitor <T>{
    int visit(T item);
    int accept(T item);

    int getSum(List<T> itemList);
}
