package hr.bp.adventofcode.day24;

import hr.bp.adventofcode.Pair;

import java.util.Objects;

public class Hailstone {

    private final Velocity velocity;
    private final Position position;

    public Hailstone(Position position, Velocity velocity) {
        this.velocity = velocity;
        this.position = position;
    }

    public boolean intersectsInTheFutureWithinArea(Hailstone hailstone, long minimumX, long minimumY, long maximumX, long maximumY) {
        Pair<Double, Double> intersection = this.intersect(hailstone);
        if (Double.isNaN(intersection.left()) || Double.isNaN(intersection.right())) {
            return false;
        }
        boolean intersectionIsWithinArea = intersectionIsWithinArea(intersection, minimumX, minimumY, maximumX, maximumY);
        boolean intersectionIsInTheFutureOfThis = this.pointIsInTheFutureOfTheLine(intersection);
        boolean intersectionIsInTheFutureOfHailstone = hailstone.pointIsInTheFutureOfTheLine(intersection);
        return intersectionIsWithinArea && intersectionIsInTheFutureOfThis && intersectionIsInTheFutureOfHailstone;
    }

    private boolean intersectionIsWithinArea(Pair<Double, Double> intersection, long minimumX, long minimumY, long maximumX, long maximumY) {
        return intersection.left() >= minimumX &&
                intersection.left() <= maximumX &&
                intersection.right() >= minimumY &&
                intersection.right() <= maximumY;
    }

    public Pair<Double, Double> intersect(Hailstone hailstone) {
        if (this.isParallelInXYPlaneWith(hailstone)){
            return new Pair<>(Double.NaN, Double.NaN);
        }
        Double m1 = this.getSlope();
        Long x1 = this.position.getX();
        Long y1 = this.position.getY();

        Double m2 = hailstone.getSlope();
        Long x2 = hailstone.position.getX();
        Long y2 = hailstone.position.getY();


        Double x = ((m1*x1 - m2*x2) + (y2 - y1)) / (m1 - m2);
        Double y = y1 + m1*(x-x1);

        return new Pair<>(x, y);
    }

    public boolean isParallelInXYPlaneWith(Hailstone hailstone) {
        return this.getSlope() == hailstone.getSlope();
    }

    private double getSlope() {
        return (double) this.velocity.getDy() / this.velocity.getDx();
    }

    public boolean pointIsInTheFutureOfTheLine(Pair<Double, Double> point) {
        return (this.velocity.getDx() < 0 && point.left() < this.position.getX()) ||
                (this.velocity.getDx() > 0 && point.left() > this.position.getX());
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
