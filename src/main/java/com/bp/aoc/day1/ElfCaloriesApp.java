package com.bp.aoc.day1;

import java.util.List;
import java.util.Scanner;

/**
 * @author Monika Kušter
 */
public class ElfCaloriesApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select mode: [1] for maximum calories elf, [2] for top three elves");
        String mode = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter the name of the file:");
        String fileName = scanner.nextLine();

        List<Elf> elves = ElfCaloriesLoader.loadElves(fileName);

        for (Elf elf : elves) {
            System.out.println(elf);
        }
        ElfCaloriesAnalyzer elfCaloriesAnalyzer = new ElfCaloriesAnalyzer(elves);

        switch (mode) {
            case "1" -> {
                System.out.println("The elf with maximum number of calories is " + elfCaloriesAnalyzer.getMaximumCaloriesElf());
                break;
            }
            case "2" -> {
                List<Elf> topThreeElves = elfCaloriesAnalyzer.getTopThreeElves();
                int total = 0;

                for (int i = 0; i < topThreeElves.size(); i++) {
                    Elf elf = topThreeElves.get(i);
                    total += elf.numberOfCalories();
                    System.out.println(i + 1 + " elf carrying the most calories is " + elf);
                }

                System.out.println("The top three elves carrying the most calories are in total carrying: " + total);
            }
            default -> {
                System.out.println("Invalid mode");
            }
        }
    }
}
