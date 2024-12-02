package aoc_2023.day7;

import java.util.*;

public class HandTypes {
    private List<Map.Entry<String, Integer>> FiveOfAKind = new ArrayList<>();
    private List<Map.Entry<String, Integer>> FourOfAKind = new ArrayList<>();
    private List<Map.Entry<String, Integer>> FullHouse   = new ArrayList<>();
    private List<Map.Entry<String, Integer>> ThreeOfAKind = new ArrayList<>();
    private List<Map.Entry<String, Integer>> TwoPair = new ArrayList<>();
    private List<Map.Entry<String, Integer>> OnePair = new ArrayList<>();
    private List<Map.Entry<String, Integer>> HighCard = new ArrayList<>();


    // Get methods
    public List<Map.Entry<String, Integer>> getFiveOfAKind() {
        return FiveOfAKind;
    }

    public List<Map.Entry<String, Integer>> getFourOfAKind() {
        return FourOfAKind;
    }

    public List<Map.Entry<String, Integer>> getFullHouse() {
        return FullHouse;
    }

    public List<Map.Entry<String, Integer>> getThreeOfAKind() {
        return ThreeOfAKind;
    }

    public List<Map.Entry<String, Integer>> getTwoPair() {
        return TwoPair;
    }

    public List<Map.Entry<String, Integer>> getOnePair() {
        return OnePair;
    }

    public List<Map.Entry<String, Integer>> getHighCard() {
        return HighCard;
    }

    // Get hand type
    public void GetHandType (String hand, int bit) {

        if (hasAnyCharXTimes(hand, 5))
        {
            this.FiveOfAKind.add(new AbstractMap.SimpleEntry<>(hand,bit));
        }
        else if (hasAnyCharXTimes(hand, 4))
        {
            this.FourOfAKind.add(new AbstractMap.SimpleEntry<>(hand,bit));
        }
        else if (hasAnyCharXTimes(hand, 3) && hasAnyCharXTimes(hand, 2))
        {
            this.FullHouse.add(new AbstractMap.SimpleEntry<>(hand,bit));
        }
        else if (hasAnyCharXTimes(hand, 3))
        {
            this.ThreeOfAKind.add(new AbstractMap.SimpleEntry<>(hand,bit));
        }
        else if (hasAnyCharXTimes(hand, 2, 2))
        {
            this.TwoPair.add(new AbstractMap.SimpleEntry<>(hand,bit));
        }
        else if (hasAnyCharXTimes(hand, 2))
        {
            this.OnePair.add(new AbstractMap.SimpleEntry<>(hand,bit));
        }
        else if (hasAnyCharXTimes(hand, 1))
        {
            this.HighCard.add(new AbstractMap.SimpleEntry<>(hand,bit));
        }
    }

    // Check hand type
    public List<Map.Entry<String, Integer>> CheckHandType (String hand, int bit) {

        if (hasAnyCharXTimes(hand, 5))
        {
            return getFiveOfAKind();
        }
        else if (hasAnyCharXTimes(hand, 4))
        {
            return getFourOfAKind();
        }
        else if (hasAnyCharXTimes(hand, 3) && hasAnyCharXTimes(hand, 2))
        {
            return getFullHouse();
        }
        else if (hasAnyCharXTimes(hand, 3))
        {
            return getThreeOfAKind();
        }
        else if (hasAnyCharXTimes(hand, 2, 2))
        {
            return getTwoPair();
        }
        else if (hasAnyCharXTimes(hand, 2))
        {
            return getOnePair();
        }
        else
        {
            return getHighCard();
        }

    }

    // Helper methods
    public static boolean hasAnyCharXTimes(String str, int x, int pair) {
        HashMap<Character, Integer> charCounts = new HashMap<>();

        // Count occurrences of each character
        for (char c : str.toCharArray())
        {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Check for repetition
        int repetition = 0;

        // Check if any character appears x times
        for (int count : charCounts.values())
        {
            if (count == x)
            {
                repetition++;
            }
        }
        return repetition == pair;
    }

    public static boolean hasAnyCharXTimes(String str, int x) {
        HashMap<Character, Integer> charCounts = new HashMap<>();

        // Count occurrences of each character
        for (char c : str.toCharArray())
        {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Check if any character appears x times
        for (int count : charCounts.values())
        {
            if (count == x)
            {
                return true;
            }
        }
        return false;
    }
}
