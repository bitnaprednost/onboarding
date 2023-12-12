package hr.bp.aoc.calorie.counting;

import hr.bp.aoc.util.Parser;

import java.io.IOException;
import java.util.List;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String text = Parser.getTextFromFile("Resources/day1Data.txt");
        List<Elf> elves = ElfManager.createElves(text);

        Elf elfMostCalories = ElfManager.getElfMostCalories(elves);
        int result1 = elfMostCalories.getCalories();
        System.out.println(result1);

        List<Elf> elvesMostCalories = ElfManager.getElfMostCalories(elves, 3);
        int result2 = ElfManager.sumCalories(elvesMostCalories);
        System.out.println(result2);
    }
}
