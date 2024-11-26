package hr.bp.adventofcode.day07.taskone;

import org.graalvm.collections.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.adventofcode.day07.taskone.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day07.taskone.TestUtils.getSecondInput;
import static hr.bp.adventofcode.day07.taskone.TestUtils.getFirstInputParsed;

/**
 * @author Ivan Tomičić
 */
public class GameTest {

    @Test
    public void parseInput_givenFirstInput_correctlyParsesInput() {
        String input = getFirstInput();
        Game game = new Game(input);

        List<Pair<Hand, Integer>> expectedListOfHands = getFirstInputParsed();

        List<Pair<Hand, Integer>> actualListOfHands = game.getListOfHands();

        Assertions.assertEquals(expectedListOfHands, actualListOfHands);
    }

    @Test
    public void calculateTotalWinnings_givenFirstInput_returnsCorrectWinnings() {
        String input = getFirstInput();
        Game game = new Game(input);

        int expectedWinnings = 6440;

        int actualWinnings = game.calculateActualWinnings();

        Assertions.assertEquals(expectedWinnings, actualWinnings);
    }

    @Test
    public void calculateTotalWinnings_givenSecondInput_returnsCorrectWinnings() {
        String input = getSecondInput();
        Game game = new Game(input);

        int expectedWinnings = 251287184;

        int actualWinnings = game.calculateActualWinnings();

        Assertions.assertEquals(expectedWinnings, actualWinnings);
    }
}
