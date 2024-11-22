package hr.bp.adventofcode.day07;

import org.graalvm.collections.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.adventofcode.day07.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day07.TestUtils.getFirstInputParsed;

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
}
