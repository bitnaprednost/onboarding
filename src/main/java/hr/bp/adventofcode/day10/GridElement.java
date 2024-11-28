package hr.bp.adventofcode.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Tomičić
 */
public enum GridElement {

    NORTH_EAST("L"),
    NORTH_WEST("J"),
    SOUTH_EAST("F"),
    SOUTH_WEST("7"),
    NORTH_SOUTH("|"),
    EAST_WEST("-"),
    GROUND("."),
    STARTING_POSITION("S");

    private final String symbol;

    private static final Map<String, GridElement> SYMBOL_TO_PIPE = new HashMap<>();

    static {
        for (GridElement gridElement : values()) {
            SYMBOL_TO_PIPE.put(gridElement.symbol, gridElement);
        }
    }

    GridElement(String symbol) {
        this.symbol = symbol;
    }

    public static GridElement fromSymbol(String symbol) {
        return SYMBOL_TO_PIPE.get(symbol);
    }

    public Move nextMove(Move previousMove) {
        switch(this) {
            case NORTH_EAST -> {
                if (previousMove.equals(Move.WEST)) return Move.NORTH;
                else return Move.EAST;
            } case NORTH_WEST -> {
                if (previousMove.equals(Move.EAST)) return Move.NORTH;
                else return Move.WEST;
            } case SOUTH_EAST -> {
                if (previousMove.equals(Move.WEST)) return Move.SOUTH;
                else return Move.EAST;
            } case SOUTH_WEST -> {
                if (previousMove.equals(Move.NORTH)) return Move.WEST;
                else return Move.SOUTH;
            } case EAST_WEST -> {
                if (previousMove.equals(Move.EAST)) return Move.EAST;
                else return Move.WEST;
            } case NORTH_SOUTH -> {
                if (previousMove.equals(Move.NORTH)) return Move.NORTH;
                else return Move.SOUTH;
            } default -> {
                return null;
            }
        }
    }
}
