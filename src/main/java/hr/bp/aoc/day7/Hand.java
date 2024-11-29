package hr.bp.aoc.day7;

import java.util.*;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    private HandType handType;
    private int bid;

    public Hand(List<Card> cards, int bid) {
        if (cards.size() != 5)
            throw new IllegalArgumentException("Number of cards in hand has to be 5!");

        this.cards = cards;
        this.bid = bid;

        setHandType(findHandType());
    }

    public void setHandType(HandType type) {
        this.handType = type;
    }

    private HandType findHandType() {
        HandType handType = HandType.HIGH_CARD;
        Map<Card, Integer> frequencies = getFrequencies();

        Card maxFrequencyCard = Collections.max(frequencies.entrySet(), Map.Entry.comparingByValue()).getKey();
        int maxFrequency = frequencies.get(maxFrequencyCard);

        if (maxFrequency == 5) {
            handType = HandType.FIVE_OF_A_KIND;
        } else if (maxFrequency == 4) {
            handType = HandType.FOUR_OF_A_KIND;
        } else if (maxFrequency == 3) {
            if (checkIfPairExists(frequencies, maxFrequencyCard)) {
                handType = HandType.FULL_HOUSE;
            } else {
                handType = HandType.THREE_OF_A_KIND;
            }
        } else if (maxFrequency == 2) {
            if (checkIfPairExists(frequencies, maxFrequencyCard)) {
                handType = HandType.TWO_PAIR;
            } else {
                handType = HandType.ONE_PAIR;
            }
        }

        return handType;
    }

    private boolean checkIfPairExists(Map<Card, Integer> frequencies, Card ignoreCard) {
        for (Card card : frequencies.keySet()) {
            if (frequencies.get(card) == 2 && !card.equals(ignoreCard))
                return true;
        }

        return false;
    }

    private Map<Card, Integer> getFrequencies() {
        Map<Card, Integer> frequencies = new HashMap<>();

        for (Card card : cards) {
            frequencies.merge(card, 1, Integer::sum);
        }

        return frequencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Hand hand = (Hand) o;
        return bid == hand.bid && cardsEqual(((Hand) o).cards) && Objects.equals(handType, hand.handType);
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
        return Integer.compare(handType.getPoints(), hand.handType.getPoints());
    }

    private int compareCards(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            if (!cards.get(i).equals(this.cards.get(i))) {
                return Integer.compare((this.cards.get(i).getPoints()), cards.get(i).getPoints());
            }
        }
        return 0;
    }

    public int getBid() {
        return bid;
    }
}
