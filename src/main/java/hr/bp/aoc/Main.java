package hr.bp.aoc;

import java.io.FileNotFoundException;
import java.io.IOException;

import hr.bp.aoc.day1.Day1;
import hr.bp.aoc.day2.Day2;
import hr.bp.aoc.day3.Day3;

public class Main {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    Day1 day1Solution = new Day1();
    Day2 day2Solution = new Day2();
    Day3 day3Solution = new Day3();

    System.out.println("---DAY 1---");
    System.out.println("Solution is: " + day1Solution.getMaxCalories());
    System.out.println("Part two solution is: " + day1Solution.getThreeTotalMaxCalories());

    System.out.println("---DAY 2---");
    System.out.println("Solution is: " + day2Solution.getStrategyGuideScore());
    System.out.println("Part two solution is: " + day2Solution.getRightStrategyGuideScore());

    System.out.println("---DAY 3---");
    System.out.println("Solution is: " + day3Solution.getBothCompartmentsPrioritySum());
    System.out.println("Part two solution is: " + day3Solution.getBadgesPrioritySum());

  }
}
