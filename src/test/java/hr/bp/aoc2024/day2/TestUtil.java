package hr.bp.aoc2024.day2;

import java.util.List;

public class TestUtil {

    public static String getTestInput() {
        return "7 6 4 2 1\n" +
                "1 2 7 8 9\n" +
                "9 7 6 2 1\n" +
                "1 3 2 4 5\n" +
                "8 6 4 4 1\n" +
                "1 3 6 7 9";
    }

    public static List<List<Integer>> getExpectedTest() {
        return List.of(
                List.of(7, 6, 4, 2, 1),
                List.of(1, 2, 7, 8, 9),
                List.of(9, 7, 6, 2, 1),
                List.of(1, 3, 2, 4, 5),
                List.of(8, 6, 4, 4, 1),
                List.of(1, 3, 6, 7, 9)
        );
    }
}
