package hr.bp.aoc.day6;

public class Race {
    private long time;
    private long recordDistance;

    public Race(long distance, long time) {
        this.recordDistance = distance;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public long getRecordDistance() {
        return recordDistance;
    }
}
