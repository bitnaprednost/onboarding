package hr.bp.aoc.day7;

import java.util.List;
import java.util.Stack;

public class FileManager {
  private Dir head;

  public FileManager() {
    head = new Dir(null, "/");
  }

  public void createFilesystemFromTerminal(List<String> terminalLines) {
    Dir curr = head;

    int i = 1;
    while (i < terminalLines.size()) {
      curr = operateTerminalLine(terminalLines.get(i), curr);
      i++;
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
