package day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    @Test
    public void foodHasToCarryCalories(){
        int calories = 1000;
        Food food = new Food();

        assertFalse(food.hasCalories());
    }

    @Test
    public void foodHasCalories(){
        int calories = 0;
        Food food = new Food(calories);

        assertFalse(food.hasCalories());
    }

    @Test
    public void foodCantHaveNegativeCalories(){
        int calories = -100;
        Food food = new Food(calories);

        assertFalse(food.hasCalories());
    }

    @Test
    public void foodCanCarryCalories(){
        int calories = 1000;
        Food food = new Food(calories);
        assertEquals(food.getCalories(), calories);
    }
}