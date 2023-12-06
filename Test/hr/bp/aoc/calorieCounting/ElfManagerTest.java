package hr.bp.aoc.calorieCounting;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElfManagerTest {

    @Test
    void ManagerCanCreateElf(){
        String calorie = "1000";
        Elf elf = ElfManager.createElf(calorie);

        assertEquals(elf.getCalories().toString(), calorie);
    }

    @Test
    void ManagerConstructorPassesNull(){
        String calorie = null;

        NullPointerException thrown = assertThrows(NullPointerException.class, ()-> {Elf elf = ElfManager.createElf(calorie);});
        assertEquals("String input is null.", thrown.getMessage());
    }

    @Test
    void ManagerConstructorPassesNonInteger(){
        String calorie = "a";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> {Elf elf = ElfManager.createElf(calorie);});
        assertEquals("Input is empty after filtering. Input is probably invalid.", thrown.getMessage());
    }

    @Test
    void ManagerConstructorPassesNegative(){
        String calorie = "-1000";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> {Elf elf = ElfManager.createElf(calorie);});
        assertEquals("Food can't contain negative calories.", thrown.getMessage());
    }

    @Test
    void ManagerCanCreateElfWithMultipleFood(){
        String calories = """
                1000
                2000
                3000""";
        Elf elf = ElfManager.createElf(calories);

        assertAll(
                "Has all calories",
                () -> assertEquals(1000, elf.getFood(0).getCalories()),
                () -> assertEquals(2000, elf.getFood(1).getCalories()),
                () -> assertEquals(3000, elf.getFood(2).getCalories())
        );
    }

    @Test
    void ManagerConstructorPassesMultipleElves(){
        String calories = """
                1000
                2000
                3000

                4000

                5000
                6000""";
        List<Elf> elves = ElfManager.createElves(calories);

        assertAll(
                "Has all elves",
                () -> assertEquals(elves.size(), 3),
                () -> assertEquals("1000", elves.get(0).getFood(0).getCalories().toString()),
                () -> assertEquals("2000", elves.get(0).getFood(1).getCalories().toString()),
                () -> assertEquals("3000", elves.get(0).getFood(2).getCalories().toString()),
                () -> assertEquals("4000", elves.get(1).getFood(0).getCalories().toString()),
                () -> assertEquals("5000", elves.get(2).getFood(0).getCalories().toString()),
                () -> assertEquals("6000", elves.get(2).getFood(1).getCalories().toString())
        );
    }

    @Test
    void ManagerCanFindElfWithMostCalories(){
        String calories = """
                1000
                2000
                3000

                4000

                5000
                6000""";
        List<Elf> elves = ElfManager.createElves(calories);
        Elf topElf = ElfManager.getElfMostCalories(elves);

        assertAll(
                "Elf matches",
                () -> assertEquals(topElf, elves.get(2)),
                () -> assertEquals("11000", topElf.getCalories().toString())
        );
    }

    @Test
    void ManagerCanFindTop3ElvesWithMostCalories(){
        String calories = """
                1000
                2000
                3000

                4000

                5000
                6000

                7000
                8000
                9000

                10000""";
        List<Elf> elves = ElfManager.createElves(calories);
        List<Elf> topElves = ElfManager.getElfMostCalories(elves, 3);

        assertAll(
                "Has all top elves",
                () -> assertEquals(3, topElves.size()),
                () -> assertEquals(topElves.get(0), elves.get(3)),
                () -> assertEquals(topElves.get(1), elves.get(2)),
                () -> assertEquals(topElves.get(2), elves.get(4)),
                () -> assertEquals("24000", topElves.get(0).getCalories().toString()),
                () -> assertEquals("11000", topElves.get(1).getCalories().toString()),
                () -> assertEquals("10000", topElves.get(2).getCalories().toString())
        );
    }

    @Test
    void ManagerCanFindTop3TotalCalories(){
        String calories = """
                1000
                2000
                3000

                4000

                5000
                6000

                7000
                8000
                9000

                10000""";
        List<Elf> elves = ElfManager.createElves(calories);
        List<Elf> topElves = ElfManager.getElfMostCalories(elves, 3);
        int sumCalories = ElfManager.sumCalories(topElves);

        assertEquals(45000, sumCalories);
    }
}