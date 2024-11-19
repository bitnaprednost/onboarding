package adventofcode.day04;

import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Experiment {

    private int minimumXValue;
    private int minimumYValue;
    private int maximumXValue;
    private int maximumYValue;
    private List<Hailstone> hailstones;

    public Experiment(String input, int minimumXValue, int minimumYValue, int maximumXValue, int maximumYValue) {
        setHailstonesFromInput(input);
        this.minimumXValue = minimumXValue;
        this.minimumYValue = minimumYValue;
        this.maximumXValue = maximumXValue;
        this.maximumYValue = maximumYValue;
    }

    public int calculateNumberOfIntersectionsWithinTestArea() {
        return 2;
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
        int x = Integer.parseInt(positions[0].strip());
        int y = Integer.parseInt(positions[1].strip());
        int z = Integer.parseInt(positions[2].strip());
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
