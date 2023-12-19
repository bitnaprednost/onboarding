package hr.bp.aoc.days.noSpaceLeftOnDevice;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public record Node(int size, Node parent, Map<String, Node> nodes) {

    static Pattern filePattern = Pattern.compile("(\\d+) ([\\w.]+)");

    Node apply(String line) {
        if (line.startsWith("$ cd ")) {
            return cd(line.substring(5));
        }
        Matcher fileMatcher = filePattern.matcher(line);
        if (fileMatcher.matches()) {
            return add(fileMatcher.group(2), fileMatcher.group(1));
        }
        return this;
    }

    Node cd(String name) {
        return switch (name) {
            case "/" -> parent == null ? this : parent.cd("/");
            case ".." -> parent;
            default -> nodes.computeIfAbsent(name, k -> new Node(0, this, new TreeMap<>()));
        };
    }

    Node add(String name, String size) {
        nodes.put(name, new Node(Integer.parseInt(size), this, new TreeMap<>()));
        return this;
    }

    Stream<Node> dirs() {
        return Stream.concat(Stream.of(this), nodes.values().stream().flatMap(Node::dirs)
                .filter(n -> n.size == 0));
    }

    public int size() {
        return size > 0 ? size : nodes.values().stream().mapToInt(Node::size).sum();
    }
}
