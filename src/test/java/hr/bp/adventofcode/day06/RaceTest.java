package hr.bp.adventofcode.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Tomičić
 */
public class RaceTest {

    @Test
    public void calculatePossibleWaysToWin_givenARaceRecordOne_returnsCorrectNumberOfWays() {
        RaceRecord raceRecord = new RaceRecord(7, 9);
        Race race = new Race(raceRecord);

        long expectedWaysToWinARace = 4;

        long actualWaysToWinARace = race.calculateWaysToWinARace();

        Assertions.assertEquals(expectedWaysToWinARace, actualWaysToWinARace);
    }

    @Test
    public void calculatePossibleWaysToWin_givenARaceRecordTwo_returnsCorrectNumberOfWays() {
        RaceRecord raceRecord = new RaceRecord(15, 40);
        Race race = new Race(raceRecord);

        long expectedWaysToWinARace = 8;

        long actualWaysToWinARace = race.calculateWaysToWinARace();

        Assertions.assertEquals(expectedWaysToWinARace, actualWaysToWinARace);
    }

    @Test
    public void calculatePossibleWaysToWin_givenARaceRecordThree_returnsCorrectNumberOfWays() {
        RaceRecord raceRecord = new RaceRecord(30, 200);
        Race race = new Race(raceRecord);

        long expectedWaysToWinARace = 9;

        long actualWaysToWinARace = race.calculateWaysToWinARace();

        Assertions.assertEquals(expectedWaysToWinARace, actualWaysToWinARace);
    }
}
