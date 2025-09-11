package hr.bp.aoc.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Day2 {
  private static Path InputPath = Paths.get("src/main/resources/aoc/day2/strategy-guide.txt");
  private Stream<String> inputLines;

  public Day2() throws FileNotFoundException, IOException {
    BufferedReader reader = new BufferedReader(
      new FileReader(new File(InputPath.toString())));
    Stream<String> inputLines = reader.lines();
    Map<String, String> = new HashMap<>();

    reader.close();
  }

  public int getStrategyGuideScore() {

  }

}
