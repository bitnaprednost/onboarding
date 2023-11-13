package day1;

public class Food {
    private Integer calories;

    public Food(){}

    public Food(int calories) {
        this.calories=calories;
    }

    public boolean hasCalories() {
        if(calories==null) return false;
        return calories > 0;
    }

    public Integer getCalories() {
        return calories;
    }
}
