package hr.bp.aoc.day7;

import java.util.List;
import java.util.Stack;

public class FileManager {
  private static int TOTAL_DISK_SPACE = 70000000;
  private static int MIN_UPDATE_SIZE = 30000000;
  private Dir head;

  public FileManager() {
    head = new Dir(null);
  }

  public void createFilesystemFromTerminal(List<String> terminalLines) {
    Dir curr = head;

    for (int i = 1; i < terminalLines.size(); i++) {
      curr = operateTerminalLine(terminalLines.get(i), curr);
    }
  }

  public int sumOfSizesSmallerThan100000() {
    int sum = 0;
    Stack<Dir> stack = new Stack<>();
    stack.push(head);
    while (!stack.empty()) {
      Dir currCandidate = stack.pop();
      if (currCandidate.getFullSize() <= 100000)
        sum += currCandidate.getFullSize();
      for (Dir child : currCandidate.getChildren()) {
        stack.push(child);
      }
    }

    return sum;
  }

  public int sizeOfSmallesDirNeededToDelete() {
    Stack<Dir> stack = new Stack<>();
    stack.push(head);

    int currMinSize = Integer.MAX_VALUE;
    int neededSpace = Math.min(MIN_UPDATE_SIZE, MIN_UPDATE_SIZE - (TOTAL_DISK_SPACE - head.getFullSize()));

    while (!stack.empty()) {
      Dir currCandidate = stack.pop();
      int currDirSize = currCandidate.getFullSize();
      if (currDirSize > neededSpace) {
        currMinSize = Math.min(currMinSize, currDirSize);
        for (Dir child : currCandidate.getChildren()) {
          stack.push(child);
        }
      }
    }

    return currMinSize;
  }

  public static Dir operateTerminalLine(String line, Dir curr) {
    String[] splited = line.split(" ");

    boolean isCommand = "$".equals(splited[0]);

    if (isCommand) {
      boolean isCd = "cd".equals(splited[1]);
      if (!isCd)
        return curr;
      curr = operateCd(curr, splited[2]);
    } else {
      curr.parseLsLine(line);
    }

    return curr;
  }

  public static Dir operateCd(Dir curr, String destination) {
    boolean isReturning = "..".equals(destination);
    if (isReturning) {
      curr = curr.getParent();
    } else {
      curr = curr.getChild(destination);
    }

    return curr;
  }
}
