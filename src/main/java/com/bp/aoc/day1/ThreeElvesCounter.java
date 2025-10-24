package com.bp.aoc.day1;

import java.util.List;
import java.util.Scanner;

public class ThreeElvesCounter {

    /*Scanner to read the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args) {
        int total = 0;

        System.out.println("Enter the name of the file:");
        String nameOfTheFile = scannerFileName.nextLine();

        List<Elf> elves = ElfCaloriesLoader.loadElves(nameOfTheFile);

        /*Printing elves and the number of calories*/
        for (Elf elf : elves) {
            System.out.println(elf);
        }

        ElfCaloriesAnalyzer elfCaloriesAnalyzer = new ElfCaloriesAnalyzer(elves);

        List<Elf> topThreeElves = elfCaloriesAnalyzer.getTopThreeElves();
        /*Calculating the total and printing the first three elves who have the largest number of calories*/
        for (int i = 0; i < topThreeElves.size(); i++) {
            Elf elf = topThreeElves.get(i);
            total += elf.numberOfCalories();
            System.out.println(i + 1 + " elf carrying the most calories is " + elf);
        }

        System.out.println("The top three elves carrying the most calories are in total carrying: " + total);
    }
}