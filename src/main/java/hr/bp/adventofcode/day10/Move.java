package hr.bp.adventofcode.day10;

import java.util.function.Function;

/**
 * @author Ivan Tomičić
 */
public enum Move {

    NORTH(row -> row - 1, column -> column),

    SOUTH(row -> row + 1, column -> column),

    WEST(row -> row, column -> column - 1),

    EAST(row -> row, column -> column + 1),

    UNDEFINED_MOVE(null, null);

    private final Function<Integer, Integer> moveRow;

    private final Function<Integer, Integer> moveColumn;

    Move(Function<Integer, Integer> moveRow, Function<Integer, Integer> moveColumn) {
        this.moveRow = moveRow;
        this.moveColumn = moveColumn;
    }

    public Function<Integer, Integer> getMoveRow() {
        return moveRow;
    }

    public Function<Integer, Integer> getMoveColumn() {
        return moveColumn;
    }
}
