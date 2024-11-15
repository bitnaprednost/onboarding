package adventofcode.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static adventofcode.day02.TestUtils.getShortGameInformation;

public class GameRunnerTest {

    @Test
    public void testSmallMap() {
        Map<Integer, List<Map<ColorEnum, Integer>>> inputGameInformation = getShortGameInformation();
        GameRunner gameRunner = new GameRunner(inputGameInformation);

        Integer expectedIdSum = 5;

        Integer actualIdSum = gameRunner.runGame();

        Assertions.assertEquals(expectedIdSum, actualIdSum);

    }

}
