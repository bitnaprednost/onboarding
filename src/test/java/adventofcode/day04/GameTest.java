package adventofcode.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static adventofcode.day04.TestUtils.getInputAllWinningNumbers;
import static adventofcode.day04.TestUtils.getInputNoWinningNumber;
import static adventofcode.day04.TestUtils.getInputOne;
import static adventofcode.day04.TestUtils.getInputTwo;
import static adventofcode.day04.TestUtils.getListOfScratchcardsForInputOne;

/**
 * @author Ivan Tomičić
 */
public class GameTest {

    @Test
    public void constructor_givenValidInput_createsGameWithExpectedScratchcards() {
        String input = getInputOne();
        Game game = new Game(input);

        Map<Integer, Scratchcard> expectedScratchcards = getListOfScratchcardsForInputOne();

        Map<Integer, Scratchcard> actualScratchcards = game.getScratchcards();

        Assertions.assertEquals(expectedScratchcards, actualScratchcards);
    }

    @Test
    public void calculateTotalPoints_givenInputOne_returnsExpectedPoints() {
        String input = getInputOne();
        Game game = new Game(input);

        int expectedTotalPoints = 13;

        int actualTotalPoints = game.calculateTotalPoints();

        Assertions.assertEquals(expectedTotalPoints, actualTotalPoints);
    }

    @Test
    public void calculateTotalPoints_givenInputTwo_returnsExpectedPoints() {
        String input = getInputTwo();
        Game game = new Game(input);

        int expectedTotalPoints = 15;

        int actualTotalPoints = game.calculateTotalPoints();

        Assertions.assertEquals(expectedTotalPoints, actualTotalPoints);
    }

    @Test
    public void calculateTotalPoints_givenAllWinningNumbers_returnsMaximumPoints() {
        String input = getInputAllWinningNumbers();
        Game game = new Game(input);

        int expectedTotalPoints = 32;

        int actualTotalPoints = game.calculateTotalPoints();

        Assertions.assertEquals(expectedTotalPoints, actualTotalPoints);
    }

    @Test
    public void calculateTotalPoints_givenNoWinningNumbers_returnsZeroPoints() {
        String input = getInputNoWinningNumber();
        Game game = new Game(input);

        int expectedTotalPoints = 0;

        int actualTotalPoints = game.calculateTotalPoints();

        Assertions.assertEquals(expectedTotalPoints, actualTotalPoints);
    }

    @Test
    public void calculateTotalScratchcardsWon_givenInputOne_returnsExpectedTotal() {
        String input = getInputOne();
        Game game = new Game(input);

        int expectedTotalScratchcards = 30;

        int actualTotalScratchcards = game.calculateTotalScratchcardsWon();

        Assertions.assertEquals(expectedTotalScratchcards, actualTotalScratchcards);
    }

    @Test
    public void calculateTotalScratchcardsWon_givenNoAdditionalScratchcards_returnsSix() {
        String input = getInputNoWinningNumber();
        Game game = new Game(input);

        int expectedTotalScratchcards = 6;

        int actualTotalScratchcards = game.calculateTotalScratchcardsWon();

        Assertions.assertEquals(expectedTotalScratchcards, actualTotalScratchcards);
    }
}
