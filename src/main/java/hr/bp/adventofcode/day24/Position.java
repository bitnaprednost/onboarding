package hr.bp.adventofcode.day24;

import java.util.Objects;

public class Position {

    private long x;
    private long y;
    private long z;

    public Position(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;
        return x == position.x && y == position.y && z == position.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public Long getX() {
        return this.x;
    }

    public Long getY() {
        return this.y;
    }
}
