package hr.bp.aoc.days.regolithReservoir;

import hr.bp.aoc.days.calorieCounting.DayOne;
import hr.bp.aoc.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day14 implements Day {


    public static final Logger logger = LoggerFactory.getLogger(DayOne.class);
    @Override
    public void executePartOne() {
        try {
            logger.info("Regolith Reservoir PART 1: {}", pourSand(false));
        } catch (Exception e) {
            logger.error("Cannot read String from PATH");
        }
    }

    @Override
    public void executePartTwo() {
        try {
            logger.info("Regolith Reservoir PART 2: {}", pourSand(true));
        } catch (Exception e) {
            logger.error("Cannot read String from PATH");
        }
    }

    @Override
    public String getDayOrderNumber() {
        return "Day 14";
    }

    long pourSand(boolean haveFloor) throws Exception {
        Map<XY, Entry> cave = readRocks(Files.readString(Path.of("C:\\Users\\Luka\\Downloads\\projekti\\onboarding\\src\\main\\resources\\regolithReservoirData.txt")));
        int floor = haveFloor ? cave.keySet().stream().mapToInt(r -> r.y).max().getAsInt() + 2 : 0;
        long count = -1;
        while(count != countSand(cave)) {
            count = countSand(cave);
            dropSand(cave, floor);
        }
        return count;
    }

    void dropSand(Map<XY,Entry> cave, int floor) {
        XY sand = new XY(500, 0), prev;
        do {
            prev = sand;
            XY old = sand;
            sand = moves.stream().map(m -> new XY(old.x + m.x, old.y + m.y))
                    .filter(n -> !cave.containsKey(n)).findFirst().orElse(sand); // find next place for sand
        } while (prev != sand && sand.y + 1 != floor && sand.y < 999);

        if (cave.containsKey(new XY(sand.x, sand.y+1)) || sand.y + 1 == floor) {
            cave.put(sand, Entry.SAND); // We have support below, place sand
        }
    }

    long countSand(Map<XY,Entry> cave) {
        return cave.values().stream().filter(e -> e == Entry.SAND).count();
    }

    Map<XY,Entry> readRocks(String input) {
        return Arrays.stream(input.split("\n")).flatMap(l -> toRocks(l).stream())
                .collect(Collectors.toMap(r -> r, r -> Entry.ROCK, (a, b) -> a, () -> new HashMap<XY,Entry>()));
    }

    List<XY> toRocks(String line) {
        String[] parts = line.split(" -> ");
        var res = new ArrayList<XY>();
        for (int i = 1; i < parts.length; i++) {
            res.addAll(draw(XY.parse(parts[i-1]), XY.parse(parts[i])).toList());
        }
        return res;
    }

    Stream<XY> draw(XY p1, XY p2) {
        if (p1.equals(p2)) { return Stream.of(p1); }
        return Stream.concat(Stream.of(p1), draw(p1.moveTowards(p2), p2));
    }

    enum Entry{ROCK, SAND};

    record XY(int x, int y) {
        static XY parse(String input) {
            var parts = input.split(",");
            return new XY(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
        XY moveTowards(XY o) {
            if (x == o.x && y < o.y) return new XY(x, y+1);
            if (x == o.x && y > o.y) return new XY(x, y-1);
            if (y == o.y && x < o.x) return new XY(x+1, y);
            if (y == o.y && x > o.x) return new XY(x-1, y);
            throw new IllegalStateException();
        }
    }

    List<XY> moves = List.of(new XY(0, 1), new XY(-1, 1), new XY(1, 1));
}
