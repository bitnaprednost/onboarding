package hr.bp.adventofcode.day06;

public record RaceRecord(int maximumTime, int recordDistance) {

    public RaceRecord(String maximumTime, String distanceRecord) {
        this(Integer.parseInt(maximumTime), Integer.parseInt(distanceRecord));
    }
}
