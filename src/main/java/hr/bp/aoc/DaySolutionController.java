package hr.bp.aoc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import hr.bp.aoc.day1.Day1;
import hr.bp.aoc.day2.Day2;
import hr.bp.aoc.day3.Day3;
import hr.bp.aoc.day4.Day4;
import hr.bp.aoc.day5.Day5;
import hr.bp.aoc.day6.Day6;
import hr.bp.aoc.day7.Day7;
import hr.bp.aoc.day8.Day8;

public class DaySolutionController {
  private List<DaySolution<? extends Object, ? extends Object>> solutions;

  public DaySolutionController() throws IOException {
    solutions = Arrays.asList(new Day1(), new Day2(), new Day3(),
        new Day4(), new Day5(), new Day6(), new Day7(), new Day8());
  }

  public void printAllSolutions() {
    for (int i = 0; i < solutions.size(); i++) {
      DaySolution<? extends Object, ? extends Object> currDay = solutions.get(i);

      System.out.println(String.format("----Day %s----", i + 1));
      System.out.println(String.format("Part 1 solution: %s", currDay.getPart1Solution()));
      System.out.println(String.format("Part 2 solution: %s", currDay.getPart2Solution()));
      System.out.println();
    }
  }
}
