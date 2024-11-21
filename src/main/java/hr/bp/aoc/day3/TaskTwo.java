package hr.bp.aoc.day3;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> schmetic = Utils.readFromFile("inputDay3.txt");

        EngineSchematicReader reader = new EngineSchematicReader(schmetic);
        int sum = reader.getSumGearRatios();

        System.out.println(sum);
    }
}
