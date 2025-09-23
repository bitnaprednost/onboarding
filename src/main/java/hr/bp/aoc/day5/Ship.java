package hr.bp.aoc.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ship {
  private static int STACK_NUMBER = 9;
  private static int CRATE_GAP = 4;
  private static int CRATE_COL_START_OFFSET = 1;
  private List<Stack<Character>> stacks = new ArrayList<>();

  public Ship() {
  }

  public static Ship parseShip(List<String> shipAsString) {
    Ship ship = new Ship();
    int maxStackSize = shipAsString.size() - 1;

    for (int i = 0; i < STACK_NUMBER; i++) {
      ship.stacks.add(new Stack<>());

      int col = CRATE_COL_START_OFFSET + (CRATE_GAP * i);
      int row = maxStackSize;
      char crate = '*';

      while (row >= 0) {
        crate = shipAsString.get(row).charAt(col);
        if (crate == ' ')
          break;
        ship.stacks.get(i).push(crate);
        row--;
      }
    }

    return ship;
  }

  public List<Stack<Character>> getStacks() {
    return stacks;
  }

  public String getTopCrates() {
    StringBuilder wordBuilder = new StringBuilder();

    for (int l = 0; l < STACK_NUMBER; l++) {
      if (stacks.get(l).size() > 0)
        wordBuilder.append(stacks.get(l).peek());
    }

    return wordBuilder.toString();
  }
}
