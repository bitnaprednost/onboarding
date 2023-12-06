package hr.bp.aoc.calorieCounting;

import hr.bp.aoc.calorieCounting.visitor.FoodVisitor;
import org.apache.commons.lang3.Validate;

/**
 * <p>Food class.</p>
 *
 * @author Marko Krišković
 */
public class Food {
    private final Integer calories;

    private Food(int calories) {
        this.calories=calories;
    }

    public static Food of(int calories){
        Validate.isTrue(hasCalories(calories), "Food can't contain negative calories.");
        //if(!hasCalories(calories)) throw new IllegalArgumentException("Food can't contain negative calories.");

        return new Food(calories);
    }

    public boolean hasCalories() {
        Validate.notNull(calories, "Food calories is not initialized");
        
        return Food.hasCalories(calories);
    }

    private static boolean hasCalories(int calories){
        return calories >= 0;
    }

    public void accept(FoodVisitor visitor){
         visitor.accept(getCalories());
    }

    public Integer getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "calories=" + calories +
                '}';
    }
}
