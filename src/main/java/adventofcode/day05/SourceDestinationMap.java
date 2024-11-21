package adventofcode.day05;

/**
 * @author Ivan Tomičić
 */
public record SourceDestinationMap(long destinationStart, long sourceStart, long rangeLength) {

    public static SourceDestinationMap createFromInputLine(String inputLine) {
        String[] parameters = inputLine.split(" ");
        return new SourceDestinationMap(
                Integer.parseInt(parameters[0]),
                Integer.parseInt(parameters[1]),
                Integer.parseInt(parameters[2])
        );
    }
}
