package hr.bp.aoc.days.distressSignal;

import hr.bp.aoc.days.calorieCounting.DayOne;
import hr.bp.aoc.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day13 implements Day {

    public static final Logger logger = LoggerFactory.getLogger(DayOne.class);
    List<List<List<?>>> pairs;

    {
        try {
            pairs = readPairs(Files.readString(Path.of("src/main/resources/distressSignalData.txt")));
        } catch (IOException e) {
            logger.error("Cannot read String from PATH");
        }
    }

    @Override
    public void executePartOne() {
        int sum = IntStream.range(0, pairs.size())
                .filter(i -> compare(pairs.get(i).get(0), pairs.get(i).get(1), 0) <= 0)
                .map(i -> i + 1).sum();

        logger.info("distressSignal PART 1: {}", sum);
    }

    @Override
    public void executePartTwo() {
        List<List<Integer>> dividers = List.of(List.of(2), List.of(6));
        var packets = pairs.stream().flatMap(p -> Stream.of(p.get(0), p.get(1))).toList();
        var sorted = Stream.concat(packets.stream(), dividers.stream())
                .sorted((a,b) -> compare(a, b, 0)).toList();
        int key = IntStream.range(0, sorted.size())
                .filter(p -> dividers.contains(sorted.get(p)))
                .map(i -> i + 1).reduce(1, (a,b) -> a * b);

        logger.info("distressSignal PART 2: {}", key);
    }

    @Override
    public String getDayOrderNumber() {
        return "Day 13";
    }

    int compare(List<?> left, List<?> right, int i) {
        if (i >= left.size() && i >= right.size()) {
            return 0;
        } else if (i >= left.size()) {
            return -1;
        } else if (i >= right.size()) {
            return 1;
        }

        Object li = left.get(i);
        Object ri = right.get(i);
        if (li instanceof Integer && ri instanceof Integer) {
            return li.equals(ri) ? compare(left, right, i+1) : (int)li -(int)ri;
        }

        List<?> ll = li instanceof List ? (List<?>)(li) : List.of(li);
        List<?> rl = ri instanceof List ? (List<?>)(ri) : List.of(ri);
        var res = compare(ll, rl, 0);
        return res == 0 ? compare(left, right, i+1) : res;
    }

    List<List<List<?>>> readPairs(String input) {
        return Arrays.stream(input.split("\n\n"))
                .map(pair -> pair.split("\n"))
                .map(pair -> List.of(parse(pair[0]), parse(pair[1]))).toList();
    }

    List<?> parse(String input) {
        LinkedList<List<Object>> stack = new LinkedList<>();
        List<Object> latest = new LinkedList<>();
        StringBuilder buffer = new StringBuilder();

        Runnable add = () -> {
            if (!buffer.isEmpty()) {
                stack.getFirst().add(Integer.parseInt(buffer.toString()));
                buffer.setLength(0);
            }
        };

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '[' -> stack.push(new LinkedList<>());
                case ']' -> {
                    add.run();
                    latest = stack.pop();
                    if (!stack.isEmpty()) stack.getFirst().add(latest);
                }
                case ',' -> add.run();
                default -> buffer.append(input.charAt(i));
            }
        }
        return latest;
    }
}
