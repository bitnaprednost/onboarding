package hr.bp.aoc.day7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

  public void parseLsLine(String line) {
    String prefix = line.split(" ")[0];
    String name = line.split(" ")[1];

    if ("dir".equals(prefix)) {
      children.put(name, new Dir(this, name));
    } else {
      fileSize += Integer.parseInt(prefix);
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
