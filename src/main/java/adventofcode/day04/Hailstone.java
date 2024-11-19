package adventofcode.day04;

import org.graalvm.collections.Pair;
import java.util.Objects;

public class Hailstone {

    private final Velocity velocity;
    private final Position position;

    public Hailstone(Position position, Velocity velocity) {
        this.velocity = velocity;
        this.position = position;
    }

    public boolean intersectsInTheFutureWithinArea(Hailstone hailstone, int minimumX, int minimumY, int maximumX, int maximumY) {
        Pair<Double, Double> intersection = this.intersect(hailstone);
        if (Double.isNaN(intersection.getLeft()) || Double.isNaN(intersection.getRight())) {
            return false;
        }
        boolean intersectionIsWithinArea = intersectionIsWithinArea(intersection, minimumX, minimumY, maximumX, maximumY);
        boolean intersectionIsInTheFutureOfThis = this.pointIsInTheFutureOfTheLine(intersection);
        boolean intersectionIsInTheFutureOfHailstone = hailstone.pointIsInTheFutureOfTheLine(intersection);
        return intersectionIsWithinArea && intersectionIsInTheFutureOfThis && intersectionIsInTheFutureOfHailstone;
    }

    private boolean intersectionIsWithinArea(Pair<Double, Double> intersection, int minimumX, int minimumY, int maximumX, int maximumY) {
        return intersection.getLeft() >= minimumX &&
                intersection.getLeft() <= maximumX &&
                intersection.getRight() >= minimumY &&
                intersection.getRight() <= maximumY;
    }

    public Pair<Double, Double> intersect(Hailstone hailstone) {
        if (this.isParallelInXYPlaneWith(hailstone)){
            return Pair.create(Double.NaN, Double.NaN);
        }
        Double m1 = this.getSlope();
        Integer x1 = this.position.getX();
        Integer y1 = this.position.getY();

        Double m2 = hailstone.getSlope();
        Integer x2 = hailstone.position.getX();
        Integer y2 = hailstone.position.getY();


        Double x = ((m1*x1 - m2*x2) + (y2 - y1)) / (m1 - m2);
        Double y = y1 + m1*(x-x1);

        return Pair.create(x, y);
    }

    public boolean isParallelInXYPlaneWith(Hailstone hailstone) {
        return this.getSlope() == hailstone.getSlope();
    }

    private double getSlope() {
        return (double) this.velocity.getDy() / this.velocity.getDx();
    }

    public boolean pointIsInTheFutureOfTheLine(Pair<Double, Double> point) {
        return (this.velocity.getDx() < 0 && point.getLeft() < this.position.getX()) ||
                (this.velocity.getDx() > 0 && point.getLeft() > this.position.getX());
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
