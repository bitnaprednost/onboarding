package hr.bp.adventofcode.day07.tasktwo;

import java.util.HashMap;
import java.util.Map;

public enum CardWithJoker {
    J("J"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    T("T"),
    Q("Q"),
    K("K"),
    A("A");

    private final String symbol;

    private static final Map<String, CardWithJoker> SYMBOL_TO_CARD = new HashMap<>();

    static {
        for (CardWithJoker cardWithJoker : values()) {
            SYMBOL_TO_CARD.put(cardWithJoker.symbol, cardWithJoker);
        }
    }

    CardWithJoker(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static CardWithJoker fromSymbol(String symbol) {
        return SYMBOL_TO_CARD.get(symbol);
    }
}
