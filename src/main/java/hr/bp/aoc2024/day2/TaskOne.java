package hr.bp.aoc2024.day2;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("aoc2024/inputDay2.txt");
        ReportsParser parser = new ReportsParser(document);
        NuclearPlant nuclearPlant = new NuclearPlant(parser.parseInput());

        System.out.println(nuclearPlant.getNumOfSafeReports());
    }
}
