package com.bp.aoc.day3;

import com.bp.aoc.util.ContentLoader;

import java.util.List;
import java.util.Scanner;

/**
 * @author Ivona Pavela
 */


public class ReorganizationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumOfPriorities = 0;

        System.out.print("Select mode:\n[1] find the item type that appears in both compartments of each rucksack\n[2] find the item type that corresponds to the badges of each three-Elf group\n ");
        String mode = scanner.nextLine().trim().toLowerCase();

        List<String> lines = ContentLoader.loadContent("day3.txt");

        switch (mode) {
            case "1" -> {
                for (String line : lines) {
                    int mid = line.length() / 2;
                    sumOfPriorities += Reorganization.reorganization(line.substring(0, mid), line.substring(mid));
                }
            }
            case "2" -> {
                for (int i = 0; i < lines.size(); i += 3) {
                    if (i + 2 < lines.size()) {
                        sumOfPriorities += Reorganization.reorganization(
                                lines.get(i),
                                lines.get(i + 1),
                                lines.get(i + 2)
                        );
                    }
                }
            }
            default -> System.out.println("Invalid mode");
        }

        System.out.println("Sum of priorities of those items is " + sumOfPriorities);
    }
}
