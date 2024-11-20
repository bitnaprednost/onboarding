package adventofcode.day05;

import java.util.Objects;

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

    public static SourceDestinationMap createFromInputLine(String inputLine) {
        String[] parameters = inputLine.split(" ");
        return new SourceDestinationMap(
                Integer.parseInt(parameters[0]),
                Integer.parseInt(parameters[1]),
                Integer.parseInt(parameters[2])
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SourceDestinationMap that)) return false;
        return sourceStart == that.sourceStart && destinationStart == that.destinationStart && rangeLength == that.rangeLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceStart, destinationStart, rangeLength);
    }

    @Override
    public String toString() {
        return "SourceDestinationMap{" +
                "sourceStart=" + sourceStart +
                ", destinationStart=" + destinationStart +
                ", rangeLength=" + rangeLength +
                '}';
    }
}
