package day1;

import util.Parser;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String args[]) throws IOException {
        ElfManager manager = new ElfManager();
        String text = Parser.getTextFromFile("Resources/day1Data.txt");
        List<Elf> elves = manager.createElves(text);

        Elf elfMostCalories = manager.getElfMostCalories(elves);
        int result1 = elfMostCalories.getCalories();
        System.out.println(result1);

        List<Elf> elvesMostCalories = manager.getElfMostCalories(elves, 3);
        int result2 = manager.sumCalories(elvesMostCalories);
        System.out.println(result2);
    }
}
