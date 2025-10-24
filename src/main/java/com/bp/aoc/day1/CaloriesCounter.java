package com.bp.aoc.day1;

import java.util.List;
import java.util.Scanner;

public class CaloriesCounter {

    /*Scanner to read the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the name of the file:");
        String nameOfTheFile = scannerFileName.nextLine();

        List<Elf> elves = ElfCaloriesLoader.loadElves(nameOfTheFile);

        /*Printing elves and the number of calories*/
        for (Elf elf : elves) {
            System.out.println(elf);
        }

        /*Printing the elf with the maximum number of calories*/
        System.out.println("The elf with maximum number of calories is " + getMaximumCaloriesElf(elves));
    }

    private static Elf getMaximumCaloriesElf(List<Elf> elves) {
        Elf maximumCaloriesElf = elves.get(0);

        for (Elf elf : elves) {
            if (elf.numberOfCalories() >= maximumCaloriesElf.numberOfCalories()) {
                maximumCaloriesElf = elf;
            }
        }

        return maximumCaloriesElf;
    }
}

