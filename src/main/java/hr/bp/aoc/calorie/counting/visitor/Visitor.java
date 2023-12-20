package hr.bp.aoc.calorie.counting.visitor;

/**
 * <p>Visitor interface.</p>
 *
 * @author Marko Krišković
 */
public interface Visitor {

	void accept(int calories);

	int getSum();

}