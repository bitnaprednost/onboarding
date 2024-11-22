package hr.bp.adventofcode.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.day02.TestUtils.getShortInput;

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

}
