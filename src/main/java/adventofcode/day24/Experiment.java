package adventofcode.day24;

import java.util.ArrayList;
import java.util.List;

public class Experiment {

    private long minimumXValue;
    private long minimumYValue;
    private long maximumXValue;
    private long maximumYValue;
    private List<Hailstone> hailstones;

    public Experiment(String input, long minimumXValue, long minimumYValue, long maximumXValue, long maximumYValue) {
        setHailstonesFromInput(input);
        this.minimumXValue = minimumXValue;
        this.minimumYValue = minimumYValue;
        this.maximumXValue = maximumXValue;
        this.maximumYValue = maximumYValue;
    }

    public int calculateNumberOfIntersectionsWithinTestArea() {
        int numberOfIntersections = 0;
        for (int i = 0; i < hailstones.size() - 1; i++) {
            for (int j = i + 1; j < hailstones.size(); j++) {
                if (hailstones.get(i).intersectsInTheFutureWithinArea(hailstones.get(j), minimumXValue, minimumYValue, maximumXValue, maximumYValue)) {
                    numberOfIntersections++;
                }
            }
        }
        return numberOfIntersections;
    }

    private void setHailstonesFromInput(String input) {
        hailstones = new ArrayList<>();
        String[] inputLines = getInputLines(input);
        for (String inputLine : inputLines) {
            extractHailstone(inputLine);
        }
    }

    private void extractHailstone(String inputLine) {
        Position position = extractPosition(getLeftSideOfInputLine(inputLine));
        Velocity velocity = extractVelocity(getRightSideOfInputLine(inputLine));
        hailstones.add(new Hailstone(position, velocity));
    }

    private Velocity extractVelocity(String rightSideOfInputLine) {
        String[] positions = rightSideOfInputLine.split(",");
        int dx = Integer.parseInt(positions[0].strip());
        int dy = Integer.parseInt(positions[1].strip());
        int dz = Integer.parseInt(positions[2].strip());
        return new Velocity(dx,dy,dz);
    }

    private Position extractPosition(String leftSideOfInputLine) {
        String[] positions = leftSideOfInputLine.split(",");
        long x = Long.parseLong(positions[0].strip());
        long y = Long.parseLong(positions[1].strip());
        long z = Long.parseLong(positions[2].strip());
        return new Position(x,y,z);
    }

    private String[] getInputLines(String input) {
        return input.split("\n");
    }

    private String getLeftSideOfInputLine(String inputLine) {
        return inputLine.split("@")[0].strip();
    }

    private String getRightSideOfInputLine(String inputLine) {
        return inputLine.split("@")[1].strip();
    }

    public List<Hailstone> getHailstones() {
        return hailstones;
    }
}
