package hr.bp.adventofcode_2024.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode_2024.Utils.readInputForDay;
import static hr.bp.adventofcode_2024.day05.TestUtils.getFirstInput;

/**
 * @author Ivan Tomičić
 */
public class PageProcessorTest {

    @Test
    public void calculateSumOfMiddleNumbers_givenInputOne_returnsCorrectSum() {
        String input = getFirstInput();
        PageProcessor pageProcessor = new PageProcessor(input);

        int expectedSum = 143;

        int actualSum = pageProcessor.calculateSumOfMiddleNumbers();

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateSumOfMiddleNumbers_givenTaskInput_returnsCorrectSum() {
        String input = readInputForDay("day05");
        PageProcessor pageProcessor = new PageProcessor(input);

        int expectedSum = 4996;

        int actualSum = pageProcessor.calculateSumOfMiddleNumbers();

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void calculateSumOfMiddleNumbersForUnorderedPages_givenInputOne_returnsCorrectSum() {
        String input = getFirstInput();
        PageProcessor pageProcessor = new PageProcessor(input);

        int expectedSum = 123;

        int actualSum = pageProcessor.calculateSumOfMiddleNumbersForUnorderedPages();

        Assertions.assertEquals(expectedSum, actualSum);
    }
}
