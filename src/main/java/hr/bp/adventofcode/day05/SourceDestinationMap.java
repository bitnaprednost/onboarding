package hr.bp.adventofcode.day05;

/**
 * @author Ivan Tomičić
 */
public record SourceDestinationMap(long destinationStart, long sourceStart, long rangeLength) {

    public static SourceDestinationMap createFromInputLine(String inputLine) {
        String[] parameters = inputLine.split(" ");

        return new SourceDestinationMap(
                Long.parseLong(parameters[0]),
                Long.parseLong(parameters[1]),
                Long.parseLong(parameters[2])
        );
    }
}
