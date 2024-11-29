package hr.bp.aoc.day7;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    private HandType handType;
    private int bid;

    public Hand(List<Card> cards, int bid) {
        if (cards.size() != 5)
            throw new IllegalArgumentException("Number of cards in hand has to be 5!");

        this.cards = cards;
        this.bid = bid;

        setHandType(List.copyOf(cards));
    }

    private void setHandType(List<Card> cards) {

        this.handType = findHandType(cards);
    }

    private HandType findHandType(List<Card> cards) {
        int equalCards = 0;

        return HandType.FOUR_OF_A_KIND;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Hand hand = (Hand) o;
        return bid == hand.bid && cardsEqual(((Hand) o).cards) && Objects.equals(handType,
                hand.handType);
    }

    private boolean cardsEqual(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            if (!cards.get(i).equals(this.cards.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, handType, bid);
    }


    @Override
    public int compareTo(Hand hand) {
        if (handType.equals(hand.handType)) {
            return compareCards(hand.cards);
        }

        return handType.compareTo(hand.handType);
    }

    private int compareCards(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            if (!cards.get(i).equals(this.cards.get(i))) {
                return cards.get(i).compareTo(this.cards.get(i));
            }
        }
        return 0;
    }
}
