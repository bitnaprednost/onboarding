package hr.bp.aoc.day6;

public class Race {
    private int time;
    private int recordDistance;

    public Race(int distance, int time) {
        this.recordDistance = distance;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public int getRecordDistance() {
        return recordDistance;
    }
}
