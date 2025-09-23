package hr.bp.aoc.day5;

import java.io.IOException;
import java.util.List;

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

    int ACTIONS_OFFSET = CRATE_ROW_START_OFFSET + 3;

    Crane.moveCrates(inputLines.subList(ACTIONS_OFFSET, inputLines.size()), ship);

    return ship.getTopCrates();
  }

  @Override
  public String getPart2Solution() {
    return "Part 2";
  }
}
