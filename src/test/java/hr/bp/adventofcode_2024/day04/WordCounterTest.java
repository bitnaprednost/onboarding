package hr.bp.adventofcode_2024.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode_2024.Utils.readInputForDay;
import static hr.bp.adventofcode_2024.day04.TestUtils.getFirstInput;

/**
 * @author Ivan Tomičić
 */
public class WordCounterTest {

    @Test
    public void countXMAS_givenInputOne_returnsCorrectCount() {
        String input = getFirstInput();
        WordCounter xmasCounter = new WordCounter(input);

        int expectedOccurrences = 18;

        int actualOccurrences = xmasCounter.countWordOccurrences("XMAS");

        Assertions.assertEquals(expectedOccurrences, actualOccurrences);
    }

    @Test
    public void countXMAS_givenTaskInput_returnsCorrectCount() {
        String input = readInputForDay("day04");
        WordCounter xmasCounter = new WordCounter(input);

        int expectedOccurrences = 2654;

        int actualOccurrences = xmasCounter.countWordOccurrences("XMAS");

        Assertions.assertEquals(expectedOccurrences, actualOccurrences);
    }

    @Test
    public void countX_MASes_givenInputOne_returnsCorrectCount() {
        String input = getFirstInput();
        WordCounter xmasCounter = new WordCounter(input);

        int expectedOccurrences = 9;

        int actualOccurrences = xmasCounter.countX_MASes();

        Assertions.assertEquals(expectedOccurrences, actualOccurrences);
    }

    @Test
    public void countX_MASes_givenTaskInput_returnsCorrectCount() {
        String input = readInputForDay("day04");
        WordCounter xmasCounter = new WordCounter(input);

        int expectedOccurrences = 1990;

        int actualOccurrences = xmasCounter.countX_MASes();

        Assertions.assertEquals(expectedOccurrences, actualOccurrences);
    }
}
