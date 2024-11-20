package adventofcode.day05;

/**
 * @author Ivan Tomičić
 */
public class SourceDestinationMap {

    private long sourceStart;
    private long destinationStart;
    private long rangeLength;

    public SourceDestinationMap(long sourceStart, long destinationStart, long rangeLength) {
        this.sourceStart = sourceStart;
        this.destinationStart = destinationStart;
        this.rangeLength = rangeLength;
    }
}
