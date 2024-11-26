package hr.bp.adventofcode.day07.taskone;

import java.util.HashMap;
import java.util.Map;

public enum Card {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    T("T"),
    J("J"),
    Q("Q"),
    K("K"),
    A("A");

    private final String symbol;

    private static final Map<String, Card> SYMBOL_TO_CARD = new HashMap<>();

    static {
        for (Card card : values()) {
            SYMBOL_TO_CARD.put(card.symbol, card);
        }
    }

    Card(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Card fromSymbol(String symbol) {
        return SYMBOL_TO_CARD.get(symbol);
    }
}
