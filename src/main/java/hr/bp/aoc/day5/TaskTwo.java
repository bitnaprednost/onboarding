package hr.bp.aoc.day5;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("inputDay5.txt");

        AlmanacReader almanacReader = new AlmanacReader(document);
        long nearestLocation = almanacReader.getNearestLocationRange();
        System.out.println(nearestLocation);
    }
}
