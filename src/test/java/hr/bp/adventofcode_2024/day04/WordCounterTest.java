package hr.bp.adventofcode_2024.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        int actualOccurrences = xmasCounter.countXMASOccurences();

        Assertions.assertEquals(expectedOccurrences, actualOccurrences);
    }
}
