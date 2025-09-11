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
    int max = 0;
    int currCalories = 0;

    for (String line : inputLines) {
      if (line.equals("")) {
        max = Math.max(max, currCalories);
        currCalories = 0;
        continue;
      }

      currCalories += Integer.parseInt(line);
    }

    return max;
  }

  public int getMaxThreeCaloriesTotal() {
    List<Integer> top3 = new ArrayList<>();
    int currCalories = 0;

    for (String line : inputLines) {
      if (line.equals("")) {
        top3.add(currCalories);
        top3.sort(Comparator.reverseOrder());

        if (top3.size() > 3) {
          top3.remove(3);
        }

        currCalories = 0;
        continue;
      }

      currCalories += Integer.parseInt(line);
    }

    return top3.stream().reduce(0, (sum, cal) -> sum + cal);
  }
}
