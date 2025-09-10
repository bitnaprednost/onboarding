package hr.bp.aoc.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Day1 {
  private static String DATA_RELATIVE_PATH = "../../../../../resources/aoc/day1/input.txt";
  private BufferedReader reader;

  public Day1() {
    try {
      this.reader = new BufferedReader(new FileReader(DATA_RELATIVE_PATH));
    } catch (FileNotFoundException e) {
      System.out.println("Please enter valid path.");
    }
  }

  public int getMaxCalories() {
    int max = 0;
    int currCalories = 0;

    List<String> lines = reader.lines().toList();

    for (String line : lines) {
      if (line.equals("")) {
        max = Math.max(max, currCalories);
        currCalories = 0;
        continue;
      }

      currCalories += Integer.parseInt(line);
    }

    return max;
  }
}
