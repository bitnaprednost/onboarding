package hr.bp.aoc.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {
  private static Path InputDataPath = Paths.get("src/main/resources/aoc/day1/input.txt");
  private List<String> inputLines;

  public Day1() throws FileNotFoundException, IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File(InputDataPath.toString())));
    inputLines = reader.lines().toList();
    reader.close();
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

    for (String line : inputLines) {
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
