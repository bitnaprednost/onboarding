package hr.bp.aoc.day7;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TestUtils {
    public static List<String> getTestInputCorrect() {
        String inputString = "32T3K 765\n" +
                "T55J5 684\n" +
                "KK677 28\n" +
                "KTJJT 220\n" +
                "QQQJA 483";
        return Arrays.stream(inputString.split("\\n")).toList();
    }

    public static Game getTestHands() {
        return new Game(Set.of (
                new Hand(List.of(Card.THREE, Card.TWO, Card.T, Card.THREE, Card.K), 765),
                new Hand(List.of(Card.T, Card.FIVE, Card.FIVE, Card.J, Card.FIVE), 684),
                new Hand(List.of(Card.Q, Card.Q, Card.Q, Card.J, Card.A), 483),
                new Hand(List.of(Card.K, Card.T, Card.J, Card.J, Card.T), 220),
                new Hand(List.of(Card.K, Card.K, Card.SIX, Card.SEVEN, Card.SEVEN), 28)
        ));
    }

    public static List<String> invalidSymbolInput() {
        String inputString = "32T3K 765\n" +
                "T55N5 684\n" +
                "KK677 28\n" +
                "KTJJT 220\n" +
                "QQQJA 483";
        return Arrays.stream(inputString.split("\\n")).toList();
    }

    public static List<String> tooMuchCardsInput() {
        String inputString = "32T3K 765\n" +
                "T55N35 684\n" +
                "KK677 28\n" +
                "KTJJT 220\n" +
                "QQQJA 483";
        return Arrays.stream(inputString.split("\\n")).toList();
    }

    public static List<String> tooLittleCardsInput() {
        String inputString = "32T3K 765\n" +
                "T35 684\n" +
                "KK677 28\n" +
                "KTJJT 220\n" +
                "QQQJA 483";
        return Arrays.stream(inputString.split("\\n")).toList();
    }
}
