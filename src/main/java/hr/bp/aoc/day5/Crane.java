package hr.bp.aoc.day5;

import java.util.List;

public class Crane {
  private static int COUNT_INDEX_SPLIT = 1;
  private static int FROM_STACK_INDEX_SPLIT = 3;
  private static int TO_STACK_INDEX_SPLIT = 5;

  public static void moveCrates(List<String> actions, Ship ship) {
    for (int i = 0; i < actions.size(); i++) {
      String[] words = actions.get(i).split(" ");
      int count = Integer.parseInt(words[COUNT_INDEX_SPLIT]);
      int fromStackIndex = Integer.parseInt(words[FROM_STACK_INDEX_SPLIT]) - 1;
      int toStackIndex = Integer.parseInt(words[TO_STACK_INDEX_SPLIT]) - 1;

      moveCrate(count, fromStackIndex, toStackIndex, ship);
    }
  }

  public static void moveCrate(int count, int fromStackIndex, int toStackIndex, Ship ship) {
    for (int i = 0; i < count; i++) {
      char movingChar = ship.getStacks().get(fromStackIndex).pop();
      ship.getStacks().get(toStackIndex).push(movingChar);
    }
  }
}
