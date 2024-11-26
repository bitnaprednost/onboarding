package hr.bp.adventofcode.day08;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    RIGHT("R"),
    LEFT("L");

    private final String symbol;

    private static final Map<String, Direction> SYMBOL_TO_DIRECTION = new HashMap<>();

    static {
        for (Direction direction : values()) {
            SYMBOL_TO_DIRECTION.put(direction.symbol, direction);
        }
    }

    Direction(String symbol) {
        this.symbol = symbol;
    }

    public static Direction fromSymbol(String symbol) {
        return SYMBOL_TO_DIRECTION.get(symbol);
    }
}
