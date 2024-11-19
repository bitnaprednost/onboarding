package adventofcode.day04;

import java.util.Objects;

public class Velocity {

    private int dx;
    private int dy;
    private int dz;

    public Velocity(int dx, int dy, int dz) {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Velocity velocity)) return false;
        return dx == velocity.dx && dy == velocity.dy && dz == velocity.dz;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dx, dy, dz);
    }
}
