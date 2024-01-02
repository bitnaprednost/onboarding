package hr.bp.aoc.beacon.exclusion.zone.util;

import java.util.Optional;

public record Line(int a, long b) {
    public static Long calculateB(LongPoint p0, LongPoint p1){
        return (p1.x()*p0.y()-p0.x()*p1.y()) / (p1.x() - p0.x());
    }

    public static Optional<LongPoint> calculateIntersection(Line l0, Line l1) {
        if(l0.a-l1.a == 0) return Optional.empty();

        long x = (l1.b - l0.b) / (l0.a - l1.a);
        long y = l0.getValue(x);

        return Optional.of(new LongPoint(x,y));
    }

    public long getValue(long x){
        return a * x + b;
    }
}
