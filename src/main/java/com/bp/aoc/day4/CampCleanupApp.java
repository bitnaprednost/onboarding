package com.bp.aoc.day4;

import com.bp.aoc.util.ContentLoader;

import java.util.List;
import java.util.Scanner;

/**
 * @author Ivona Pavela
 */


public class CampCleanupApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select mode:\n" +
                "[1] find in how many assignment pairs does one range fully contain the other\n" +
                "[2] find in how many assignment pairs do the ranges overlap\n ");
        String mode = scanner.nextLine().trim().toLowerCase();

        List<String> lines = ContentLoader.loadContent("day4.txt");

        switch (mode) {
            case "1" -> System.out.println("One range fully contains the other in "
                    + CheckAssignments.checkAssignments(lines, true)
                    + " assignments");
            case "2" -> System.out.println("Ranges overlap in "
                    + CheckAssignments.checkAssignments(lines, false)
                    + " assignments");
            default -> System.out.println("Invalid mode");
        }
    }
}
