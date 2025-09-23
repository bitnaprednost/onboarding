package hr.bp.aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class DaySolution {
  private static final String COMMON_PATH_PARENT_DIR = "src/main/resources/aoc/";
  private Path inputPath = Paths.get(
      String.format("%s/%s/%s",
          COMMON_PATH_PARENT_DIR,
          getClass().getSimpleName().toLowerCase(),
          getInputFileName()));

  private List<String> inputLines;

  public DaySolution() throws IOException {
    BufferedReader reader = new BufferedReader(
        new FileReader(new File(inputPath.toString())));
    inputLines = reader.lines().toList();
    reader.close();
  }

  protected List<String> getInputLines() {
    return inputLines;
  }

  public abstract int getPart1Solution();

  public abstract int getPart2Solution();

  public abstract String getInputFileName();
}
