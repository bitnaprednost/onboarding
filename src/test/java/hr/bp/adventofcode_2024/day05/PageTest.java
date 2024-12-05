package hr.bp.adventofcode_2024.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static hr.bp.adventofcode_2024.day05.TestUtils.getPageOrderingRules;

/**
 * @author Ivan Tomičić
 */
public class PageTest {

    private HashMap<Integer, List<Integer>> pageOrderingRules = getPageOrderingRules();

    @Test
    public void pagesAreInRightOrder_givenInputOne_returnsCorrectResult() {
        List<Integer> pageNumbers = new ArrayList<>(List.of(75,47,61,53,29));
        Page page = new Page(pageNumbers, pageOrderingRules);

        boolean expectedAreInRightOrder = true;

        boolean actualAreInRightOrder = page.hasNumbersInRightOrder();

        Assertions.assertEquals(expectedAreInRightOrder, actualAreInRightOrder);
    }

    @Test
    public void pagesAreInRightOrder_givenInputTwo_returnsCorrectResult() {
        List<Integer> pageNumbers = new ArrayList<>(List.of(97,61,53,29,13));
        Page page = new Page(pageNumbers, pageOrderingRules);

        boolean expectedAreInRightOrder = true;

        boolean actualAreInRightOrder = page.hasNumbersInRightOrder();

        Assertions.assertEquals(expectedAreInRightOrder, actualAreInRightOrder);
    }

    @Test
    public void pagesAreInRightOrder_givenInputThree_returnsCorrectResult() {
        List<Integer> pageNumbers = new ArrayList<>(List.of(75,29,13));
        Page page = new Page(pageNumbers, pageOrderingRules);

        boolean expectedAreInRightOrder = true;

        boolean actualAreInRightOrder = page.hasNumbersInRightOrder();

        Assertions.assertEquals(expectedAreInRightOrder, actualAreInRightOrder);
    }

    @Test
    public void pagesAreInRightOrder_givenInputFour_returnsCorrectResult() {
        List<Integer> pageNumbers = new ArrayList<>(List.of(75,97,47,61,53));
        Page page = new Page(pageNumbers, pageOrderingRules);

        boolean expectedAreInRightOrder = false;

        boolean actualAreInRightOrder = page.hasNumbersInRightOrder();

        Assertions.assertEquals(expectedAreInRightOrder, actualAreInRightOrder);
    }

    @Test
    public void pagesAreInRightOrder_givenInputFive_returnsCorrectResult() {
        List<Integer> pageNumbers = new ArrayList<>(List.of(61,13,29));
        Page page = new Page(pageNumbers, pageOrderingRules);

        boolean expectedAreInRightOrder = false;

        boolean actualAreInRightOrder = page.hasNumbersInRightOrder();

        Assertions.assertEquals(expectedAreInRightOrder, actualAreInRightOrder);
    }

    @Test
    public void orderNumbers_givenInputFive_correctlyOrdersNumbers() {
        List<Integer> pageNumbers = new ArrayList<>(List.of(61,13,29));
        Page page = new Page(pageNumbers, pageOrderingRules);
        page.orderNumbers();

        int expectedMiddleNumber = 29;

        int actualMiddleNumber = page.getMiddleNumber();

        Assertions.assertEquals(expectedMiddleNumber, actualMiddleNumber);
    }

    @Test
    public void orderNumbers_givenInputFour_correctlyOrdersNumbers() {
        List<Integer> pageNumbers = new ArrayList<>(List.of(75,97,47,61,53));
        Page page = new Page(pageNumbers, pageOrderingRules);
        page.orderNumbers();

        int expectedMiddleNumber = 47;

        int actualMiddleNumber = page.getMiddleNumber();

        Assertions.assertEquals(expectedMiddleNumber, actualMiddleNumber);
    }

    @Test
    public void orderNumbers_givenInputSix_correctlyOrdersNumbers() {
        List<Integer> pageNumbers = new ArrayList<>(List.of(97,13,75,29,47));
        Page page = new Page(pageNumbers, pageOrderingRules);
        page.orderNumbers();

        int expectedMiddleNumber = 47;

        int actualMiddleNumber = page.getMiddleNumber();

        Assertions.assertEquals(expectedMiddleNumber, actualMiddleNumber);
    }
}
