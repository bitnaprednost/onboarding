package hr.bp.aoc.day4;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> scratchcards = Utils.readFromFile("inputDay4.txt");

        ScratchcardReader reader = new ScratchcardReader(scratchcards);

        int numOfStrachcards = reader.getNumbOfScratchcards();
        System.out.println(numOfStrachcards);
    }
}
