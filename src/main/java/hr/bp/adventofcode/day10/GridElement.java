package hr.bp.adventofcode.day10;

import hr.bp.adventofcode.Move;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Tomičić
 */
public enum GridElement {

    NORTH_EAST("L", true),

    NORTH_WEST("J", true),

    SOUTH_EAST("F", true),

    SOUTH_WEST("7", true),

    NORTH_SOUTH("|", false),

    EAST_WEST("-", false),

    GROUND(".", false),

    STARTING_POSITION("S", false);

    private final String symbol;

    private final boolean isEdge;

    private static final Map<String, GridElement> SYMBOL_TO_ELEMENT = new HashMap<>();

    static {
        for (GridElement gridElement : values()) {
            SYMBOL_TO_ELEMENT.put(gridElement.symbol, gridElement);
        }
    }

    public boolean isEdge() {
        return this.isEdge;
    }

    GridElement(String symbol, boolean isEdge) {
        this.symbol = symbol;
        this.isEdge = isEdge;
    }

    public static GridElement fromSymbol(String symbol) {
        return SYMBOL_TO_ELEMENT.get(symbol);
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
                return Move.UNDEFINED_MOVE;
            }
        }
    }
}
