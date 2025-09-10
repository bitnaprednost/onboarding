package hr.bp.aoc.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;

public class Day1 {
  private static Path InputDataPath = Paths.get("src/main/resources/aoc/day1/input.txt");
  private BufferedReader reader;

  public Day1() throws FileNotFoundException {
    this.reader = new BufferedReader(new FileReader(new File(InputDataPath.toString())));
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
