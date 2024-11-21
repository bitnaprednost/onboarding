package hr.bp.aoc.day4;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<String> scratchcards = Utils.readFromFile("inputDay4.txt");

        ScratchcardReader reader = new ScratchcardReader(scratchcards);

        int totalPoints = reader.getTotalPoints();
        System.out.println(totalPoints);
    }
}
