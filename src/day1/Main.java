package day1;

import util.Parser;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String args[]) throws IOException {
        ElfManager manager = new ElfManager();
        String text = Parser.getTextFromFile("Resources/day1Data.txt");
        List<Elf> elves = manager.createElves(text);
        List<Elf> elfMostCalories = manager.getElfMostCalories(elves, 3);

        System.out.println(manager.sumCalories(elfMostCalories));
    }
}
