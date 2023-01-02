package hr.bp.aoc.day1;

import hr.bp.aoc.InputUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {
    public static void main(String[] args) {

        String filePath = "src/hr/bp/aoc/day1/inputday1.txt";

        List<String> lines = new ArrayList<>();

        Collections.addAll(lines, InputUtil.readLines(filePath));

        List<Integer> sumGroups = totalCaloriesCarriedByEachElf(lines);

        //Part One
        int maxCalories = maxCaloriesCarrying(sumGroups);
        System.out.println("Elf is carrying " + maxCalories + " calories.");

        //Part Two
        int sumOfTopThreeElves = sumOfThreeElves(sumGroups);
        System.out.println("Top three Elves are carrying " + sumOfTopThreeElves + " calories");


    }

    private static List<Integer> totalCaloriesCarriedByEachElf(List<String> lines) {
        int sumCalories = 0;
        List<Integer> sumGroups = new ArrayList<>();
        for (String line : lines) {
            if (line.isBlank()) {
                sumGroups.add(sumCalories);
                sumCalories = 0;
                continue;
            }
            sumCalories += Integer.parseInt(line);
        }
        sumGroups.add(sumCalories);
        return sumGroups;
    }

    private static int maxCaloriesCarrying(List<Integer> sumGroups) {
        int maxCalories = 0;
        for (Integer sumGroup : sumGroups) {
            if (maxCalories < sumGroup) {
                maxCalories = sumGroup;
            }
        }
        return maxCalories;
    }

    private static int sumOfThreeElves(List<Integer> sumGroups) {
        sumGroups.sort(Collections.reverseOrder());
        return sumGroups.get(0) + sumGroups.get(1) + sumGroups.get(2);
    }
}