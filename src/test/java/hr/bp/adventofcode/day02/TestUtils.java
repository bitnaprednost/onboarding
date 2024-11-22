package hr.bp.adventofcode.day02;

import hr.bp.adventofcode.day02.color.Color;

import java.util.List;
import java.util.Map;

public class TestUtils {

    static String getShortInput() {
        return "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
    }

    static Map<Integer, List<Map<Color, Integer>>> getShortGameInformation() {
        return Map.of(
                1, List.of(
                        Map.of(Color.BLUE, 3, Color.RED, 4),
                        Map.of(Color.RED, 1, Color.GREEN, 2, Color.BLUE, 6),
                        Map.of(Color.GREEN, 2)
                ),
                2, List.of(
                        Map.of(Color.BLUE, 1, Color.GREEN, 2),
                        Map.of(Color.GREEN, 3, Color.BLUE, 4, Color.RED, 1),
                        Map.of(Color.GREEN, 1, Color.BLUE, 1)
                ),
                3, List.of(
                        Map.of(Color.GREEN, 8, Color.BLUE, 6, Color.RED, 20),
                        Map.of(Color.BLUE, 5, Color.RED, 4, Color.GREEN, 13),
                        Map.of(Color.GREEN, 5, Color.RED, 1)
                ),
                4, List.of(
                        Map.of(Color.GREEN, 1, Color.RED, 3, Color.BLUE, 6),
                        Map.of(Color.GREEN, 3, Color.RED, 6),
                        Map.of(Color.GREEN, 3, Color.BLUE, 15, Color.RED, 14)
                ),
                5, List.of(
                        Map.of(Color.RED, 6, Color.BLUE, 1, Color.GREEN, 3),
                        Map.of(Color.BLUE, 2, Color.RED, 1, Color.GREEN, 2)
                )
        );
    }
}
