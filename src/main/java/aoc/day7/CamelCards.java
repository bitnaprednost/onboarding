package aoc.day7;

import java.util.*;

public class CamelCards {

    // Define the character ranking
    private static final Map<Character, Integer> cardStrength = new HashMap<>();
    static {
        cardStrength.put('A', 13);
        cardStrength.put('K', 12);
        cardStrength.put('Q', 11);
        cardStrength.put('J', 10);
        cardStrength.put('T', 9);
        cardStrength.put('9', 8);
        cardStrength.put('8', 7);
        cardStrength.put('7', 6);
        cardStrength.put('6', 5);
        cardStrength.put('5', 4);
        cardStrength.put('4', 3);
        cardStrength.put('3', 2);
        cardStrength.put('2', 1);
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

            handTypes.GetHandType(hand, bit);
        }
        return evaluateCards(handTypes, cardStrength);
    }


    // Convert hand to a list of card strengths
    private static List<Integer> convertHandToCardStrengths(String hand, Map<Character, Integer> cardStrength) {
        List<Integer> handStrength = new ArrayList<>();
        for (int i = 0; i < hand.length(); i++)
        {
            handStrength.add(cardStrength.get(hand.charAt(i)));
        }
        return handStrength;
    }


    // Sort the list based on hand strength
    public static void sortHandsByStrength(List<Map.Entry<String, Integer>> hands, Map<Character, Integer> cardStrength) {
        hands.sort((o1, o2) -> {
            // Convert hands to strength values using the provided cardStrength map
            List<Integer> hand1Strength = convertHandToCardStrengths(o1.getKey(), cardStrength);
            List<Integer> hand2Strength = convertHandToCardStrengths(o2.getKey(), cardStrength);

            // Sort hands
            for (int i = 0; i < 5; i++)
            {
                if (!hand1Strength.get(i).equals(hand2Strength.get(i)))
                {
                    return Integer.compare(hand1Strength.get(i), hand2Strength.get(i));
                }
            }
            return Integer.compare(o1.getValue(), o2.getValue());
        });
    }


    // Get bit amount
    public static int getBitAmount(List<Map.Entry<String, Integer>> highCard, int index){
        int bitAmount = 0;
        for (int i = 0; i < highCard.size(); i++)
        {
            bitAmount += highCard.get(i).getValue()*(index+i);
        }
        return bitAmount;
    }


    // Evaluate cards and calculate bit amount
    public static int evaluateCards(HandTypes handTypes, Map<Character, Integer> cardStrength) {
        int win = 0;
        int bitAmount;
        int index = 1;

        // Analyze high card
        List<Map.Entry<String, Integer>> HighCard = handTypes.getHighCard();
        // Sort all high card ascending
        sortHandsByStrength(HighCard, cardStrength);
        // Calculate bit amount for high card
        bitAmount = getBitAmount(HighCard, index);
        win += bitAmount;
        index += HighCard.size();

        // Analyze one pair
        List<Map.Entry<String, Integer>> OnePair = handTypes.getOnePair();
        // Sort all one pair ascending
        sortHandsByStrength(OnePair, cardStrength);
        // Calculate bit amount for one pair
        bitAmount = getBitAmount(OnePair, index);
        win += bitAmount;
        index += OnePair.size();

        // Analyze two pair
        List<Map.Entry<String, Integer>> TwoPair = handTypes.getTwoPair();
        // Sort all two pair ascending
        sortHandsByStrength(TwoPair, cardStrength);
        // Calculate bit amount for two pair
        bitAmount = getBitAmount(TwoPair, index);
        win += bitAmount;
        index += TwoPair.size();

        // Analyze three of a kind
        List<Map.Entry<String, Integer>> ThreeOfAKind = handTypes.getThreeOfAKind();
        // Sort all three of a kind ascending
        sortHandsByStrength(ThreeOfAKind, cardStrength);
        // Calculate bit amount for three of a kind
        bitAmount = getBitAmount(ThreeOfAKind, index);
        win += bitAmount;
        index += ThreeOfAKind.size();

        // Analyze full house
        List<Map.Entry<String, Integer>> FullHouse = handTypes.getFullHouse();
        // Sort all full house ascending
        sortHandsByStrength(FullHouse, cardStrength);
        // Calculate bit amount for full house
        bitAmount = getBitAmount(FullHouse, index);
        win += bitAmount;
        index += FullHouse.size();

        // Analyze four of a kind
        List<Map.Entry<String, Integer>> FourOfAKind = handTypes.getFourOfAKind();
        // Sort all four of a kind ascending
        sortHandsByStrength(FourOfAKind, cardStrength);
        // Calculate bit amount for four of a kind
        bitAmount = getBitAmount(FourOfAKind, index);
        win += bitAmount;
        index += FourOfAKind.size();

        // Analyze five of a kind
        List<Map.Entry<String, Integer>> FiveOfAKind = handTypes.getFiveOfAKind();
        // Sort all five of a kind ascending
        sortHandsByStrength(FiveOfAKind, cardStrength);
        // Calculate bit amount for five of a kind
        bitAmount = getBitAmount(FiveOfAKind, index);
        win += bitAmount;

        return win;
    }
}