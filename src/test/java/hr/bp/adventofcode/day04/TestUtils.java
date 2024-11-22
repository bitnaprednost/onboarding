package hr.bp.adventofcode.day04;

import java.util.Map;
import java.util.Set;

/**
 * @author Ivan Tomičić
 */
public class TestUtils {

    public static String getInputOne() {
        return """
                Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
                Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
                Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
                Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
                Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
                Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11""";
    }

    public static Map<Integer, Scratchcard> getListOfScratchcardsForInputOne() {
        return Map.of(
                1, new Scratchcard(
                        Set.of(41, 48, 83, 86, 17),
                        Set.of(83, 86, 6, 31, 17, 9, 48, 53)
                ),
                2, new Scratchcard(
                        Set.of(13, 32, 20, 16, 61),
                        Set.of(61, 30, 68, 82, 17, 32, 24, 19)
                ),
                3, new Scratchcard(
                        Set.of(1, 21, 53, 59, 44),
                        Set.of(69, 82, 63, 72, 16, 21, 14, 1)
                ),
                4, new Scratchcard(
                        Set.of(41, 92, 73, 84, 69),
                        Set.of(59, 84, 76, 51, 58, 5, 54, 83)
                ),
                5, new Scratchcard(
                        Set.of(87, 83, 26, 28, 32),
                        Set.of(88, 30, 70, 12, 93, 22, 82, 36)
                ),
                6, new Scratchcard(
                        Set.of(31, 18, 13, 56, 72),
                        Set.of(74, 77, 10, 23, 35, 67, 36, 11)
                )
        );
    }

    public static String getInputTwo() {
        return """
                Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
                Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
                Card 3: 16 21 53 69 44 | 69 82 63 72 16 21 14  1
                Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
                Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
                Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11""";
    }

    public static String getInputAllWinningNumbers() {
        return """
                Card 1: 41 48 83 86 17 | 83 86 41 31 17  9 48 53
                Card 2: 13 32 20 16 61 | 61 13 20 82 16 32 24 19
                """;
    }

    public static String getInputNoWinningNumber() {
        return """
                Card 1: 41 48 83 86 17 | 1 2 3 4 5 6 7 8
                Card 2: 13 32 20 16 61 | 11 22 23 88 69 1 6 33
                Card 3: 16 21 53 69 44 | 68 82 63 72 17 22 14  1
                Card 4: 41 92 73 84 69 | 59 85 76 51 58  5 54 83
                Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
                Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11""";
    }
}
