package hr.bp.aoc.days.noSpaceLeftOnDevice;

import hr.bp.aoc.util.ParserUtil;
import hr.bp.aoc.model.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Luka Ljubić
 */
public class DaySeven implements Day {

    Node root;

    {
        try {
            root = parseTerminal(Files.readString(Path.of("src/main/resources/noSpaceLeftOnDeviceData.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void executePartOne() {

        int part1 = root.dirs()
                .filter(n -> n.size() <= 100000)
                .mapToInt(n -> n.size()).sum();
        System.out.printf("part 1: %s\n", part1);

    }

    @Override
    public void executePartTwo() {
        int needed = 30000000 - (70000000 - root.size());
        int part2 = root.dirs()
                .filter(n -> n.size() >= needed)
                .mapToInt(n -> n.size()).sorted().findFirst().getAsInt();
        System.out.printf("part 2: %s\n", part2);
    }

    @Override
    public String getDayOrderNumber() {
        return "Day Seven";
    }

    private Node parseTerminal(String input) {
        Node root = new Node(0, null, new TreeMap<>());
        input.lines().reduce(root, (n, l) -> n.apply(l), (a,b) -> {return null;});
        return root;
    }
}
