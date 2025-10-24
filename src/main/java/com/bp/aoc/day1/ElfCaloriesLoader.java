package com.bp.aoc.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Monika Kušter
 */
public class ElfCaloriesLoader {

    public static List<Elf> loadElves(String fileName) {
        List<Elf> elves = new ArrayList<>();

        int calories = 0;
        int counter = 1;

        try (Scanner scanner = new Scanner(ElfCaloriesLoader.class.getClassLoader().getResourceAsStream(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (!line.isEmpty()) {
                    calories += Integer.parseInt(line);
                } else {
                    addElf(elves, counter, calories);
                    counter++;
                    calories = 0;
                }
            }

            addElf(elves, counter, calories);

        } catch (Exception e) {
            throw new RuntimeException("Error loading elves from file: " + e.getMessage(), e);
        }

        return elves;
    }

    private static void addElf(List<Elf> elves, int counter, int calories) {
        if (calories > 0) {
            elves.add(new Elf(counter, calories));
        }
    }
}
