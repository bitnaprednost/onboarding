package hr.bp.aoc.days.treetopTreeHouse;

import hr.bp.aoc.days.calorieCounting.DayOne;
import hr.bp.aoc.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DayEight implements Day {

    public static final Logger logger = LoggerFactory.getLogger(DayEight.class);

    int[][] map;

    {
        try {
            map = parseMap(Files.readString(Path.of("src/main/resources/treetopTreeHouse.txt")));
        } catch (IOException e) {
            logger.error("Cannot read String from PATH");
        }
    }

    @Override
    public void executePartOne() {
        logger.info("treetopTreeHouse PART 1: {}", countVisible(map));
    }

    @Override
    public void executePartTwo() {
        logger.info("treetopTreeHouse PART 2: {}", highestScenicScore(map));
    }

    @Override
    public String getDayOrderNumber() {
        return "Day Eight";
    }

    int highestScenicScore(int[][] map) {
        return IntStream.range(0, map.length)
                .flatMap(y -> IntStream.range(0, map[y].length)
                        .map(x -> scenicScore(map, new Point(x, y)))).max().getAsInt();
    }

    int scenicScore(int[][] map, Point op) {
        int up = visibleTrees(map, op, p -> p.move(0, -1));
        int down = visibleTrees(map, op, p -> p.move(0, 1));
        int left = visibleTrees(map, op, p -> p.move(-1, 0));
        int right = visibleTrees(map, op, p -> p.move(1, 0));

        return up * down * left * right;
    }

    int visibleTrees(int[][] map, Point op, Function<Point, Point> move) {
        int count = 0;
        for (var p = move.apply(op); p.inside(map); p = move.apply(p)) {
            count++;
            if (map[p.y()][p.x()] >= map[op.y()][op.x()]) {
                return count;
            }
        }
        return count;
    }

    long countVisible(int[][] map) {
        return IntStream.range(0, map.length)
                .flatMap(y -> IntStream.range(0, map[y].length).filter(x -> visible(map, y, x))).count();
    }

    boolean visible(int[][] map, int y, int x) {
        if (y == 0 || y == map.length - 1 || x == 0 || x == map[y].length - 1) {
            return true; // edge cases
        }
        var height = map[y][x];
        return Stream.of(
                        IntStream.of(map[y]).limit(x).max(), // left max height
                        IntStream.of(map[y]).skip(x + 1).max(), // right max
                        IntStream.of(col(map, x)).limit(y).max(), // up
                        IntStream.of(col(map, x)).skip(y + 1).max()) // down
                .mapToInt(m -> m.getAsInt()).anyMatch(h -> h < height); // any shorter than given tree
    }

    int[] col(int[][] map, int x) {
        return IntStream.range(0, map.length).map(y -> map[y][x]).toArray();
    }

    int[][] parseMap(String input) {
        return input.lines().map(l -> l.chars().map(c -> c - '0').toArray()).toArray(int[][]::new);
    }
}
