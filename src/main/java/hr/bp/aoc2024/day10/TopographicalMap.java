package hr.bp.aoc2024.day10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TopographicalMap {
    private static final Logger log = LoggerFactory.getLogger(TopographicalMap.class);

    private int[][] topographicalMap;
    private boolean distinctTrails;

    public TopographicalMap(int[][] topographicalMap, boolean distinctTrails) {
        this.topographicalMap = topographicalMap;
        this.distinctTrails = distinctTrails;
    }

    public TopographicalMap(int[][] topographicalMap) {
        this(topographicalMap, false);
    }

    public TopographicalMap(TopographicMapParser parser) {
        this(parser.getTopographicalMap());
    }

    public TopographicalMap(TopographicMapParser parser, boolean distinctTrails) {
        this(parser.getTopographicalMap(), distinctTrails);
    }

    public int calculateTrailheadScore() {
        int trailheadScore = 0;

        for (int x = 0; x < topographicalMap.length; x++) {
            for (int y = 0; y < topographicalMap[0].length; y++) {
                if (topographicalMap[x][y] == 0) {
                    trailheadScore += getTrailheadScore(new Coordinate(x, y));
                }
            }
        }
        return trailheadScore;
    }

    private int getTrailheadScore(Coordinate coordinateOfZero) {
        int trailheadScore = 0;
        List<Coordinate> trailheadsFoundCoordinates = new ArrayList<>();

        trailheadScore += findTrailhead(coordinateOfZero, trailheadsFoundCoordinates);

        log.debug("for trail start at x={} y={} found {} trailheads",
                coordinateOfZero.getX(),
                coordinateOfZero.getY(),
                trailheadScore);

        return trailheadScore;

    }

    private int findTrailhead(Coordinate coordinate, List<Coordinate> trailheadsFoundCoordinates) {
        int currentHeight = topographicalMap[coordinate.getX()][coordinate.getY()];

        if (currentHeight == 9) {
            return getDistinctTrail(coordinate, trailheadsFoundCoordinates);
        }

        int trailheadsFound = 0;
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (checkDirection(x, y + 1, currentHeight)) {
            trailheadsFound += findTrailhead(new Coordinate(x, y + 1), trailheadsFoundCoordinates);
        }
        if (checkDirection(x, y - 1, currentHeight)) {
            trailheadsFound += findTrailhead(new Coordinate(x, y - 1), trailheadsFoundCoordinates);
        }
        if (checkDirection(x + 1, y, currentHeight)) {
            trailheadsFound += findTrailhead(new Coordinate(x + 1, y), trailheadsFoundCoordinates);
        }
        if (checkDirection(x - 1, y, currentHeight)) {
            trailheadsFound += findTrailhead(new Coordinate(x - 1, y), trailheadsFoundCoordinates);
        }

        return trailheadsFound;
    }

    private int getDistinctTrail(Coordinate coordinate, List<Coordinate> trailheadsFoundCoordinates) {
        if (distinctTrails) {
            return 1;
        } else {
            if (trailheadsFoundCoordinates.contains(coordinate)) {
                return 0;
            }
            trailheadsFoundCoordinates.add(coordinate);
            return 1;
        }
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
