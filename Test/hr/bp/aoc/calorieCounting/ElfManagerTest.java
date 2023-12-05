package hr.bp.aoc.calorieCounting;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ElfManagerTest {

    @Test
    public void ManagerCanCreateElf(){
        String calorie = "1000";
        Elf elf = ElfManager.createElf(calorie);

        assertEquals(elf.getCalories().toString(), calorie);
    }

    @Test
    public void ManagerConstructorPassesNull(){
        String calorie = null;

        NullPointerException thrown = assertThrows(NullPointerException.class, ()-> {Elf elf = ElfManager.createElf(calorie);});
        assertEquals("String input is null.", thrown.getMessage());
    }

    @Test
    public void ManagerConstructorPassesNonInteger(){
        String calorie = "a";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> {Elf elf = ElfManager.createElf(calorie);});
        assertEquals("Input is empty after filtering. Input is probably invalid.", thrown.getMessage());
    }

    @Test
    public void ManagerConstructorPassesNegative(){
        String calorie = "-1000";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> {Elf elf = ElfManager.createElf(calorie);});
        assertEquals("Food can't contain negative calories.", thrown.getMessage());
    }

//    @Test
//    public void ManagerCanCreateElfWithMultipleFood(){
//        String calories = "1000\n" + "2000\n" + "3000";
//        Elf elf = ElfManager.createElf(calories);
//
//        ElfVisitor elfVisitor = new ElfVisitor();
//        elf.accept(elfVisitor);
//
//        assertAll(
//                "Has all calories",
//                () -> assertEquals(elfVisitor.visitElf(elf), 1000),
//                () -> assertEquals(elfVisitor.visitElf(elf), 2000),
//                () -> assertEquals(elfVisitor.visitElf(elf), 3000)
//        );
//    }

//    @Test
//    public void ManagerConstructorPassesMultipleElves(){
//        String calories = "1000\n" + "2000\n" + "3000\n" + "\n"
//                            + "4000\n" + "\n"
//                            + "5000\n" + "6000";
//        List<Elf> elves = ElfManager.createElves(calories);
//
//        assertAll(
//                "Has all elves",
//                () -> assertEquals(elves.size(), 3),
//                () -> assertEquals(elves.get(0).getFood(0).getCalories().toString(), "1000"),
//                () -> assertEquals(elves.get(0).getFood(1).getCalories().toString(), "2000"),
//                () -> assertEquals(elves.get(0).getFood(2).getCalories().toString(), "3000"),
//                () -> assertEquals(elves.get(1).getFood(0).getCalories().toString(), "4000"),
//                () -> assertEquals(elves.get(2).getFood(0).getCalories().toString(), "5000"),
//                () -> assertEquals(elves.get(2).getFood(1).getCalories().toString(), "6000")
//        );
//    }

    @Test
    public void ManagerCanFindElfWithMostCalories(){
        String calories = "1000\n" + "2000\n" + "3000\n" + "\n"
                + "4000\n" + "\n"
                + "5000\n" + "6000";
        List<Elf> elves = ElfManager.createElves(calories);
        Elf topElf = ElfManager.getElfMostCalories(elves);

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
        List<Elf> elves = ElfManager.createElves(calories);
        List<Elf> topElves = ElfManager.getElfMostCalories(elves, 3);

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
        List<Elf> elves = ElfManager.createElves(calories);
        List<Elf> topElves = ElfManager.getElfMostCalories(elves, 3);
        int sumCalories = ElfManager.sumCalories(topElves);

        assertEquals(sumCalories, 45000);
    }
}