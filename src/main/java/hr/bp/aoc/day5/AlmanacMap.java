package hr.bp.aoc.day5;

public class AlmanacMap {
    private long sourceStart;
    private long sourceEnd;
    private long mapping;
    private long destinationStart;
    private long range;

    public AlmanacMap(long sourceStart, long destinationStart, long range) {
        this.sourceStart = sourceStart;
        this.destinationStart = destinationStart;
        this.range = range;
        sourceEnd = sourceStart + range - 1;
        mapping = sourceStart - destinationStart;
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