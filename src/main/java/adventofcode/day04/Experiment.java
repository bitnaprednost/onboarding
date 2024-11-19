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

}
