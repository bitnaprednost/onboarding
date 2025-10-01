package hr.bp.aoc.day8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import hr.bp.aoc.DaySolution;
import hr.bp.aoc.utils.Pair;

public class Day8 extends DaySolution<Integer, Integer> {
  public Day8() throws IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "treemap.txt";
  }

  @Override
  public Integer getPart1Solution() {
    List<List<Integer>> trees = new ArrayList<>();

    for (String line : getInputLines()) {
      List<String> stringTreesRow = List.of(line.split(""));
      trees.add(stringTreesRow.stream().map(Integer::parseInt).collect(Collectors.toList()));
    }

    Set<Pair<Integer>> foundVisible = new HashSet<>();
    for (int r = 0; r < trees.size(); r++) {
      int prevHeighest = Integer.MIN_VALUE;

      for (int c = 0; c < trees.get(0).size(); c++) {
        if (trees.get(r).get(c) > prevHeighest) {
          foundVisible.add(new Pair<Integer>(r, c));
        }
      }

      prevHeighest = Integer.MIN_VALUE;
      for (int c = trees.get(0).size() - 1; c >= 0; c--) {
        if (trees.get(r).get(c) > prevHeighest) {
          foundVisible.add(new Pair<Integer>(r, c));
        }
      }
    }

    for (int c = 0; c < trees.get(0).size(); c++) {
      int prevHeighest = Integer.MIN_VALUE;

      for (int r = 0; r < trees.size(); r++) {
        if (trees.get(r).get(c) > prevHeighest) {
          foundVisible.add(new Pair<Integer>(r, c));
        }
      }

      prevHeighest = Integer.MIN_VALUE;
      for (int r = trees.size() - 1; r >= 0; r--) {
        if (trees.get(r).get(c) > prevHeighest) {
          foundVisible.add(new Pair<Integer>(r, c));
        }
      }
    }

    return 0;
  }

  @Override
  public Integer getPart2Solution() {
    return 0;
  }
}
