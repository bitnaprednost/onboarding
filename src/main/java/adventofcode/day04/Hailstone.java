package adventofcode.day04;

import java.util.Objects;

public class Hailstone {

    private Velocity velocity;
    private Position position;

    public Hailstone(Position position, Velocity velocity) {
        this.velocity = velocity;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hailstone hailstone)) return false;
        return Objects.equals(velocity, hailstone.velocity) && Objects.equals(position, hailstone.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(velocity, position);
    }
}
