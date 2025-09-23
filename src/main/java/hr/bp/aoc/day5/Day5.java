package hr.bp.aoc.day5;

import java.io.IOException;
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
    List<String> inputLines = getInputLines();
    Ship ship = Ship.parseShip(inputLines.subList(0, CRATE_ROW_START_OFFSET + 1));

    List<Stack<Character>> stacks = ship.getStacks();

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

    return ship.getTopCrates();
  }

  @Override
  public String getPart2Solution() {
    return "Part 2";
  }
}
