package hr.bp.adventofcode.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class HandTest {

    @Test
    public void compareHands_givenFirstHandStrongerThanSecondHand_comparesThemCorrectly() {
        Hand hand1 = new Hand (
                List.of(Card.A, Card.A, Card.A, Card.A, Card.TWO),
                false);

        Hand hand2 = new Hand (
                List.of(Card.NINE, Card.A, Card.A, Card.A, Card.TWO),
                false);

        int expectedCompareResult = 1;

        int actualCompareResult = hand1.compareTo(hand2);

        Assertions.assertEquals(expectedCompareResult, actualCompareResult);
    }

    @Test
    public void compareHands_givenFirstHandWeakerThanSecondHand_comparesThemCorrectly() {
        Hand hand1 = new Hand (
                List.of(Card.A, Card.A, Card.A, Card.A, Card.TWO),
                false);

        Hand hand2 = new Hand (
                List.of(Card.A, Card.A, Card.A, Card.A, Card.THREE),
                false);

        int expectedCompareResult = -1;

        int actualCompareResult = hand1.compareTo(hand2);

        Assertions.assertEquals(expectedCompareResult, actualCompareResult);
    }

    @Test
    public void compareHands_givenFirstHandEqualToSecondHand_comparesThemCorrectly() {
        Hand hand1 = new Hand (
                List.of(Card.A, Card.A, Card.A, Card.A, Card.TWO),
                false);

        Hand hand2 = new Hand (
                List.of(Card.A, Card.A, Card.A, Card.A, Card.TWO),
                false);

        int expectedCompareResult = 0;

        int actualCompareResult = hand1.compareTo(hand2);

        Assertions.assertEquals(expectedCompareResult, actualCompareResult);
    }

    @Test
    public void compareHandsWithJokers_givenFirstHandStrongerThanSecondHand_comparesThemCorrectly() {
        Hand hand1 = new Hand (
                List.of(Card.Q, Card.Q, Card.Q, Card.Q, Card.TWO),
                true);

        Hand hand2 = new Hand (
                List.of(Card.J, Card.K, Card.K, Card.K, Card.TWO),
                true);

        int expectedCompareResult = 1;

        int actualCompareResult = hand1.compareTo(hand2);

        Assertions.assertEquals(expectedCompareResult, actualCompareResult);
    }

    @Test
    public void compareHandsWithJokers_givenFirstHandWeakerThanSecondHand_comparesThemCorrectly() {
        Hand hand1 = new Hand (
                List.of(Card.A, Card.A, Card.A, Card.TWO, Card.TWO),
                true);

        Hand hand2 = new Hand (
                List.of(Card.A, Card.A, Card.J, Card.J, Card.TWO),
                true);

        int expectedCompareResult = -1;

        int actualCompareResult = hand1.compareTo(hand2);

        Assertions.assertEquals(expectedCompareResult, actualCompareResult);
    }

}
