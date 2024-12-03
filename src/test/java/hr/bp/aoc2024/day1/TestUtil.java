package hr.bp.aoc2024.day1;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<List<Long>> getExpectedTestText() {
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();

        addElementsToList(left, new long[]{3, 4, 2, 1, 3, 3});
        addElementsToList(right, new long[]{4, 3, 5, 3, 9, 3});

        return List.of(left, right);
    }

    private static void addElementsToList(List<Long> list, long[] elements) {
        for (long element : elements) {
            list.add(element);
        }
    }

    public static String getTestInput() {
        return "3   4\n" +
                "4   3\n" +
                "2   5\n" +
                "1   3\n" +
                "3   9\n" +
                "3   3";
    }
}
