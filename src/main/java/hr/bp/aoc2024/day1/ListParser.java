package hr.bp.aoc2024.day1;

import java.util.ArrayList;
import java.util.List;

public class ListParser {
    private List<String> input;

    public ListParser(String input) {
        this(List.of(input.split("\\n")));
    }

    public ListParser(List<String> input) {
        this.input = input;
    }

    private static String[] getNumFromLine(String line) {
        String[] numbers = new String[2];
        int numAdded = 0;

        for (String s : line.split(" ")) {
            if (!s.isEmpty()) {
                numbers[numAdded++] = s;
            }
        }
        return numbers;
    }

    public List<List<Long>> parseInput() {
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();

        for (String line : input) {
            String[] numbers = getNumFromLine(line);
            left.add(Long.parseLong(numbers[0]));
            right.add(Long.parseLong(numbers[1]));
        }

        return List.of(left, right);
    }
}
