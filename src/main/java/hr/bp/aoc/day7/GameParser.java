package hr.bp.aoc.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GameParser {
    private List<String> gameString;
    private boolean joker;

    public GameParser(List<String> gameString) {
        this(gameString, false);
    }

    public GameParser(List<String> gameString, boolean joker) {
        this.gameString = gameString;
        this.joker = joker;
    }

    public Game parseGameString() {
        Set<Hand> hands = new TreeSet<>();

        for (String handString : gameString) {
            hands.add(getHandFromString(handString));
        }

        return new Game(hands, joker);
    }

    private Hand getHandFromString(String handString) {
        int bid = Integer.parseInt(handString.split(" ")[1].strip());

        List<Card> cards = new ArrayList<>();
        String[] cardsString = handString.split(" ")[0].split("");

        for (String card : cardsString) {
            cards.add(Card.getCard(card));
        }

        return new Hand(cards, bid, joker);
    }
}
