package hr.bp.aoc2024.day1;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("aoc2024/inputDay1.txt");

        ListParser parser = new ListParser(document);

        LocationList locationList = new LocationList(parser.parseInput());

        System.out.println(locationList.getTotalDistance());
    }
}
