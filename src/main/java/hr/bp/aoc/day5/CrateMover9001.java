package hr.bp.aoc.day5;

import java.util.LinkedList;

public class CrateMover9001 extends Crane {
  @Override
  protected <T> void moveCrate(int count, int fromStackIndex, int toStackIndex, StackList<T> stackList) {
    LinkedList<T> linkedList = new LinkedList<>();

    for (int i = 0; i < count; i++) {
      T movingItem = stackList.getStacks().get(fromStackIndex).pop();
      linkedList.add(movingItem);
    }

    while (linkedList.size() > 0) {
      stackList.getStacks().get(toStackIndex).push(linkedList.removeLast());
    }
  }

}
