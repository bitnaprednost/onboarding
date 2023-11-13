package day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElfTest {
    private Food food;

    @BeforeEach
    void init(){
        food = new Food(1000);
    }
    @Test
    public void elfCanCarryFood(){
        Elf elf = new Elf(food);

        assertTrue(elf.hasCalories());
    }
    @Test
     public void elfHasToCarryCalories(){
         Elf elf = new Elf();

         assertFalse(elf.hasCalories());
     }

    @Test
    public void elfCanNotHaveNegativeCalories(){
        food = new Food(-100);
        Elf elf = new Elf(food);

        assertFalse(elf.hasCalories());
    }

    @Test
    public void elfCanCarryMultipleFood(){
        Food food1 = new Food(-100);
        Food food2 = new Food(0);
        Elf elf = new Elf(food, food1, food2);

        assertAll(
                "Has all Food",
                () -> assertEquals(elf.getFood(0), food),
                () -> assertEquals(elf.getFood(1), food1),
                () -> assertEquals(elf.getFood(2), food2)
        );
    }

    @Test
    public void elfHasCalories(){
        Food food1 = new Food(-100);
        Food food2 = new Food(0);
        Elf elf = new Elf(food, food1, food2);

        assertTrue(elf.hasCalories());
    }

    @Test
    public void elfCanGetSumCalories(){
        Food food1 = new Food(100);
        Food food2 = new Food(10);
        Elf elf = new Elf(food, food1, food2);

        assertEquals(elf.getCalories(), 1110);
    }

    @Test
    public void elfIgnoresNegativesInSumCalories(){
        Food food1 = new Food(-100);
        Food food2 = new Food(0);
        Elf elf = new Elf(food, food1, food2);

        assertEquals(elf.getCalories(), 1000);
    }

}