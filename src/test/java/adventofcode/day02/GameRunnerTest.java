package adventofcode.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static adventofcode.day02.TestUtils.getShortGameInformation;

public class GameRunnerTest {

    private static final GameRunner gameRunner = new GameRunner();

    @Test
    public void testSmallMap() {
        Map<Integer, List<Map<ColorEnum, Integer>>> inputGameInformation = getShortGameInformation();

        Integer expectedIdSum = 12;

        Integer actualIdSum = gameRunner.runGame(inputGameInformation);

        Assertions.assertEquals(expectedIdSum, actualIdSum);

    }

}
