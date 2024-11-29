package hr.bp.aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class HandTest {
    @Test
    void OnePair_correctHandTypeFound() {
        Hand expectedHand = new Hand(List.of(Card.THREE, Card.TWO, Card.T, Card.THREE, Card.K), 765);
        expectedHand.setHandType(HandType.ONE_PAIR);

        Hand actualHand = new Hand(List.of(Card.THREE, Card.TWO, Card.T, Card.THREE, Card.K), 765);

        Assertions.assertEquals(expectedHand, actualHand);
    }

    @Test
    void FourOfKind_correctHandTypeFound() {
        Hand expectedHand = new Hand(List.of(Card.A, Card.A, Card.T, Card.A, Card.A), 765);
        expectedHand.setHandType(HandType.FOUR_OF_A_KIND);

        Hand actualHand = new Hand(List.of(Card.A, Card.A, Card.T, Card.A, Card.A), 765);

        Assertions.assertEquals(expectedHand, actualHand);
    }

    @Test
    void FullHouse_correctHandTypeFound() {
        Hand expectedHand = new Hand(List.of(Card.A, Card.A, Card.T, Card.T, Card.A), 765);
        expectedHand.setHandType(HandType.FULL_HOUSE);

        Hand actualHand = new Hand(List.of(Card.A, Card.A, Card.T, Card.T, Card.A), 765);

        Assertions.assertEquals(expectedHand, actualHand);
    }

    @Test
    void ThreeOfKind_correctHandTypeFound() {
        Hand expectedHand = new Hand(List.of(Card.A, Card.A, Card.T, Card.EIGHT, Card.A), 765);
        expectedHand.setHandType(HandType.THREE_OF_A_KIND);

        Hand actualHand = new Hand(List.of(Card.A, Card.A, Card.T, Card.EIGHT, Card.A), 765);

        Assertions.assertEquals(expectedHand, actualHand);
    }

}