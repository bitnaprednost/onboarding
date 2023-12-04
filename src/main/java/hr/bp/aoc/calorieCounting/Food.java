package hr.bp.aoc.calorieCounting;

import org.apache.commons.lang3.Validate;

/**
 * <p>Food class.</p>
 *
 * @author Marko Krišković
 */
public class Food {
    private Integer calories;

    private Food(int calories) {
        this.calories=calories;
    }

    public static Food from(int calories){
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

    public int accept(ElfVisitor visitor){
        return calories;
    }

    private Integer getCalories() {
        return calories;
    }
}
