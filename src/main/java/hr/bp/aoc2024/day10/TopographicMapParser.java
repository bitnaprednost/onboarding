package hr.bp.aoc2024.day10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TopographicMapParser {
    private static final Logger log = LoggerFactory.getLogger(TopographicMapParser.class);

    private List<String> topographicalMapString;

    public TopographicMapParser(List<String> topographicalMapString) {
        this.topographicalMapString = topographicalMapString;
    }

    public int[][] getTopographicalMap() {
        int mapLength = topographicalMapString.size();
        int mapWidth = topographicalMapString.get(0).strip().length();
        int[][] topographicalMap = new int[mapLength][mapWidth];

        for (int x = 0; x < mapLength; x++) {
            for (int y = 0; y < mapWidth; y++) {
                topographicalMap[x][y] = getIntFromMapCoordinates(x, y);
            }
        }

        log.debug("parsed topographical map = {}", topographicalMap);

        return topographicalMap;
    }

    private int getIntFromMapCoordinates(int x, int y) {
        int[] mapRow = getMapRow(x);

        return mapRow[y];
    }

    private int[] getMapRow(int x) {
        return topographicalMapString.get(x).strip()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
