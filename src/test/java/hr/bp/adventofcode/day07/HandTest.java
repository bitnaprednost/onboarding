package hr.bp.adventofcode.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Tomičić
 */
public class HandTest {

    @Test
    public void compareHands_givenTwoHands_comparesThemCorrectly() {
        Hand hand1 = new Hand (
                new Card[]{Card.A, Card.A, Card.A, Card.A, Card.TWO}
        );

        Hand hand2 = new Hand (
                new Card[]{Card.NINE, Card.A, Card.A, Card.A, Card.TWO}
        );

        int expectedCompareResult = 1;

        int actualCompareResult = hand1.compareTo(hand2);

        Assertions.assertEquals(expectedCompareResult, actualCompareResult);
    }

}
