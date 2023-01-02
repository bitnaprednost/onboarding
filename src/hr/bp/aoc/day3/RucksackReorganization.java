package hr.bp.aoc.day3;

import hr.bp.aoc.InputUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RucksackReorganization {


    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day3/inputday3.txt";

        //Part One
        List<String> lines = new ArrayList<>();
        Collections.addAll(lines, InputUtil.readLines(filePath));
        int sumPrioritiesPartOne = PrioritiesUtil.sumOfPrioritiesFirstPart(lines);
        System.out.println(sumPrioritiesPartOne);

        //Part Two
        String[] rucksack = InputUtil.readLines(filePath);
        int sumPrioritiesPartTwo = PrioritiesUtil.sumOfPrioritiesSecondPart(rucksack);
        System.out.println(sumPrioritiesPartTwo);
    }


}