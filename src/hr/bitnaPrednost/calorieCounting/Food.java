package hr.bitnaPrednost.calorieCounting;

public class Food {
    private Integer calories;

    private Food(int calories) {
        this.calories=calories;
    }

    public static Food from(int calories){
        if(!hasCalories(calories)) throw new IllegalArgumentException("Food can't contain negative calories.");

        return new Food(calories);
    }

    private static boolean hasCalories(int calories){
        return calories >= 0;
    }

    public boolean hasCalories() {
        if(calories==null) return false;
        
        return Food.hasCalories(calories);
    }

    public Integer getCalories() {
        return calories;
    }
}
