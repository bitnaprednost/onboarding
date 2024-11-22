package hr.bp.adventofcode.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author Ivan Tomičić
 */
public class ScratchcardTest {

    @Test
    public void calculatePoints() {
        Scratchcard scratchcard = new Scratchcard(
                Set.of(1,2,3,4,5),
                Set.of(1,2,10,11,12,13,14,15)
        );

        int expectedPoints = 2;

        int actualPoints = scratchcard.calculatePoints();

        Assertions.assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void calculatePointsTwo() {
        Scratchcard scratchcard = new Scratchcard(
                Set.of(1,2,3,4,5),
                Set.of(1,2,3,4,5,6,7,8)
        );

        int expectedPoints = 16;

        int actualPoints = scratchcard.calculatePoints();

        Assertions.assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void calculatePointsWhenNoWinningNumber() {
        Scratchcard scratchcard = new Scratchcard(
                Set.of(1,2,3,4,5),
                Set.of(6,7,8,9,10,11,12,13)
        );

        int expectedPoints = 0;

        int actualPoints = scratchcard.calculatePoints();

        Assertions.assertEquals(expectedPoints, actualPoints);
    }
}
