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
    return getTopCrates(new CrateMover9000());
  }

  @Override
  public String getPart2Solution() {
    return getTopCrates(new CrateMover9001());
  }

  public String getTopCrates(Crane crane) {
    int CRATE_ROW_START_OFFSET = 7;
    List<String> inputLines = getInputLines();
    List<String> shipString = inputLines.subList(0, CRATE_ROW_START_OFFSET + 1);
    Ship ship = Ship.parseShip(shipString);

    int ACTIONS_OFFSET = CRATE_ROW_START_OFFSET + 3;

    List<String> actionsString = inputLines.subList(ACTIONS_OFFSET, inputLines.size());
    crane.moveCrates(actionsString, ship);

    return ship.getTopCrates();
  }
}
