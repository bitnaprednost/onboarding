package aoc_2023.day7;

import java.util.*;

public class CamelCardsWithJoker extends CamelCards {

    // Define the character ranking
    private static final Map<Character, Integer> cardStrength = new HashMap<>();
    static {
        cardStrength.put('A', 13);
        cardStrength.put('K', 12);
        cardStrength.put('Q', 11);
        cardStrength.put('T', 10);
        cardStrength.put('9', 9);
        cardStrength.put('8', 8);
        cardStrength.put('7', 7);
        cardStrength.put('6', 6);
        cardStrength.put('5', 5);
        cardStrength.put('4', 4);
        cardStrength.put('3', 3);
        cardStrength.put('2', 2);
        cardStrength.put('J', 1);
    }

    public int calculateWinning (String camelCards) {

        // Split the file content into lines
        String[] lines = camelCards.split(System.lineSeparator());

        HandTypes handTypes = new HandTypes();

        // Add each line to hand type
        for (String line : lines)
        {
            String hand = line.split(" ")[0].trim();
            int bit = Integer.parseInt(line.split(" ")[1].trim());

            if (hand.contains("J"))
            {
                useJoker(hand, bit, handTypes);
            }
            else
            {
                handTypes.GetHandType(hand, bit);
            }
        }
        return evaluateCards(handTypes, cardStrength);
    }


    public void useJoker (String hand, int bit, HandTypes handTypes) {
        // Define card rank order
        Map<Character, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < hand.length(); i++)
        {
            rankMap.put(hand.charAt(i), cardStrength.get(hand.charAt(i)));
        }

        // Count occurrences of each character
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : hand.toCharArray())
        {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Find the character with the highest count, resolving ties by rank
        Character bestChar = null;
        int maxCount = 0;
        int bestRank = 0;

        for (Map.Entry<Character, Integer> entry : charCounts.entrySet())
        {

            if (entry.getKey() != 'J')
            {
                char card = entry.getKey();
                int count = entry.getValue();
                int rank = rankMap.get(card);

                // Update best character if:
                // 1. Current count is greater than maxCount
                // 2. Counts are equal but current rank is higher
                if (count > maxCount || (count == maxCount && rank > bestRank))
                {
                    bestChar = card;
                    maxCount = count;
                    bestRank = rank;
                }
            }
        }

        String CopyOfHand = hand;
        CopyOfHand = CopyOfHand.replaceAll("J", String.valueOf(bestChar));

        handTypes.CheckHandType(CopyOfHand, bit).add(new AbstractMap.SimpleEntry<>(hand,bit));
    }
}
