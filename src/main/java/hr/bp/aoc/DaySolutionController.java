package hr.bp.aoc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import hr.bp.aoc.day1.Day1;
import hr.bp.aoc.day2.Day2;
import hr.bp.aoc.day3.Day3;

public class DaySolutionController {
  private List<DaySolution> solutions;

  public DaySolutionController() throws FileNotFoundException, IOException {
    solutions = Arrays.asList(new Day1(), new Day2(), new Day3());
  }

  public void printAllSolutions() {
    for (int i = 0; i < solutions.size(); i++) {
      DaySolution currDay = solutions.get(i);

      System.out.println(String.format("----Day %d----", i + 1));
      System.out.println(String.format("Part 1 solution: %d", currDay.getPart1Solution()));
      System.out.println(String.format("Part 2 solution: %d", currDay.getPart2Solution()));
      System.out.println();
    }
  }
}
