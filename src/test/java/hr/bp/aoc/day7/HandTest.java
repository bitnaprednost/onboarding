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

    @Test
    void CompareSameHandType_FirstCardDifferent() {
        Hand greaterHand = new Hand(List.of(Card.THREE, Card.THREE, Card.THREE, Card.THREE, Card.TWO), 765);
        Hand lesserHand = new Hand(List.of(Card.TWO, Card.A, Card.A, Card.A, Card.A), 765);

        Assertions.assertEquals(1, greaterHand.compareTo(lesserHand));
    }

    @Test
    void CompareSameHandType_DifferentCardNotFirst() {
        Hand greaterHand = new Hand(List.of(Card.SEVEN, Card.SEVEN, Card.EIGHT, Card.EIGHT, Card.EIGHT), 765);
        Hand lesserHand = new Hand(List.of(Card.SEVEN, Card.SEVEN, Card.SEVEN, Card.EIGHT, Card.EIGHT), 765);

        Assertions.assertEquals(1, greaterHand.compareTo(lesserHand));
    }

    @Test
    void CompareSameHandType_KK677_KTJJT() {
        Hand greaterHand = new Hand(List.of(Card.K, Card.K, Card.SIX, Card.SEVEN, Card.SEVEN), 28);
        Hand lesserHand = new Hand(List.of(Card.K, Card.T, Card.J, Card.J, Card.T), 220);

        Assertions.assertEquals(1, greaterHand.compareTo(lesserHand));
    }

    @Test
    void CompareSameHandType_QQQJA_T55J5() {
        Hand greaterHand = new Hand(List.of(Card.Q, Card.Q, Card.Q, Card.J, Card.A), 483);
        Hand lesserHand = new Hand(List.of(Card.T, Card.FIVE, Card.FIVE, Card.J, Card.FIVE), 2684);

        Assertions.assertEquals(1, greaterHand.compareTo(lesserHand));
    }

    @Test
    void CompareSameHandType_QQQJA_KK677() {
        Hand greaterHand = new Hand(List.of(Card.Q, Card.Q, Card.Q, Card.J, Card.A), 483);
        Hand lesserHand = new Hand(List.of(Card.K, Card.K, Card.SIX, Card.SEVEN, Card.SEVEN), 28);

        Assertions.assertEquals(1, greaterHand.compareTo(lesserHand));
    }

    @Test
    void Compare_withJoker_Q2QQQ_QJQQ2() {
        Hand greaterHand = new Hand(List.of(Card.Q, Card.TWO, Card.Q, Card.Q, Card.Q), 483, true);
        Hand lesserHand = new Hand(List.of(Card.Q, Card.J, Card.Q, Card.Q, Card.TWO), 483, true);

        Assertions.assertEquals(1, greaterHand.compareTo(lesserHand));
    }

    @Test
    void Compare_withJoker_Q2QQQ_JJJJQ() {
        Hand lesserHand = new Hand(List.of(Card.Q, Card.TWO, Card.Q, Card.Q, Card.Q), 483, true);
        Hand greaterHand = new Hand(List.of(Card.J, Card.J, Card.J, Card.J, Card.Q), 483, true);

        Assertions.assertEquals(1, greaterHand.compareTo(lesserHand));
    }

}