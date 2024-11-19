package adventofcode.day04;

import java.util.List;

public class Experiment {

    private int minimumXValue;
    private int minimumYValue;
    private int maximumXValue;
    private int maximumYValue;
    private List<Hailstone> hailstones;

    public Experiment(List<Hailstone> hailstones, int minimumYValue, int minimumXValue, int maximumXValue, int maximumYValue) {
        this.hailstones = hailstones;
        this.minimumYValue = minimumYValue;
        this.minimumXValue = minimumXValue;
        this.maximumXValue = maximumXValue;
        this.maximumYValue = maximumYValue;
    }

    public Experiment(String input) {

    }

    public Experiment() {
    }

    public List<Hailstone> getHailstones() {
        return List.of(
                new Hailstone(new Position(19, 13, 30), new Velocity(-2, 1, -2)),
                new Hailstone(new Position(18, 19, 22), new Velocity(-1, -1, -2)),
                new Hailstone(new Position(20, 25, 34), new Velocity(-2, -2, -4)),
                new Hailstone(new Position(12, 31, 28), new Velocity(-1, -2, -1)),
                new Hailstone(new Position(20, 19, 25), new Velocity(1, -5, -3))
        );
    }
}
