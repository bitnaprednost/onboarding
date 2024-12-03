package hr.bp.aoc2024.day2;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("aoc2024/inputDay2.txt");
        ReportsParser parser = new ReportsParser(document);
        NuclearPlant nuclearPlant = new NuclearPlant(parser.parseInput(), true);

        System.out.println(nuclearPlant.getNumOfSafeReports());
    }
}
