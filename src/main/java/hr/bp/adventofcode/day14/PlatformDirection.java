package hr.bp.adventofcode.day14;

import java.util.Comparator;

/**
 * @author Ivan Tomičić
 */
public enum PlatformDirection {
    NORTH((char1, char2) -> -1 * char1.compareTo(char2)),
    SOUTH(Character::compareTo),
    WEST((char1, char2) -> -1 * char1.compareTo(char2)),
    EAST(Character::compareTo);

    private final Comparator<Character> comparator;

    PlatformDirection(Comparator<Character> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Character> getComparator() {
        return comparator;
    }
}
