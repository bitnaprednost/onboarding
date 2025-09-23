package hr.bp.aoc.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import hr.bp.aoc.DaySolution;

public class Day1 extends DaySolution<Integer, Integer> {
  public Day1() throws IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "input.txt";
  }

  @Override
  public Integer getPart1Solution() {
    return getMaxCalories();
  }

  @Override
  public Integer getPart2Solution() {
    return getThreeTotalMaxCalories();
  }

  public int getMaxCalories() {
    return getNthTotalMaxCalories(1);
  }

  public int getThreeTotalMaxCalories() {
    return getNthTotalMaxCalories(3);
  }

  public int getNthTotalMaxCalories(int numberOfCaloriesIncluded) {
    List<Integer> max = new ArrayList<>();
    int currCalories = 0;

    for (String line : getInputLines()) {
      if (line.equals("")) {
        max.add(currCalories);
        max.sort(Comparator.reverseOrder());

        if (max.size() > numberOfCaloriesIncluded) {
          max.remove(numberOfCaloriesIncluded);
        }

        currCalories = 0;
        continue;
      }

      currCalories += Integer.parseInt(line);
    }

    return max.stream().reduce(0, (sum, cal) -> sum + cal);
  }
}
