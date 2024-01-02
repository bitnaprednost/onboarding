package hr.bp.aoc.beacon.exclusion.zone;

public record Beacon(LongPoint point) {
    public long calculateFrequency(){
        return point.x()*4000000+point.y();
    }
}
