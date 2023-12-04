package hr.bp.aoc.calorieCounting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElfTest {
    private Food food;

    @BeforeEach
    void init(){
        food = Food.from(1000);
    }
    @Test
    public void elfCanCarryFood(){
        Elf elf = Elf.of(food);

        assertTrue(elf.hasCalories());
    }
    @Test
     public void elfHasToCarryCalories(){
         Elf elf = Elf.of();

         assertFalse(elf.hasCalories());
     }

    @Test
    public void elfCanCarryMultipleFood(){
        Food food1 = Food.from(100);
        Food food2 = Food.from(0);
        Elf elf = Elf.of(food, food1, food2);

        assertAll(
                "Has all Food",
                () -> assertEquals(elf.getFood(0), food),
                () -> assertEquals(elf.getFood(1), food1),
                () -> assertEquals(elf.getFood(2), food2)
        );
    }

    @Test
    public void elfHasCalories(){
        Food food1 = Food.from(100);
        Food food2 = Food.from(0);
        Elf elf = Elf.of(food, food1, food2);

        assertTrue(elf.hasCalories());
    }

    @Test
    public void elfCanGetSumCalories(){
        Food food1 = Food.from(100);
        Food food2 = Food.from(10);
        Elf elf = Elf.of(food, food1, food2);

        assertEquals(elf.getCalories(), 1110);
    }

}