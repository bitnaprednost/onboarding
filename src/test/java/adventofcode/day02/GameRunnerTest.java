package adventofcode.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static adventofcode.day02.TestUtils.getShortInput;

public class GameRunnerTest {

    private GameRunner gameRunner;
    private InputParser inputParser;

    @BeforeEach
    public void setUp() {
        inputParser = new InputParser();
        gameRunner = new GameRunner(inputParser);
    }

    @Test
    public void testSmallMap() {
        String input = getShortInput();
        Integer expectedIdSum = 8;

        Bag bag = new Bag(12, 13, 14);

        Integer actualIdSum = gameRunner.calculateSumOfPossibleGameIds(input, bag);

        Assertions.assertEquals(expectedIdSum, actualIdSum);
    }

}
