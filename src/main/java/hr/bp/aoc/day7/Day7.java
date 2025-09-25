package hr.bp.aoc.day7;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import hr.bp.aoc.DaySolution;

public class Day7 extends DaySolution<Integer, Integer> {
  public class Dir {
    private Dir parent;
    private int fileSize = 0;
    private int fullSize = -1;
    private Map<String, Dir> children = new HashMap<>();

    public Dir(Dir parent, String name) {
      this.parent = parent;
    }

    public Dir getParent() {
      return parent;
    }

    public Dir getChild(String name) {
      return children.get(name);
    }

    public void parseChildren(List<String> ls) {

      for (String line : ls) {
        String prefix = line.split(" ")[0];
        String name = line.split(" ")[1];

        if ("dir".equals(prefix)) {
          children.put(name, new Dir(this, name));
        } else {
          fileSize += Integer.parseInt(prefix);
        }
      }
    }

    public int getFullSize() {
      if (fullSize != -1)
        return fullSize;

      int dirSize = 0;
      for (Dir child : children.values()) {
        dirSize += child.getFullSize();
      }

      return dirSize + fileSize;
    }

    public Collection<Dir> getChildren() {
      return children.values();
    }
  }

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
