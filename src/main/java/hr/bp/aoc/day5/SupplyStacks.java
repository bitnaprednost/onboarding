package hr.bp.aoc.day5;

import hr.bp.aoc.InputUtil;

import java.nio.file.Path;
import java.util.*;
import java.util.Collections;

import static hr.bp.aoc.day5.CratesUtil.*;

public class SupplyStacks {

    public static void main(String[] args) throws Exception {

        Path inputFilePath = InputUtil.getPath(SupplyStacks.class, "inputday5.txt");
        Path filePath = inputFilePath.toAbsolutePath();

        String[] input = InputUtil.readLines(filePath);

        List<String> crates = new ArrayList<>();
        List<String> moves = new ArrayList<>();

        int heightOfStack = 0;
        for (String line : input) {
            if (line.contains("[")) {
                crates.add(line);
                heightOfStack++;
            } else if (line.contains("move")) {
                moves.add(line);
            }
        }

        int numberOfStacks = countNumberOfStacks(input, heightOfStack);

        Collections.reverse(crates);
        List<Stack<Character>> stacksPart1 = createStacks(crates, numberOfStacks);
        List<Stack<Character>> stacksPart2 = createStacks(crates, numberOfStacks);

        moveCratesPartOneAndTwo(moves, stacksPart1, stacksPart2);

        printTopCrates(stacksPart1);
        printTopCrates(stacksPart2);

    }


}