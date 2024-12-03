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

    private HashMap<BeamKey, Boolean> beamCache = new HashMap<>();

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

    public int countEnergizedTiles() {
        shineBeamOnPositionTowards(new BeamKey(0,0, Move.WEST));

        return (int) beamCache.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey().row(), entry.getKey().column()))
                .distinct()
                .count();
    }

    private void shineBeamOnPositionTowards(BeamKey beamKey) {
        if (beamCache.containsKey(beamKey)) return;

        int currentRow = beamKey.row();
        int currentColumn = beamKey.column();
        Move directionFrom = beamKey.move();

        if (outsideGrid(currentRow, currentColumn)) return;

        beamCache.put(beamKey, true);

        List<Move> nextMoves = new ArrayList<>();

        calculateNextMove(currentRow, currentColumn, directionFrom, nextMoves);

        for (Move nextMove : nextMoves) {
            int nextRow = nextMove.getMoveRow().apply(currentRow);
            int nextColumn = nextMove.getMoveColumn().apply(currentColumn);
            shineBeamOnPositionTowards(new BeamKey(nextRow, nextColumn,  oppositeDirectionFrom(nextMove)));
        }

    }

    private void calculateNextMove(int currentRow, int currentColumn, Move directionFrom, List<Move> nextMoves) {
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
    }

    private boolean outsideGrid(int row, int column) {
        return row < 0 || row > grid.length - 1 || column < 0 || column > grid[0].length - 1;
    }
}
