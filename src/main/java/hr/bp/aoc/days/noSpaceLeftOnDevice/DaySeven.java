package hr.bp.aoc.days.noSpaceLeftOnDevice;

import hr.bp.aoc.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeMap;

/**
 * @author Luka Ljubić
 */
public class DaySeven implements Day {

    public static final Logger logger = LoggerFactory.getLogger(DaySeven.class);
    Node root;

    {
        try {
            root = parseTerminal(Files.readString(Path.of("src/main/resources/noSpaceLeftOnDeviceData.txt")));
        } catch (IOException e) {
            logger.error("root cannot be parsed from path");
        }
    }

    @Override
    public void executePartOne() {

        int part1 = root.dirs()
                .filter(n -> n.size() <= 100000)
                .mapToInt(n -> n.size()).sum();

        logger.info("noSpaceLeftOnDevice PART 1: {}", part1);

    }

    @Override
    public void executePartTwo() {
        int needed = 30000000 - (70000000 - root.size());
        int part2 = root.dirs()
                .filter(n -> n.size() >= needed)
                .mapToInt(n -> n.size()).sorted().findFirst().getAsInt();

        logger.info("noSpaceLeftOnDevice PART 2: {}", part2);
    }

    @Override
    public String getDayOrderNumber() {
        return "Day Seven";
    }

    private Node parseTerminal(String input) {
        Node root = new Node(0, null, new TreeMap<>());
        input.lines().reduce(root, (n, l) -> n.apply(l), (a, b) -> {
            return null;
        });
        return root;
    }
}
