package hr.bp.adventofcode.day06;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class TestUtils {

    public static String getFirstInput() {
        return """
                Time:      7  15   30
                Distance:  9  40  200""";
    }

    public static List<RaceRecord> getFirstInputParsed() {
        return List.of(
                new RaceRecord(7, 9),
                new RaceRecord(15, 40),
                new RaceRecord(30, 200)
        );
    }

    public static String getSecondInput() {
        return """
                Time:        62     73     75     65
                Distance:   644   1023   1240   1023""";
    }

    public static List<RaceRecord> getSecondInputParsed() {
        return List.of(
                new RaceRecord(62, 644),
                new RaceRecord(73, 1023),
                new RaceRecord(75, 1240),
                new RaceRecord(65, 1023)
        );
    }

}
