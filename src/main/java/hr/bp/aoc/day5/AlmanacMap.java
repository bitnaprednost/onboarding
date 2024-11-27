package hr.bp.aoc.day5;

public class AlmanacMap {
    private int sourceStart;
    private int destinationStart;
    private int range;

    public AlmanacMap(int sourceStart, int destinationStart, int range) {
        this.sourceStart = sourceStart;
        this.destinationStart = destinationStart;
        this.range = range;
    }

    public int getSourceStart() {
        return sourceStart;
    }

    public int getDestinationStart() {
        return destinationStart;
    }

    public int getRange() {
        return range;
    }
}