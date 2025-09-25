package hr.bp.aoc.day7;

import java.io.IOException;

import hr.bp.aoc.DaySolution;

public class Day7 extends DaySolution<Integer, Integer> {
  private FileManager fileManager = new FileManager();

  public Day7() throws IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "filesystem.txt";
  }

  @Override
  public Integer getPart1Solution() {
    fileManager.createFilesystemFromTerminal(getInputLines());

    return fileManager.sumOfSizesSmallerThan100000();
  }

  @Override
  public Integer getPart2Solution() {
    fileManager.createFilesystemFromTerminal(getInputLines());

    return fileManager.sizeOfSmallesDirNeededToDelete();
  }
}
