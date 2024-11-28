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
        sourceEnd = sourceStart + range;
        mapping = destinationStart - sourceStart;
    }

    public boolean contains(AlmanacMap map) {
        return sourceStart <= map.sourceStart && sourceEnd >= map.sourceEnd;
    }

    public long getMapping() {
        return mapping;
    }

    public long getSourceEnd() {
        return sourceEnd;
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