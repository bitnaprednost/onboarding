package hr.bp.aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.aoc.day7.TestUtils.getTestInputCorrect;

class GameTest {

    @Test
    void testTotalWinningsTestInput() {
        List<String> input = getTestInputCorrect();
        GameParser gameParser = new GameParser(input);
        Game game = gameParser.parseGameString();

        long expectedTotalWinnings = 6440;

        Assertions.assertEquals(expectedTotalWinnings, game.getTotalWinnings());
    }

}