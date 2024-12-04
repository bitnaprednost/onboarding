package hr.bp.adventofcode.day16;

import hr.bp.adventofcode.Move;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static hr.bp.adventofcode.Move.oppositeDirectionFrom;

/**
 * @author Ivan Tomičić
 */
public class Contraption {

    private char[][] grid;

    public Contraption(String input) {
        parseInput(input);
    }

    private void parseInput(String input) {
        String[] lines = input.split("\\s+");
        grid = new char[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }
    }

    public int countEnergizedTilesWhenBeamEntersAllDirections() {
        int maximumEnergizeLevel = 0;

        maximumEnergizeLevel = Math.max(maximumEnergizeLevel, shineBeamOnColumnFromDirection(0, Move.WEST));
        maximumEnergizeLevel = Math.max(maximumEnergizeLevel, shineBeamOnColumnFromDirection(grid[0].length - 1, Move.EAST));
        maximumEnergizeLevel = Math.max(maximumEnergizeLevel, shineBeamOnRowFromDirection(0, Move.NORTH));
        maximumEnergizeLevel = Math.max(maximumEnergizeLevel, shineBeamOnRowFromDirection(grid.length - 1, Move.SOUTH));

        return maximumEnergizeLevel;
    }

    private int shineBeamOnRowFromDirection(int row, Move directionFrom) {
        int maxEnergizeLevel = 0;
        for (int column = 0; column < grid[0].length; column++) {
            System.out.println("Running on column: " + column);
            maxEnergizeLevel = Math.max(maxEnergizeLevel, shineBeamOnPositionFromDirection(new BeamKey(row, column, directionFrom), new HashMap<>()));
        }
        return maxEnergizeLevel;
    }

    private int shineBeamOnColumnFromDirection(int column, Move directionFrom) {
        int maxEnergizeLevel = 0;
        for (int row = 0; row < grid.length; row++) {
            System.out.println("Running on row: " + row);
            maxEnergizeLevel = Math.max(maxEnergizeLevel, shineBeamOnPositionFromDirection(new BeamKey(row, column, directionFrom), new HashMap<>()));
        }
        return maxEnergizeLevel;
    }

    public int getEnergizedTilesForUpperLeftBeam() {
        return  shineBeamOnPositionFromDirection(new BeamKey(0,0, Move.WEST), new HashMap<>());
    }

    private int getCountOfEnergizedTiles(HashMap<BeamKey, Boolean> beamCache) {
        return (int) beamCache.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey().row(), entry.getKey().column()))
                .distinct()
                .count();
    }

    private int shineBeamOnPositionFromDirection(BeamKey beamKey, HashMap<BeamKey, Boolean> beamCache) {
        if (beamCache.containsKey(beamKey)) return 0;
        if (outsideGrid(beamKey)) return 0;

        int currentRow = beamKey.row();
        int currentColumn = beamKey.column();
        Move directionFrom = beamKey.move();

        beamCache.put(beamKey, true);

        List<Move> nextMoves = calculateNextMove(currentRow, currentColumn, directionFrom);

        for (Move nextMove : nextMoves) {
            int nextRow = nextMove.getMoveRow().apply(currentRow);
            int nextColumn = nextMove.getMoveColumn().apply(currentColumn);
            shineBeamOnPositionFromDirection(new BeamKey(nextRow, nextColumn,  oppositeDirectionFrom(nextMove)), beamCache);
        }
        return getCountOfEnergizedTiles(beamCache);
    }

    private List<Move> calculateNextMove(int currentRow, int currentColumn, Move directionFrom) {
        List<Move> nextMoves = new ArrayList<>();
        switch (grid[currentRow][currentColumn]) {
            case '|' -> {
                switch (directionFrom) {
                    case EAST, WEST -> nextMoves.addAll(List.of(Move.NORTH, Move.SOUTH));
                    case NORTH, SOUTH -> nextMoves.add(oppositeDirectionFrom(directionFrom));
                }
            } case '-' -> {
                switch (directionFrom) {
                    case NORTH, SOUTH -> nextMoves.addAll(List.of(Move.EAST, Move.WEST));
                    case EAST, WEST -> nextMoves.add(oppositeDirectionFrom(directionFrom));
                }

            } case '\\' -> {
                switch (directionFrom) {
                    case NORTH -> nextMoves.add(Move.EAST);
                    case SOUTH -> nextMoves.add(Move.WEST);
                    case EAST -> nextMoves.add(Move.NORTH);
                    case WEST -> nextMoves.add(Move.SOUTH);
                }
            } case '/' -> {
                switch (directionFrom) {
                    case NORTH -> nextMoves.add(Move.WEST);
                    case SOUTH -> nextMoves.add(Move.EAST);
                    case EAST -> nextMoves.add(Move.SOUTH);
                    case WEST -> nextMoves.add(Move.NORTH);
                }
            } case '.' -> nextMoves.add(oppositeDirectionFrom(directionFrom));
        }
        return nextMoves;
    }

    private boolean outsideGrid(BeamKey beamKey) {
        return beamKey.row() < 0 ||  beamKey.row() > grid.length - 1 ||  beamKey.column() < 0 || beamKey.column() > grid[0].length - 1;
    }
}
