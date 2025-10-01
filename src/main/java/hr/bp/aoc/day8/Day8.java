package hr.bp.aoc.day8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hr.bp.aoc.DaySolution;

public class Day8 extends DaySolution<Integer, Integer> {
  public Day8() throws IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    List<List<Integer>> trees = new ArrayList<>();

    for (String line : getInputLines()) {
      List<String> stringTreesRow = List.of(line.split(""));
      trees.add(stringTreesRow.stream().map(Integer::parseInt).collect(Collectors.toList()));
    }

    return "treemap.txt";
  }

  @Override
  public Integer getPart1Solution() {
    return 0;
  }

  @Override
  public Integer getPart2Solution() {
    return 0;
  }
}
