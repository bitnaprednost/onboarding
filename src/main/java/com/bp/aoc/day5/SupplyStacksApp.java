package com.bp.aoc.day5;

import com.bp.aoc.util.ContentLoader;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Ivona Pavela
 */

public class SupplyStacksApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select mode:\n" +
                "[1] find what crate ends up on top of each stack if crates are moved one at a time\n" +
                "[2] find what crate ends up on top of each stack if moved crates stay in the same order\n ");
        String mode = scanner.nextLine().trim().toLowerCase();

        List<String> lines = ContentLoader.loadContent("day5.txt");

        int indexOfBlankLine = getIndexOfBlankLine(lines);

        List<String> stackLines = lines.subList(0, indexOfBlankLine);
        List<String> rearrangementProcedure = lines.subList(indexOfBlankLine + 1, lines.size());

        CratesInStacks.storingCratesInStacks(stackLines);
        Map<Integer, Deque<Character>> stacksOfCrates = CratesInStacks.getStacksOfCrates();


        switch (mode) {
            case "1" -> RearrangementProcedure.rearrangeCratesOneByOne(rearrangementProcedure, stacksOfCrates);
            case "2" -> RearrangementProcedure.rearrangeCratesInOrder(rearrangementProcedure, stacksOfCrates);
            default -> System.out.println("Invalid mode");
        }
    }

    public static int getIndexOfBlankLine(List<String> lines){
        for(String line : lines){
            if(line.trim().isEmpty()) {
                return lines.indexOf(line);
            }
        }
        return -1;
    }
}
