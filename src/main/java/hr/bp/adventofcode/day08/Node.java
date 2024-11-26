package hr.bp.adventofcode.day08;

import java.util.Objects;

/**
 * @author Ivan Tomičić
 */
public class Node {

    private final String label;

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node node)) return false;
        return Objects.equals(getLabel(), node.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLabel());
    }
}
