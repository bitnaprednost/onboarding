package hr.bp.aoc.calorieCounting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    public void foodHasCalories(){
        int calories = 0;
        Food food = Food.from(calories);

        assertTrue(food.hasCalories());
    }

    @Test
    public void foodCantHaveNegativeCalories(){
        int calories = -100;

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> {Food food = Food.from(calories);});
        assertEquals("Food can't contain negative calories.", thrown.getMessage());
    }

//    @Test
//    public void foodCanCarryCalories(){
//        int calories = 1000;
//        Food food = Food.from(calories);
//        assertEquals(food.getCalories(), calories);
//    }
}