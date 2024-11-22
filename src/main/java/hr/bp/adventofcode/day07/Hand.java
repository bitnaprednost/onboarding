package hr.bp.adventofcode.day07;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Hand implements Comparable<Hand> {

    private final List<Card> cards;

    public Hand(List<Card> cards) {
        if (cards.size() != 5) {
            throw new IllegalArgumentException("cards array must have exactly 5 elements.");
        }
        this.cards = cards;
    }


    @Override
    public int compareTo(Hand hand) {
        if (hand == null) return 1;

        for (int i = 0; i < 5; i++) {
            int cardComparison = cards.get(i).compareTo(hand.cards.get(i));

            if (cardComparison > 0) return 1;
            else if (cardComparison < 0) return -1;
        }

        return 0;
    }
}
