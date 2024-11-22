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

    public static String getLongInput() {
        return "Game 1: 7 green, 4 blue, 3 red; 4 blue, 10 red, 1 green; 1 blue, 9 red\n" +
                "Game 2: 2 red, 4 blue, 3 green; 5 green, 3 red, 1 blue; 3 green, 5 blue, 3 red\n" +
                "Game 3: 12 red, 1 blue; 6 red, 2 green, 3 blue; 2 blue, 5 red, 3 green\n" +
                "Game 4: 3 green, 1 red, 3 blue; 1 red; 2 green, 1 red, 1 blue; 3 green, 1 blue; 2 blue; 2 green, 4 blue\n" +
                "Game 5: 3 blue, 3 red, 8 green; 5 blue, 1 red; 1 green, 19 blue, 3 red; 1 red, 5 green, 3 blue; 4 green, 20 blue, 4 red; 20 blue, 4 green\n" +
                "Game 6: 7 green, 6 blue, 1 red; 3 blue, 5 green, 3 red; 9 blue, 3 red, 6 green; 8 blue, 11 green, 3 red; 2 blue, 1 red; 7 green, 4 blue, 1 red\n" +
                "Game 7: 5 green, 1 blue; 2 green, 2 blue; 1 blue, 1 red; 5 blue, 2 green; 3 green\n" +
                "Game 8: 5 blue, 5 red, 10 green; 6 green, 1 blue, 1 red; 5 red, 2 blue, 16 green; 2 blue, 14 green, 9 red; 9 red, 3 green, 7 blue; 8 red, 4 blue, 10 green\n" +
                "Game 9: 1 red, 1 blue, 7 green; 4 red, 6 green, 2 blue; 6 green, 14 blue, 3 red\n" +
                "Game 10: 1 red, 16 green, 3 blue; 1 red, 3 blue; 6 green; 4 green, 2 blue, 1 red\n" +
                "Game 11: 5 red, 2 blue; 14 blue, 8 red, 10 green; 8 green, 1 red, 15 blue; 2 green, 5 red, 11 blue; 8 red, 11 blue, 4 green\n" +
                "Game 12: 5 green, 8 blue, 4 red; 15 green, 8 blue, 8 red; 13 red, 1 blue; 6 blue, 7 green, 14 red; 9 red\n" +
                "Game 13: 7 blue, 5 red; 3 green, 10 blue; 5 blue, 2 green, 5 red; 3 blue, 1 green, 5 red; 6 blue, 4 red, 6 green; 5 red, 2 green, 6 blue\n" +
                "Game 14: 5 red, 1 blue, 5 green; 6 blue, 13 green, 4 red; 7 blue, 4 red, 1 green; 6 blue, 5 red; 2 red, 7 blue, 2 green\n" +
                "Game 15: 8 red, 16 green; 10 green, 1 blue; 16 green, 7 blue, 3 red; 13 red, 7 blue, 8 green; 4 red, 2 green, 8 blue\n" +
                "Game 16: 1 red, 1 blue, 5 green; 5 green, 2 red; 2 green, 1 red; 3 red, 4 green\n" +
                "Game 17: 3 green, 7 blue, 5 red; 2 red, 1 blue; 8 blue, 1 red\n" +
                "Game 18: 9 green, 6 blue, 3 red; 3 red, 15 green, 5 blue; 7 green, 3 red, 3 blue\n" +
                "Game 19: 4 green, 3 red, 7 blue; 4 blue, 6 red, 4 green; 6 red, 5 green, 1 blue; 6 blue, 4 green, 3 red; 5 green, 5 red, 2 blue\n" +
                "Game 20: 3 green, 5 blue, 1 red; 1 red, 1 blue; 1 red, 6 blue; 1 green, 4 blue\n" +
                "Game 21: 2 green, 1 blue, 3 red; 16 green, 1 blue, 4 red; 11 green, 2 red, 1 blue; 6 green, 1 blue; 10 green, 1 red, 1 blue\n" +
                "Game 22: 1 blue, 2 green, 4 red; 3 red, 4 green; 1 blue, 3 red, 10 green; 7 green, 1 blue\n" +
                "Game 23: 2 red, 14 blue; 2 red, 14 blue; 1 red, 14 blue, 1 green; 1 red, 6 blue; 13 blue, 1 green\n" +
                "Game 24: 3 green, 7 blue, 3 red; 4 green, 2 blue; 12 blue, 8 red, 4 green; 10 blue, 9 red, 1 green; 13 blue, 4 red; 12 blue, 9 red, 2 green\n" +
                "Game 25: 9 green, 11 red; 14 green, 3 red, 1 blue; 8 red, 7 green; 10 red, 8 green, 1 blue; 6 red, 11 green, 1 blue\n" +
                "Game 26: 10 blue, 6 red, 11 green; 9 red, 2 green, 10 blue; 5 red; 9 red, 8 blue, 7 green; 13 green, 10 red, 1 blue\n" +
                "Game 27: 3 blue, 1 green; 10 green, 1 blue; 8 red, 6 green, 6 blue\n" +
                "Game 28: 10 blue, 2 red, 13 green; 2 blue, 2 red, 6 green; 10 blue; 4 red, 4 blue, 11 green; 3 green, 2 red, 6 blue; 14 green, 2 red, 2 blue\n" +
                "Game 29: 8 blue, 5 red, 6 green; 1 green, 4 blue, 15 red; 8 blue, 14 red, 3 green; 9 blue, 4 red, 5 green; 3 red, 3 green, 4 blue\n" +
                "Game 30: 19 green, 14 blue, 2 red; 2 red, 8 green, 7 blue; 4 blue, 1 red, 13 green; 10 blue, 3 green; 8 blue, 2 red\n" +
                "Game 31: 12 green, 5 blue, 3 red; 15 blue, 11 green, 6 red; 6 green, 6 red; 4 green, 6 blue, 10 red\n" +
                "Game 32: 7 red, 2 green, 3 blue; 9 red, 1 green; 2 green, 5 red, 1 blue; 12 red; 14 red, 4 blue\n" +
                "Game 33: 9 red, 4 green, 6 blue; 4 red, 10 green; 16 red, 4 green, 4 blue; 15 blue, 12 red\n" +
                "Game 34: 5 green, 1 blue; 18 red, 1 green, 1 blue; 1 blue, 9 green, 3 red; 6 green, 11 red\n" +
                "Game 35: 2 blue, 19 green, 6 red; 16 green, 1 red, 1 blue; 1 green, 2 blue, 5 red; 8 green, 3 blue, 13 red; 11 red, 10 green, 4 blue\n" +
                "Game 36: 17 green, 6 blue; 10 blue, 2 red, 8 green; 16 green, 4 blue, 1 red\n" +
                "Game 37: 9 green, 7 red, 8 blue; 1 blue, 10 red; 10 red, 4 blue, 11 green; 8 green, 11 red, 5 blue\n" +
                "Game 38: 8 green, 11 blue; 13 green, 2 blue; 7 blue, 2 red, 8 green\n" +
                "Game 39: 14 red, 2 green; 2 red, 3 green, 1 blue; 4 red, 5 green, 4 blue; 2 blue, 3 red, 1 green; 17 red, 2 blue; 5 green, 3 red\n" +
                "Game 40: 10 blue; 2 red, 9 blue; 5 red, 1 green, 2 blue; 8 blue, 2 red; 6 blue, 2 red; 4 red, 2 blue, 1 green\n" +
                "Game 41: 2 blue, 3 red, 2 green; 4 green, 2 red, 11 blue; 11 blue, 3 red, 1 green; 1 red, 6 green, 1 blue; 5 red, 7 green\n" +
                "Game 42: 1 blue, 14 green, 1 red; 2 blue, 2 green; 5 green, 2 blue, 8 red\n" +
                "Game 43: 15 red, 5 blue, 5 green; 15 green, 15 red, 1 blue; 4 blue, 13 green, 13 red; 3 red, 16 green; 2 red, 3 green, 2 blue\n" +
                "Game 44: 8 green, 8 blue; 9 blue, 9 green; 9 green, 3 blue; 8 green, 3 blue; 8 blue, 2 green; 9 blue, 1 red, 8 green\n" +
                "Game 45: 4 red, 4 blue, 4 green; 5 red, 2 green, 9 blue; 8 blue, 5 red, 3 green; 4 red, 3 blue; 5 red, 5 green, 1 blue\n" +
                "Game 46: 1 blue, 9 green, 2 red; 2 blue, 9 green, 1 red; 8 green, 3 red\n" +
                "Game 47: 2 green, 4 blue, 10 red; 4 green, 5 blue, 1 red; 10 green, 13 red, 6 blue; 4 green, 4 blue, 12 red; 15 red, 1 blue, 4 green\n" +
                "Game 48: 1 red, 7 green; 2 blue, 4 green, 5 red; 5 red, 3 green, 1 blue; 8 green\n" +
                "Game 49: 3 blue, 4 green, 3 red; 6 red, 5 green, 5 blue; 1 blue, 4 green, 3 red; 6 red, 1 blue, 5 green; 4 red, 3 green, 5 blue; 2 green, 3 blue, 1 red\n" +
                "Game 50: 1 green, 5 red, 6 blue; 3 red, 2 green; 1 red, 1 green, 6 blue; 1 green, 7 red, 3 blue\n" +
                "Game 51: 7 green, 8 blue; 6 blue, 6 red, 4 green; 6 green, 1 blue; 8 blue, 5 red, 4 green\n" +
                "Game 52: 7 red, 3 blue, 6 green; 7 green, 5 red, 4 blue; 6 red, 4 blue\n" +
                "Game 53: 12 blue, 1 red, 5 green; 4 green, 2 blue, 5 red; 5 red, 4 green; 1 green, 3 blue, 5 red; 5 blue, 2 red, 5 green\n" +
                "Game 54: 15 green, 12 red; 11 red, 3 green, 2 blue; 3 blue, 6 green; 3 red, 1 blue, 5 green; 17 red, 7 green\n" +
                "Game 55: 7 green, 10 red, 7 blue; 8 red, 4 blue, 11 green; 9 green, 11 red\n" +
                "Game 56: 7 green, 3 blue, 5 red; 6 green, 1 red, 4 blue; 4 green, 2 red; 5 blue, 6 red, 8 green\n" +
                "Game 57: 1 green, 3 red, 3 blue; 5 blue, 2 red, 2 green; 1 green, 5 blue\n" +
                "Game 58: 4 red, 2 green; 13 green, 4 red, 1 blue; 12 green, 4 blue\n" +
                "Game 59: 4 red, 4 green; 5 blue, 1 green, 20 red; 11 red, 3 green, 15 blue; 5 blue, 7 red, 3 green; 18 blue, 4 green, 19 red\n" +
                "Game 60: 5 blue, 8 red, 4 green; 4 blue, 12 green, 19 red; 3 blue, 1 green, 17 red; 1 green, 3 blue; 2 green, 6 blue, 3 red\n" +
                "Game 61: 3 red, 7 blue, 12 green; 7 red, 1 green, 6 blue; 6 red, 2 green, 18 blue; 14 blue, 5 red, 1 green\n" +
                "Game 62: 1 red, 2 blue; 1 green, 3 red; 1 green, 9 blue, 4 red\n" +
                "Game 63: 6 green, 4 blue, 17 red; 2 green, 2 blue, 12 red; 10 green, 9 blue, 13 red; 15 red, 8 green, 5 blue\n" +
                "Game 64: 4 green, 7 blue, 10 red; 3 green, 4 blue, 12 red; 6 green, 6 red, 8 blue; 4 green, 9 red, 1 blue; 2 blue, 15 red, 15 green\n" +
                "Game 65: 5 green, 4 blue, 7 red; 6 green, 7 blue, 8 red; 1 green, 7 red; 1 blue, 10 red, 8 green\n" +
                "Game 66: 5 green, 5 blue, 2 red; 3 red; 1 red, 1 blue, 16 green; 2 blue, 1 green; 8 green, 1 blue, 3 red; 14 green, 4 red\n" +
                "Game 67: 12 blue, 7 green; 7 blue, 7 green, 1 red; 12 blue, 1 green, 6 red\n" +
                "Game 68: 2 blue, 8 red, 1 green; 9 blue, 3 green, 12 red; 14 blue, 15 red, 6 green\n" +
                "Game 69: 7 red, 1 blue; 11 green, 2 blue, 13 red; 3 blue, 13 green, 3 red; 1 blue, 10 red, 8 green; 15 red, 2 blue, 19 green\n" +
                "Game 70: 10 green, 10 red, 12 blue; 7 red, 15 blue, 2 green; 8 blue, 9 green\n" +
                "Game 71: 1 blue, 2 green, 13 red; 7 red; 1 green, 5 red\n" +
                "Game 72: 2 red, 1 blue, 11 green; 1 red, 2 blue, 18 green; 5 red, 3 blue, 3 green\n" +
                "Game 73: 13 red, 3 blue, 4 green; 3 green, 17 red, 1 blue; 6 blue, 4 green, 4 red; 13 red, 7 blue\n" +
                "Game 74: 1 blue, 3 red; 13 blue, 5 red, 2 green; 1 red, 8 green, 11 blue; 4 blue, 1 green, 5 red; 11 blue, 8 red, 6 green; 8 red, 3 green, 4 blue\n" +
                "Game 75: 7 blue, 4 green, 1 red; 3 green, 4 blue; 5 green, 2 red, 3 blue; 6 blue, 3 red, 5 green\n" +
                "Game 76: 9 green, 1 blue, 4 red; 6 red, 9 green, 3 blue; 2 red, 6 green, 2 blue; 5 green; 6 green, 2 red, 3 blue; 6 blue, 5 red, 5 green\n" +
                "Game 77: 2 green, 2 red; 1 blue, 6 red, 2 green; 4 green, 3 red, 2 blue; 2 blue, 1 green, 1 red\n" +
                "Game 78: 2 green, 10 red, 2 blue; 6 green, 2 red, 2 blue; 2 blue, 9 red, 6 green; 11 red, 6 green; 3 red, 8 green; 1 blue, 6 green, 1 red\n" +
                "Game 79: 3 blue, 8 green, 13 red; 3 blue, 2 red, 3 green; 10 red, 6 green, 4 blue; 11 red, 1 blue, 3 green\n" +
                "Game 80: 3 green, 5 red, 9 blue; 3 red, 5 blue, 2 green; 5 green, 6 red, 2 blue\n" +
                "Game 81: 2 green, 7 blue, 3 red; 9 blue, 3 red; 1 green, 17 blue, 2 red\n" +
                "Game 82: 4 green, 8 blue, 7 red; 10 blue, 1 green, 10 red; 7 blue, 4 green, 5 red\n" +
                "Game 83: 7 green, 4 blue, 3 red; 15 blue, 3 red, 14 green; 9 blue, 4 red, 7 green\n" +
                "Game 84: 5 red, 5 green; 16 blue, 1 red, 7 green; 17 blue, 11 red\n" +
                "Game 85: 7 red, 1 green, 11 blue; 13 blue, 5 green, 6 red; 11 blue, 2 green, 8 red; 5 blue, 17 red, 4 green; 12 blue, 2 green, 8 red\n" +
                "Game 86: 3 red, 8 blue, 2 green; 15 green, 15 blue, 2 red; 18 blue, 2 red, 11 green\n" +
                "Game 87: 1 blue; 6 red, 6 green; 1 blue, 9 red, 3 green\n" +
                "Game 88: 10 green, 2 blue, 1 red; 7 blue, 1 green, 1 red; 9 green, 4 blue; 8 green, 1 red, 7 blue\n" +
                "Game 89: 6 green, 2 red, 2 blue; 5 red, 3 blue, 3 green; 3 blue, 4 red, 1 green; 5 red, 4 green, 5 blue; 4 blue, 6 green, 3 red; 3 red, 1 green\n" +
                "Game 90: 1 green, 6 blue; 1 blue, 1 red; 2 blue, 3 green; 7 green, 6 blue; 1 red, 7 green, 6 blue\n" +
                "Game 91: 8 blue, 14 green, 5 red; 8 red, 6 green; 4 red, 7 blue, 14 green; 4 blue, 7 green; 9 blue, 7 red; 14 green, 7 blue, 4 red\n" +
                "Game 92: 11 blue, 8 green, 6 red; 11 blue, 1 red, 11 green; 10 blue, 19 green, 5 red\n" +
                "Game 93: 5 green, 1 red, 7 blue; 8 green, 14 blue, 2 red; 5 red, 14 blue, 7 green\n" +
                "Game 94: 2 blue, 6 red, 3 green; 4 red, 2 green, 2 blue; 4 red, 1 blue, 1 green\n" +
                "Game 95: 9 red, 15 green, 1 blue; 2 blue, 10 red, 18 green; 3 red, 10 green; 10 red, 17 green, 2 blue; 3 blue, 13 green, 1 red; 2 red, 2 blue, 6 green\n" +
                "Game 96: 8 green, 1 blue; 1 blue, 1 red, 11 green; 2 green, 15 blue; 1 red, 2 green, 1 blue\n" +
                "Game 97: 3 green, 3 blue; 5 green, 3 blue, 1 red; 5 green, 1 red, 3 blue; 1 green, 1 red, 2 blue; 2 green, 2 blue, 3 red\n" +
                "Game 98: 6 red, 6 green, 5 blue; 19 red, 7 green; 6 green, 8 blue, 4 red; 10 green, 4 red\n" +
                "Game 99: 9 red, 8 blue, 10 green; 3 blue, 7 green, 8 red; 6 red, 12 blue; 8 blue, 8 green, 2 red; 16 green, 14 blue, 5 red\n" +
                "Game 100: 8 red, 13 green; 5 red, 4 green; 7 blue, 3 red, 8 green; 13 blue, 6 green; 1 blue, 8 green, 7 red; 2 red, 1 green, 16 blue";
    }
}
