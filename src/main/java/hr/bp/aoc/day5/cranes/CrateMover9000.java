package hr.bp.aoc.day5.cranes;

import hr.bp.aoc.day5.StackList;

public class CrateMover9000 extends Crane {
  @Override
  protected <T> void moveCrate(int count, int fromStackIndex, int toStackIndex, StackList<T> stackList) {
    for (int i = 0; i < count; i++) {
      T movingItem = stackList.getStacks().get(fromStackIndex).pop();
      stackList.getStacks().get(toStackIndex).push(movingItem);
    }
  }

}
