package hr.bp.adventofcode.day07;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Ivan Tomičić
 */
public class Hand implements Comparable<Hand> {

    private final List<Card> cards;
    private HandKind handKind;
    private boolean usesJokerCard;

    public Hand(List<Card> cards, boolean usesJokerCard) {
        if (cards.size() != 5) {
            throw new IllegalArgumentException("cards array must have exactly 5 elements.");
        }
        this.usesJokerCard = usesJokerCard;
        this.cards = cards;
        setHandKind();
    }


    @Override
    public int compareTo(Hand hand) {
        if (hand == null) return 1;

        if(this.handKind.compareTo(hand.handKind) > 0) return 1;
        else if(this.handKind.compareTo(hand.handKind) < 0) return -1;

        else return compareCardStrengths(hand);
    }

    private Integer compareCardStrengths(Hand hand) {
        for (int i = 0; i < 5; i++) {
            if (usesJokerCard) {  // Override default enum comparison if usesJokerCard = true -> in this case J is always the lowest Card
                if (cards.get(i).equals(Card.J) && !hand.cards.get(i).equals(Card.J)) return -1;
                else if (!cards.get(i).equals(Card.J) && hand.cards.get(i).equals(Card.J)) return 1;
            }
            int cardComparison = cards.get(i).compareTo(hand.cards.get(i));

            if (cardComparison > 0) return 1;
            else if (cardComparison < 0) return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hand hand)) return false;
        return Objects.equals(cards, hand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cards);
    }

    private void setHandKind() {
        Map<Card, Integer> cardCounts = this.cards.stream().collect(
                Collectors.groupingBy(card -> card, Collectors.summingInt(value -> 1)));

        if (usesJokerCard) {
            replaceJokerWithCards(cardCounts);
        }


        if (cardCounts.containsValue(5)) {
            this.handKind = HandKind.FIVE_OF_A_KIND;
        } else if (cardCounts.containsValue(4)) {
            this.handKind = HandKind.FOUR_OF_A_KIND;
        } else if (cardCounts.containsValue(3) && cardCounts.containsValue(2)) {
            this.handKind = HandKind.FULL_HOUSE;
        } else if (cardCounts.containsValue(3) && cardCounts.containsValue(1)) {
            this.handKind = HandKind.THREE_OF_A_KIND;
        } else if (hasTwoPair(cardCounts)) {
            this.handKind = HandKind.TWO_PAIR;
        } else if (hasOnePair(cardCounts)) {
            this.handKind = HandKind.ONE_PAIR;
        } else {
            this.handKind = HandKind.HIGH_CARD;
        }
    }

    private void replaceJokerWithCards(Map<Card, Integer> cardCounts) {
        if (cardCounts.containsKey(Card.J) && cardCounts.size() > 1) {
            int jokerValue = cardCounts.get(Card.J);

            Card maxKey = cardCounts.entrySet().stream()
                    .filter(entry -> !entry.getKey().equals(Card.J))
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);

            if (maxKey != null) {
                cardCounts.put(maxKey, cardCounts.get(maxKey) + jokerValue);
            }

            cardCounts.remove(Card.J);
        }
    }

    private static boolean hasTwoPair(Map<Card, Integer> cardCounts) {
        return cardCounts.values().stream().filter(a -> a == 2).count() == 2;
    }

    private static boolean hasOnePair(Map<Card, Integer> cardCounts) {
        return cardCounts.values().stream().filter(a -> a == 2).count() == 1 &&
                cardCounts.values().stream().filter(a -> a == 1).count() == 3;
    }
}
