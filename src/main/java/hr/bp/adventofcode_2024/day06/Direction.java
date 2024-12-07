package hr.bp.adventofcode_2024.day06;

/**
 * @author Ivan Tomičić
 */
public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public static Direction getDirectionForSign(char sign) {
        switch (sign) {
            case '<' -> {
                return WEST;
            } case '>' -> {
                return EAST;
            } case '^' -> {
                return NORTH;
            } case 'v' -> {
                return SOUTH;
            }
        }
        return null;
    }

    public static Direction turnNinetyDegrees(Direction direction) {
        switch (direction) {
            case NORTH -> {
                return EAST;
            } case EAST -> {
                return SOUTH;
            } case SOUTH -> {
                return WEST;
            } case WEST -> {
                return NORTH;
            }
        }
        return null;
    }
}
