package hr.bp.aoc.day5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import hr.bp.aoc.DaySolution;

public class Day5 extends DaySolution<String, String> {
  public Day5() throws IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "crates.txt";
  }

  @Override
  public String getPart1Solution() {
    int CRATE_ROW_START_OFFSET = 7;
    int CRATE_COL_START_OFFSET = 1;
    int CRATE_GAP = 4;
    int STACK_SIZE = 9;
    List<Stack<Character>> stacks = new ArrayList<>();
    List<String> inputLines = getInputLines();

    for (int i = 0; i < STACK_SIZE; i++) {
      stacks.add(new Stack<>());

      int col = CRATE_COL_START_OFFSET + (CRATE_GAP * i);
      int row = CRATE_ROW_START_OFFSET;
      char crate = '*';

      while (row >= 0) {
        crate = inputLines.get(row).charAt(col);
        if (crate == ' ')
          break;
        stacks.get(i).push(crate);
        row--;
      }
    }

    int ACTIONS_OFFSET = CRATE_ROW_START_OFFSET + 3;

    for (int j = ACTIONS_OFFSET; j < inputLines.size(); j++) {
      String[] words = inputLines.get(j).split(" ");
      int count = Integer.parseInt(words[1]);
      int fromStackIndex = Integer.parseInt(words[3]) - 1;
      int toStackIndex = Integer.parseInt(words[5]) - 1;

      Stack<Character> fromStack = stacks.get(fromStackIndex);
      Stack<Character> toStack = stacks.get(toStackIndex);

      for (int k = 0; k < count; k++) {
        if (!fromStack.empty()) {
          char movingChar = fromStack.pop();
          toStack.push(movingChar);
        }
      }
    }

    StringBuilder wordBuilder = new StringBuilder();

    for (int l = 0; l < STACK_SIZE; l++) {
      if (stacks.get(l).size() > 0)
        wordBuilder.append(stacks.get(l).peek());
    }

    return wordBuilder.toString();
  }

  @Override
  public String getPart2Solution() {
    return "Part 2";
  }
}
