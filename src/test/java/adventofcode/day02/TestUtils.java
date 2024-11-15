package adventofcode.day02;

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

    static Map<Integer, List<Map<ColorEnum, Integer>>> getShortGameInformation() {
        return Map.of(
                1, List.of(
                        Map.of(ColorEnum.BLUE, 3, ColorEnum.RED, 4),
                        Map.of(ColorEnum.RED, 1, ColorEnum.GREEN, 2, ColorEnum.BLUE, 6),
                        Map.of(ColorEnum.GREEN, 2)
                ),
                2, List.of(
                        Map.of(ColorEnum.BLUE, 1, ColorEnum.GREEN, 2),
                        Map.of(ColorEnum.GREEN, 3, ColorEnum.BLUE, 4, ColorEnum.RED, 1),
                        Map.of(ColorEnum.GREEN, 1, ColorEnum.BLUE, 1)
                ),
                3, List.of(
                        Map.of(ColorEnum.GREEN, 8, ColorEnum.BLUE, 6, ColorEnum.RED, 20),
                        Map.of(ColorEnum.BLUE, 5, ColorEnum.RED, 4, ColorEnum.GREEN, 13),
                        Map.of(ColorEnum.GREEN, 5, ColorEnum.RED, 1)
                ),
                4, List.of(
                        Map.of(ColorEnum.GREEN, 1, ColorEnum.RED, 3, ColorEnum.BLUE, 6),
                        Map.of(ColorEnum.GREEN, 3, ColorEnum.RED, 6),
                        Map.of(ColorEnum.GREEN, 3, ColorEnum.BLUE, 15, ColorEnum.RED, 14)
                ),
                5, List.of(
                        Map.of(ColorEnum.RED, 6, ColorEnum.BLUE, 1, ColorEnum.GREEN, 3),
                        Map.of(ColorEnum.BLUE, 2, ColorEnum.RED, 1, ColorEnum.GREEN, 2)
                )
        );
    }
}
