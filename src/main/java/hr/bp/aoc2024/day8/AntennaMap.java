package hr.bp.aoc2024.day8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AntennaMap {
    private List<Antenna> antennas;
    private Set<Coordinate> antinodes;
    private int mapLength;
    private int mapWidth;
    private boolean resonance;

    public int getAntinodesNumber() {
        antinodes = getAntinodesFromAntennas();

        return antinodes.size();
    }

    private Set<Coordinate> getAntinodesFromAntennas() {
        Set<Coordinate> antinodesCoordinates = new HashSet<>();

        for (Antenna antenna : antennas) {
            antinodesCoordinates.addAll(antenna.findAntinodes(antennas, mapLength, mapWidth, resonance));
        }
        antinodes = antinodesCoordinates;

        removeCoordinatesNotonMap();

        return antinodes;
    }

    private void removeCoordinatesNotonMap() {
        antinodes = antinodes.stream().filter(coordinate ->
                coordinate.getX() < mapLength && coordinate.getX() >= 0 && coordinate.getY() < mapWidth && coordinate.getY() >= 0
        ).collect(Collectors.toSet());
    }

    public AntennaMap(char[][] antennaMapParsed) {
        this(antennaMapParsed, false);
    }

    public AntennaMap(char[][] antennaMapParsed, boolean resonance) {
        mapLength = antennaMapParsed.length;
        mapWidth = antennaMapParsed[0].length;
        this.antennas = getAntennasCoordinates(antennaMapParsed);
        this.antinodes = new HashSet<>();
        this.resonance = resonance;
    }

    private List<Antenna> getAntennasCoordinates(char[][] antennaMapParsed) {
        List<Antenna> anntennaCoordinates = new ArrayList<>();

        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapWidth; j++) {
                if (antennaMapParsed[i][j] != '.') {
                    anntennaCoordinates.add(new Antenna(new Coordinate(i, j), antennaMapParsed[i][j]));
                }
            }
        }
        return anntennaCoordinates;
    }
}
