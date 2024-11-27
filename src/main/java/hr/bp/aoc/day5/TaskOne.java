package hr.bp.aoc.day5;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("inputDay5.txt");

        AlmanacReader almanacReader = new AlmanacReader(document);
        almanacReader.getNearestLocation();

    }
}
