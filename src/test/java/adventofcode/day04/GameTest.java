package adventofcode.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static adventofcode.day04.TestUtils.getInputOne;
import static adventofcode.day04.TestUtils.getListOfScratchcardsForInputOne;

/**
 * @author Ivan Tomičić
 */
public class GameTest {

    @Test
    public void testConstructionOfGame() {
        String input = getInputOne();
        Game game = new Game(input);

        List<Scratchcard> expectedScratchcards = getListOfScratchcardsForInputOne();

        List<Scratchcard> actualScratchcards = game.getScratchcards();

        Assertions.assertEquals(expectedScratchcards, actualScratchcards);
    }
}
