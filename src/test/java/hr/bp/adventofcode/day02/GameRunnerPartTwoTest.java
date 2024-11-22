package hr.bp.adventofcode.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.day02.TestUtils.getLongInput;
import static hr.bp.adventofcode.day02.TestUtils.getShortInput;

public class GameRunnerPartTwoTest {

    private GameRunnerPartTwo gameRunnerPartTwo;

    @BeforeEach
    public void setUp() {
        InputParser inputParser = new InputParser();
        gameRunnerPartTwo = new GameRunnerPartTwo(inputParser);
    }

    @Test
    public void testSmallMap() {
        String input = getShortInput();
        Integer expectedIdSum = 2286;

        Integer actualIdSum = gameRunnerPartTwo.calculateSumOfPowerOfSets(input);

        Assertions.assertEquals(expectedIdSum, actualIdSum);
    }

    @Test
    public void testBigMap() {
        String input = getLongInput();
        Integer expectedIdSum = 56322;

        Integer actualIdSum = gameRunnerPartTwo.calculateSumOfPowerOfSets(input);

        Assertions.assertEquals(expectedIdSum, actualIdSum);
    }

}
