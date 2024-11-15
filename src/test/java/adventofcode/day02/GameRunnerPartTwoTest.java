package adventofcode.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static adventofcode.day02.TestUtils.getShortInput;

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

}
