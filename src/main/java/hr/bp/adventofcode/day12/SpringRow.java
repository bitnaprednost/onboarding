package hr.bp.adventofcode.day12;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class SpringRow {

    private Integer differentArrangements;

    private final List<Character> springs;

    private final List<Integer> contiguousGroups;

    public SpringRow(List<Character> springs, List<Integer> contiguousGroups) {
        this.springs = springs;
        this.contiguousGroups = contiguousGroups;
        setDifferentArrangements(springs, contiguousGroups);
    }

    private void setDifferentArrangements(List<Character> springs, List<Integer> contiguousGroups) {
        differentArrangements = 1;
    }

    public int getDifferentArrangements() {
        return differentArrangements;
    }
}
