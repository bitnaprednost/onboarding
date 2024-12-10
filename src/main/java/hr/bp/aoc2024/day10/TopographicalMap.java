package hr.bp.aoc2024.day10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TopographicalMap {
    private static final Logger log = LoggerFactory.getLogger(TopographicalMap.class);

    private int[][] topographicalMap;

    public TopographicalMap(int[][] topographicalMap) {
        this.topographicalMap = topographicalMap;
    }

    public TopographicalMap(TopographicMapParser parser) {
        this(parser.getTopographicalMap());
    }

    public int calculateTrailheadScore() {
        int trailheadScore = 0;

        for (int x = 0; x < topographicalMap.length; x++) {
            for (int y = 0; y < topographicalMap[0].length; y++) {
                if (topographicalMap[x][y] == 0) {
                    trailheadScore += getTrailheadScore(x, y);
                }
            }
        }
        return trailheadScore;
    }

    private int getTrailheadScore(int x, int y) {
        int trailheadScore = 0;
        List<Coordinate> trailheadsFoundCoordinates = new ArrayList<>();

        trailheadScore += findTrailhead(x, y, trailheadsFoundCoordinates);

        log.debug("for trail start at x={} y={} found {} trailheads", x, y, trailheadScore);

        return trailheadScore;

    }

    private int findTrailhead(int x, int y, List<Coordinate> trailheadsFoundCoordinates) {
        int currentHeight = topographicalMap[x][y];

        if (currentHeight == 9) {
            Coordinate trailheadCoordinate = new Coordinate(x,y);
            if (trailheadsFoundCoordinates.contains(trailheadCoordinate)) {
                return 0;
            }
            trailheadsFoundCoordinates.add(trailheadCoordinate);
            return 1;
        }
        int trailheadsFound = 0;
        if (checkDirection(x, y + 1, currentHeight)) {
            trailheadsFound += findTrailhead(x, y + 1, trailheadsFoundCoordinates);
        }
        if (checkDirection(x, y - 1, currentHeight)) {
            trailheadsFound += findTrailhead(x, y - 1, trailheadsFoundCoordinates);
        }
        if (checkDirection(x + 1, y, currentHeight)) {
            trailheadsFound += findTrailhead(x + 1, y, trailheadsFoundCoordinates);
        }
        if (checkDirection(x - 1, y, currentHeight)) {
            trailheadsFound += findTrailhead(x - 1, y, trailheadsFoundCoordinates);
        }

        return trailheadsFound;
    }

    private boolean checkDirection(int x, int y, int current) {
        if (isOnMap(x, y)) {
            return topographicalMap[x][y] - 1 == current;
        }
        return false;
    }

    private boolean isOnMap(int x, int y) {
        return x >= 0 && x < topographicalMap.length && y >= 0 && y < topographicalMap[0].length;
    }
}
