package hr.bp.adventofcode.day06;

public record RaceRecord(long maximumTime, long recordDistance) {

    public RaceRecord(String maximumTime, String distanceRecord) {
        this(Long.parseLong(maximumTime), Long.parseLong(distanceRecord));
    }
}
