package hr.bp.aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.aoc.day7.TestUtils.getFinalInputCorrect;
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

    @Test
    void testTotalWinningsFinalInput() {
        List<String> input = getFinalInputCorrect();
        GameParser gameParser = new GameParser(input);
        Game game = gameParser.parseGameString();

        long expectedTotalWinnings = 249390788;

        Assertions.assertEquals(expectedTotalWinnings, game.getTotalWinnings());
    }

    @Test
    void JokerTestTotalWinningsTestInput() {
        List<String> input = getTestInputCorrect();
        GameParser gameParser = new GameParser(input, true);
        Game game = gameParser.parseGameString();

        long expectedTotalWinnings = 5905;

        Assertions.assertEquals(expectedTotalWinnings, game.getTotalWinnings());
    }

    @Test
    void JokerTestTotalWinningsFinalInput() {
        List<String> input = getFinalInputCorrect();
        GameParser gameParser = new GameParser(input, true);
        Game game = gameParser.parseGameString();

        long expectedTotalWinnings = 248750248;

        Assertions.assertEquals(expectedTotalWinnings, game.getTotalWinnings());
    }

}