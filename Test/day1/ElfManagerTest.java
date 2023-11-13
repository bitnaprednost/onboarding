package day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElfManagerTest {
    private ElfManager manager;

    @BeforeEach
    public void init(){
        manager = new ElfManager();
    }
    @Test
    public void ManagerCanCreateElf(){
        String calorie = "1000";
        Elf elf = manager.createElf(calorie);

        assertEquals(elf.getCalories().toString(), calorie);
    }

    @Test
    public void ManagerConstructorPassesNull(){
        String calorie = null;
        Elf elf = manager.createElf(calorie);

        assertEquals(elf, null);
    }

    @Test
    public void ManagerConstructorPassesNonInteger(){
        String calorie = "a";
        Elf elf = manager.createElf(calorie);

        assertEquals(elf, null);
    }

    @Test
    public void ManagerConstructorPassesNegative(){
        String calorie = "-1000";
        Elf elf = manager.createElf(calorie);

        assertEquals(elf.getCalories().toString(), "0");
    }

    @Test
    public void ManagerCanCreateElfWithMultipleFood(){
        String calories = "1000\n" + "2000\n" + "3000";
        Elf elf = manager.createElf(calories);

        assertAll(
                "Has all calories",
                () -> assertEquals(elf.getFood(0).getCalories().toString(), "1000"),
                () -> assertEquals(elf.getFood(1).getCalories().toString(), "2000"),
                () -> assertEquals(elf.getFood(2).getCalories().toString(), "3000")
        );
    }

    @Test
    public void ManagerConstructorPassesMultipleElves(){
        String calories = "1000\n" + "2000\n" + "3000\n" + "\n"
                            + "4000\n" + "\n"
                            + "5000\n" + "6000";
        List<Elf> elves = manager.createElves(calories);

        assertAll(
                "Has all elves",
                () -> assertEquals(elves.size(), 3),
                () -> assertEquals(elves.get(0).getFood(0).getCalories().toString(), "1000"),
                () -> assertEquals(elves.get(0).getFood(1).getCalories().toString(), "2000"),
                () -> assertEquals(elves.get(0).getFood(2).getCalories().toString(), "3000"),
                () -> assertEquals(elves.get(1).getFood(0).getCalories().toString(), "4000"),
                () -> assertEquals(elves.get(2).getFood(0).getCalories().toString(), "5000"),
                () -> assertEquals(elves.get(2).getFood(1).getCalories().toString(), "6000")
        );
    }

    @Test
    public void ManagerCanFindElfWithMostCalories(){
        String calories = "1000\n" + "2000\n" + "3000\n" + "\n"
                + "4000\n" + "\n"
                + "5000\n" + "6000";
        List<Elf> elves = manager.createElves(calories);
        Elf topElf = manager.getElfMostCalories(elves);

        assertAll(
                "Elf matches",
                () -> assertEquals(topElf, elves.get(2)),
                () -> assertEquals(topElf.getCalories().toString(), "11000")
        );
    }

    @Test
    public void ManagerCanFindTop3ElvesWithMostCalories(){
        String calories = "1000\n" + "2000\n" + "3000\n" + "\n" +
                            "4000\n" + "\n" +
                            "5000\n" + "6000\n" + "\n" +
                            "7000\n" + "8000\n" + "9000\n" + "\n" +
                            "10000";
        List<Elf> elves = manager.createElves(calories);
        List<Elf> topElves = manager.getElfMostCalories(elves, 3);

        assertAll(
                "Has all top elves",
                () -> assertEquals(topElves.size(), 3),
                () -> assertEquals(topElves.get(0), elves.get(3)),
                () -> assertEquals(topElves.get(1), elves.get(2)),
                () -> assertEquals(topElves.get(2), elves.get(4)),
                () -> assertEquals(topElves.get(0).getCalories().toString(), "24000"),
                () -> assertEquals(topElves.get(1).getCalories().toString(), "11000"),
                () -> assertEquals(topElves.get(2).getCalories().toString(), "10000")
        );
    }

    @Test
    public void ManagerCanFindTop3TotalCalories(){
        String calories = "1000\n" + "2000\n" + "3000\n" + "\n" +
                "4000\n" + "\n" +
                "5000\n" + "6000\n" + "\n" +
                "7000\n" + "8000\n" + "9000\n" + "\n" +
                "10000";
        List<Elf> elves = manager.createElves(calories);
        List<Elf> topElves = manager.getElfMostCalories(elves, 3);
        int sumCalories = manager.sumCalories(topElves);

        assertEquals(sumCalories, 45000);
    }
}