package main.adventofcode.day1;

public class SantaDirectionsReader {
    private String directions;
    private ReadingStrategy strategy;

    public SantaDirectionsReader(String directions) {
        this(directions, null);
    }

    public SantaDirectionsReader(String directions, ReadingStrategy strategy) {
        this.directions = directions;
        this.strategy = strategy;
    }

    public ReadingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ReadingStrategy strategy) {
        this.strategy = strategy;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public int whatFloor() {
        return strategy.parseDocument(directions);
    }
}
