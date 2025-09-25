package hr.bp.aoc.day7;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import hr.bp.aoc.DaySolution;

public class Day7 extends DaySolution<Integer, Integer> {
  public Day7() throws IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "filesystem.txt";
  }

  @Override
  public Integer getPart1Solution() {
    Dir head = new Dir(null, "/");
    Dir curr = head;

    List<String> lines = getInputLines();
    int i = 1;
    while (i < lines.size()) {
      String[] splited = lines.get(i).split(" ");

      boolean isCommand = "$".equals(splited[0]);

      if (isCommand) {
        boolean isCd = "cd".equals(splited[1]);
        if (isCd) {
          String destination = splited[2];
          boolean isReturning = "..".equals(destination);
          if (isReturning) {
            curr = curr.getParent();
          } else {
            curr = curr.getChild(destination);
          }
        } else {
          i++;
          int startingDirIndex = i;
          boolean isEndOfDirLs;
          do {
            i++;
            isEndOfDirLs = i == lines.size() || "$".equals(lines.get(i).split(" ")[0]);
          } while (!isEndOfDirLs);

          curr.parseChildren(lines.subList(startingDirIndex, i));
          i--;
        }
      }

      i++;
    }

    int res = 0;
    Stack<Dir> stack = new Stack<>();
    stack.push(head);
    while (!stack.empty()) {
      Dir currCounting = stack.pop();
      if (currCounting.getFullSize() <= 100000)
        res += currCounting.getFullSize();
      for (Dir child : currCounting.getChildren()) {
        stack.push(child);
      }
    }

    return res;
  }

  @Override
  public Integer getPart2Solution() {
    return 0;
  }
}
