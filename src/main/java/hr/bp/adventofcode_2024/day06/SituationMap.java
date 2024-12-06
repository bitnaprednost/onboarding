package hr.bp.adventofcode_2024.day06;

import hr.bp.adventofcode_2024.GridCoordinates;
import hr.bp.adventofcode_2024.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static hr.bp.adventofcode_2024.Utils.parseGridTo2DArray;

/**
 * @author Ivan Tomičić
 */
public class SituationMap {

    private final HashMap<Integer, List<Integer>> obstaclesOnColumnsMap = new HashMap<>();

    private final HashMap<Integer, List<Integer>> obstaclesOnRowsMap = new HashMap<>();

    private GuardPosition guardPosition;

    private GridCoordinates biggestCoordinates;


    public SituationMap(String input) {
        parseInput(input);
    }

    private void parseInput(String input) {
        char[][] map = parseGridTo2DArray(input);
        biggestCoordinates = new GridCoordinates(map.length - 1, map[0].length - 1);

        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[0].length; column++) {

                if (map[row][column] == '#') {
                    obstaclesOnColumnsMap.computeIfAbsent(column, c -> new ArrayList<>()).add(row);
                    obstaclesOnRowsMap.computeIfAbsent(row, r -> new ArrayList<>()).add(column);

                } else if (List.of('<', '>', '^', 'v').contains(map[row][column])) {
                    guardPosition = new GuardPosition(row, column, Direction.getDirectionForSign(map[row][column]));
                }
            }
        }
    }

    public int countDistinctPositions() {
        Set<Pair<Integer, Integer>> distinctPositionsVisited = new HashSet<>();

        walkToNextPosition(guardPosition, distinctPositionsVisited);

        return distinctPositionsVisited.size();
    }

    private void walkToNextPosition(GuardPosition guardPosition, Set<Pair<Integer, Integer>> distinctPositionsVisited) {

        GuardPosition nextGuardPosition = getNextGuardPosition(guardPosition);

        distinctPositionsVisited.addAll(Pair.getAllIntegerPairsBetween(guardPosition.row(), guardPosition.column(), nextGuardPosition.row(), nextGuardPosition.column()));

        if (isOnBorder(nextGuardPosition)) return;

        walkToNextPosition(nextGuardPosition, distinctPositionsVisited);
    }

    private GuardPosition getNextGuardPosition(GuardPosition guardPosition) {
        int nextRow = guardPosition.row();
        int nextColumn = guardPosition.column();

        if (List.of(Direction.SOUTH, Direction.NORTH).contains(guardPosition.direction())) {
            List<Integer> possibleObstacles = obstaclesOnColumnsMap.get(guardPosition.column())
                    .stream()
                    .filter(obstacleOnColumn -> {
                        if (Direction.SOUTH.equals(guardPosition.direction())) return obstacleOnColumn > guardPosition.row();
                        else return obstacleOnColumn < guardPosition.row();
                    })
                    .toList();
            if (Direction.NORTH.equals(guardPosition.direction())) {
                nextRow = possibleObstacles.isEmpty() ? 0 : possibleObstacles.getLast() + 1;
            } else {
                nextRow = possibleObstacles.isEmpty() ? biggestCoordinates.row() : possibleObstacles.getFirst() - 1;
            }

        } else {
            List<Integer> possibleObstacles = obstaclesOnRowsMap.get(guardPosition.row())
                    .stream()
                    .filter(obstacleOnRow -> {
                        if (Direction.EAST.equals(guardPosition.direction())) return obstacleOnRow > guardPosition.column();
                        else return obstacleOnRow < guardPosition.column();
                    })
                    .toList();
            if (Direction.WEST.equals(guardPosition.direction())) {
                nextColumn = possibleObstacles.isEmpty() ? 0 : possibleObstacles.getLast() + 1;
            } else {
                nextColumn = possibleObstacles.isEmpty() ? biggestCoordinates.column() : possibleObstacles.getFirst() - 1;
            }
        }

        return new GuardPosition(nextRow, nextColumn, Direction.turnNinetyDegrees(guardPosition.direction()));
    }

    private boolean isOnBorder(GuardPosition guardPosition) {
        return guardPosition.row() == 0 || guardPosition.row() == biggestCoordinates.row() || guardPosition.column() == 0 || guardPosition.column() == biggestCoordinates.column();
    }
}
