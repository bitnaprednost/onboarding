package hr.bp.aoc.calorie.counting.visitor;

/**
 * <p>ElfVisitor class.</p>
 *
 * @author Marko Krišković
 */
public class ElfVisitor implements Visitor {

	private int sum = 0;

	@Override
	public void accept(int calories) {
		sum += calories;
	}

	@Override
	public int getSum() {
		return sum;
	}

}