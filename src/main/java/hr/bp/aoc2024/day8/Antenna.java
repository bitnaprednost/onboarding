package hr.bp.aoc2024.day8;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Antenna {
    private Coordinate coordinate;
    private char frequency;


    public Set<Coordinate> findAntinodes(List<Antenna> antenns, int mapLength, int mapWidth, boolean resonance) {
        Set<Coordinate> antinodeCoordinates = new HashSet<>();

        for (Antenna antenna : antenns) {
            if (!this.equals(antenna)) {
                antinodeCoordinates.addAll(getAntinodeWithAntenna(antenna, mapLength, mapWidth, resonance));
            }
        }
        return antinodeCoordinates;
    }

    private Set<Coordinate> getAntinodeWithAntenna(Antenna antenna, int mapLength, int mapWidth,
                                                   boolean resonance) {
        Set<Coordinate> antinodeCoordinate = new HashSet<>();

        if (antenna.getFrequency() != this.getFrequency()) {
            return antinodeCoordinate;
        }

        Coordinate distanceBetweenAntennas = this.coordinate.getDistanceFrom(antenna.coordinate);

        Coordinate firstAntinode = this.coordinate.add(distanceBetweenAntennas);
        Coordinate secondAntinode = antenna.coordinate.subtract(distanceBetweenAntennas);

        antinodeCoordinate.add(firstAntinode);
        antinodeCoordinate.add(secondAntinode);

        if (resonance) {
            antinodeCoordinate.add(this.coordinate);
            antinodeCoordinate.add(antenna.coordinate);

            while (firstAntinode.getX() < mapLength && firstAntinode.getY() < mapWidth && firstAntinode.getY() >= 0 && firstAntinode.getX() >= 0) {
                firstAntinode = firstAntinode.add(distanceBetweenAntennas);
                antinodeCoordinate.add(firstAntinode);
            }

            while (secondAntinode.getX() < mapLength && secondAntinode.getY() < mapWidth && secondAntinode.getX() >= 0 && secondAntinode.getY() >= 0) {
                secondAntinode = secondAntinode.subtract(distanceBetweenAntennas);
                antinodeCoordinate.add(secondAntinode);
            }
        }
        return antinodeCoordinate;
    }

    public Antenna(Coordinate coordinate, char frequency) {
        this.coordinate = coordinate;
        this.frequency = frequency;
    }

    public char getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Antenna antenna = (Antenna) o;
        return frequency == antenna.frequency && Objects.equals(coordinate, antenna.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, frequency);
    }

}
