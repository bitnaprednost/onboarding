package hr.bp.aoc;

import java.io.FileNotFoundException;

import hr.bp.aoc.day1.Day1;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Day1 day1Solution = new Day1();

    System.out.println("Solution is: " + day1Solution.getMaxCalories());
    System.out.println("Part two solution is: " + day1Solution.getMaxThreeCaloriesTotal());
  }
}
