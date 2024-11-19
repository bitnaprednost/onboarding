package adventofcode.day04;

import java.util.List;

public class TestUtils {
    public static String getTestOneInput() {
        return  "19, 13, 30 @ -2,  1, -2\n" +
                "18, 19, 22 @ -1, -1, -2\n" +
                "20, 25, 34 @ -2, -2, -4\n" +
                "12, 31, 28 @ -1, -2, -1\n" +
                "20, 19, 15 @  1, -5, -3";
    }

    public static List<Hailstone> expectedHailstonesTestOne = List.of(
            new Hailstone(new Position(19, 13, 30), new Velocity(-2, 1, -2)),
            new Hailstone(new Position(18, 19, 22), new Velocity(-1, -1, -2)),
            new Hailstone(new Position(20, 25, 34), new Velocity(-2, -2, -4)),
            new Hailstone(new Position(12, 31, 28), new Velocity(-1, -2, -1)),
            new Hailstone(new Position(20, 19, 15), new Velocity(1, -5, -3))
    );



    public static String getTestTwoInput() {
        return  "11, 13, 30 @ -2,  1, -2\n" +
                "18, 19, 22 @ -1, 1, -2\n" +
                "20, 44, 13 @ -3, -2, -4\n" +
                "12, 31, 28 @ -1, 2, -1\n" +
                "20, 82, 15 @  1, -5, -3";
    }

    public static String getNoIntersectionsInput() {
        return  "11, 13, 30 @ 1, 1, 1\n" +
                "18, 19, 22 @ 1, 1, 1\n" +
                "20, 44, 13 @ 1, 1, 1\n" +
                "12, 31, 28 @ 1, 1, 1\n" +
                "20, 82, 15 @ 1, 1, 1";
    }

    public static String getZeroVelocitiesInput() {
        return  "11, 13, 30 @ 0, 0, 0\n" +
                "18, 19, 22 @ 0, 0, 0\n" +
                "20, 44, 13 @ 0, 0, 0\n" +
                "12, 31, 28 @ 0, 0, 0\n" +
                "20, 82, 15 @ 0, 0, 0";
    }

    public static List<Hailstone> expectedHailstonesTestTwo = List.of(
            new Hailstone(new Position(11, 13, 30), new Velocity(-2, 1, -2)),
            new Hailstone(new Position(18, 19, 22), new Velocity(-1, 1, -2)),
            new Hailstone(new Position(20, 44, 13), new Velocity(-3, -2, -4)),
            new Hailstone(new Position(12, 31, 28), new Velocity(-1, 2, -1)),
            new Hailstone(new Position(20, 82, 15), new Velocity(1, -5, -3))
    );
}
