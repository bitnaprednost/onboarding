package hr.bp.adventofcode.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.day02.TestUtils.getLongInput;
import static hr.bp.adventofcode.day02.TestUtils.getShortInput;

/**
 * @author Ivan Tomičić
 */
public class GameRunnerPartOneTest {

    private GameRunnerPartOne gameRunnerPartOne;

    @BeforeEach
    public void setUp() {
        InputParser inputParser = new InputParser();
        gameRunnerPartOne = new GameRunnerPartOne(inputParser);
    }

    @Test
    public void testSmallMap() {
        String input = getShortInput();
        Integer expectedIdSum = 8;

        Bag bag = new Bag(12, 13, 14);

        Integer actualIdSum = gameRunnerPartOne.calculateSumOfPossibleGameIds(input, bag);

        Assertions.assertEquals(expectedIdSum, actualIdSum);
    }

    @Test
    public void testBigMap() {
        String input = getLongInput();
        Integer expectedIdSum = 2447;

        Bag bag = new Bag(12, 13, 14);

        Integer actualIdSum = gameRunnerPartOne.calculateSumOfPossibleGameIds(input, bag);

        Assertions.assertEquals(expectedIdSum, actualIdSum);
    }
}
