package hr.bp.aoc.day5;

public class AlmanacMap {
    private long sourceStart;
    private long destinationStart;
    private long range;

    public AlmanacMap(long sourceStart, long destinationStart, long range) {
        this.sourceStart = sourceStart;
        this.destinationStart = destinationStart;
        this.range = range;
    }

    public long getSourceStart() {
        return sourceStart;
    }

    public long getDestinationStart() {
        return destinationStart;
    }

    public long getRange() {
        return range;
    }
}