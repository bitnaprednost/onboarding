package hr.bp.aoc.day5.cranes;

import java.util.List;

import hr.bp.aoc.day5.StackList;

public abstract class Crane {
  private static int COUNT_INDEX_SPLIT = 1;
  private static int FROM_STACK_INDEX_SPLIT = 3;
  private static int TO_STACK_INDEX_SPLIT = 5;

  public <T> void moveCrates(List<String> actions, StackList<T> stackList) {
    for (int i = 0; i < actions.size(); i++) {
      String[] words = actions.get(i).split(" ");
      int count = Integer.parseInt(words[COUNT_INDEX_SPLIT]);
      int fromStackIndex = Integer.parseInt(words[FROM_STACK_INDEX_SPLIT]) - 1;
      int toStackIndex = Integer.parseInt(words[TO_STACK_INDEX_SPLIT]) - 1;

      moveCrate(count, fromStackIndex, toStackIndex, stackList);
    }
  }

  protected abstract <T> void moveCrate(int count, int fromStackIndex, int toStackIndex, StackList<T> stackList);
}
