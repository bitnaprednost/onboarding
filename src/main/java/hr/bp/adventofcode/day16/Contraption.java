package hr.bp.adventofcode.day16;

import hr.bp.adventofcode.Move;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static hr.bp.adventofcode.Move.oppositeDirectionFrom;

public class Contraption {

    private char[][] grid;

    private final ExecutorService executor;

    public Contraption(String input) {
        parseInput(input);
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    private void parseInput(String input) {
        String[] lines = input.split("\\s+");
        grid = new char[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }
    }

    public int countEnergizedTilesWhenBeamEntersAllDirections() throws InterruptedException, ExecutionException {
        int maximumEnergizeLevel = 0;

        maximumEnergizeLevel = Math.max(maximumEnergizeLevel, calculateMaxForDirection(0, Move.WEST, true));
        maximumEnergizeLevel = Math.max(maximumEnergizeLevel, calculateMaxForDirection(grid[0].length - 1, Move.EAST, true));
        maximumEnergizeLevel = Math.max(maximumEnergizeLevel, calculateMaxForDirection(0, Move.NORTH, false));
        maximumEnergizeLevel = Math.max(maximumEnergizeLevel, calculateMaxForDirection(grid.length - 1, Move.SOUTH, false));

        executor.shutdown();

        return maximumEnergizeLevel;
    }

    private int calculateMaxForDirection(int fixedIndex, Move directionFrom, boolean isColumn) throws InterruptedException, ExecutionException {
        List<Future<Integer>> futures = new ArrayList<>();

        int range = isColumn ? grid.length : grid[0].length;

        for (int i = 0; i < range; i++) {
            final int row = isColumn ? i : fixedIndex;
            final int column = isColumn ? fixedIndex : i;

            futures.add(executor.submit(() -> {
                HashSet<BeamKey> beamCache = new HashSet<>();
                shineBeamOnPositionFromDirection(
                        new BeamKey(row, column, directionFrom), beamCache);
                return getCountOfEnergizedTiles(beamCache);
            }));
        }

        int maxEnergizeLevel = 0;
        for (Future<Integer> future : futures) {
            maxEnergizeLevel = Math.max(maxEnergizeLevel, future.get());
        }

        return maxEnergizeLevel;
    }

    public int getEnergizedTilesForUpperLeftBeam() {
        HashSet<BeamKey> beamCache = new HashSet<>();
        shineBeamOnPositionFromDirection(new BeamKey(0, 0, Move.WEST), beamCache);
        return getCountOfEnergizedTiles(beamCache);
    }

    private int getCountOfEnergizedTiles(HashSet<BeamKey> beamCache) {
        return (int) beamCache.stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.row(), entry.column()))
                .distinct()
                .count();
    }

    private void shineBeamOnPositionFromDirection(BeamKey beamKey, Set<BeamKey> beamCache) {
        if (beamCache.contains(beamKey)) return;
        if (outsideGrid(beamKey)) return;

        int currentRow = beamKey.row();
        int currentColumn = beamKey.column();
        Move directionFrom = beamKey.move();

        beamCache.add(beamKey);

        List<Move> nextMoves = calculateNextMove(currentRow, currentColumn, directionFrom);

        for (Move nextMove : nextMoves) {
            int nextRow = nextMove.getMoveRow().apply(currentRow);
            int nextColumn = nextMove.getMoveColumn().apply(currentColumn);

            shineBeamOnPositionFromDirection(new BeamKey(nextRow, nextColumn, oppositeDirectionFrom(nextMove)), beamCache);
        }
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
        return beamKey.row() < 0 || beamKey.row() > grid.length - 1 || beamKey.column() < 0 || beamKey.column() > grid[0].length - 1;
    }
}
