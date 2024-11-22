package hr.bp.adventofcode.day07;

/**
 * @author Ivan Tomičić
 */
public class Hand implements Comparable<Hand> {

    private final Card[] cards;

    public Hand(Card[] cards) {
        if (cards.length != 5) {
            throw new IllegalArgumentException("cards array must have exactly 5 elements.");
        }
        this.cards = cards;
    }


    @Override
    public int compareTo(Hand hand) {
        if (hand == null) return 1;

        for (int i = 0; i < 5; i++) {
            int cardComparison = cards[i].compareTo(hand.cards[i]);

            if (cardComparison > 0) return 1;
            else if (cardComparison < 0) return -1;
        }

        return 0;
    }
}
