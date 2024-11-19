package adventofcode.day04;

import java.util.Objects;

public class Hailstone {

    private Velocity velocity;
    private Position position;

    public Hailstone(Position position, Velocity velocity) {
        this.velocity = velocity;
        this.position = position;
    }



    public boolean isParallelInXYPlaneWith(Hailstone hailstone) {
        return this.getSlope() == hailstone.getSlope();
    }

    private double getSlope() {
        return (double) this.velocity.getDy() / this.velocity.getDx();
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
