package hr.bp.aoc2024.day9;

import java.util.ArrayList;
import java.util.List;

public class DiskParser {
    List<String> input;

    public DiskParser(List<String> input) {
        this.input = input;
    }

    public List<DiskMap> parseInput() {
        List<DiskMap> parsedInput = new ArrayList<>();
        int idCounter = 0;

        String[] splitInput = input.get(0).split("");

        for (int fileIndex = 0; fileIndex < splitInput.length; fileIndex += 2) {
            int numOfFileSpaces = Integer.parseInt(splitInput[fileIndex]);
            int numFreeSpaces = fileIndex == splitInput.length - 1 ? 0 : Integer.parseInt(splitInput[fileIndex + 1]);

            parsedInput.add(new DiskMap(idCounter++, numOfFileSpaces, numFreeSpaces));
        }

        return parsedInput;
    }
}
