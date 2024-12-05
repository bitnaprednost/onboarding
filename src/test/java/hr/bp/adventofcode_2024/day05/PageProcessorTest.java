package hr.bp.adventofcode_2024.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode_2024.day05.TestUtils.getFirstInput;

/**
 * @author Ivan Tomičić
 */
public class PageProcessorTest {

    @Test
    public void calculateSumOfMiddlePages_givenInputOne_returnsCorrectSum() {
        String input = getFirstInput();
        PageProcessor pageProcessor = new PageProcessor(input);

        int expectedSum = 143;

        int actualSum = pageProcessor.calculateSumOfMiddleNumbers();

        Assertions.assertEquals(expectedSum, actualSum);
    }
}
