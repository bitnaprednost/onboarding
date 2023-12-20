package hr.bp.aoc.calorie.counting;

import hr.bp.aoc.calorie.counting.visitor.FoodVisitor;
import hr.bp.aoc.calorie.counting.visitor.Visitor;

import org.apache.commons.lang3.Validate;

/**
 * <p>Food class.</p>
 *
 * @author Marko Krišković
 */
public class Food {

	private final Integer calories;

	private Food(int calories) {
		this.calories = calories;
	}

	public static Food of(int calories) {
		Validate.isTrue(hasCalories(calories), "Food can't contain negative calories.");

		return new Food(calories);
	}

	public boolean hasCalories() {
		Validate.notNull(calories, "Food calories is not initialized");

		return Food.hasCalories(calories);
	}

	private static boolean hasCalories(int calories) {
		return calories >= 0;
	}

	public void accept(Visitor visitor) {
		visitor.accept(calories);
	}

	public Integer getCalories() {
		Visitor visitor = new FoodVisitor();
		this.accept(visitor);

		return visitor.getSum();
	}

	@Override
	public String toString() {
		return "Food{" + "calories=" + calories + '}';
	}

}