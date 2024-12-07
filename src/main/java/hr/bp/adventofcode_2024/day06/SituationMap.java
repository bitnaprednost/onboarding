package hr.bp.adventofcode_2024.day06;

import hr.bp.adventofcode_2024.GridCoordinates;
import hr.bp.adventofcode_2024.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    public int countWaysToMakeALoop() {
        int sum = 0;
        for (int row = 0; row <= biggestCoordinates.row(); row++) {
            for (int column = 0; column <= biggestCoordinates.column(); column++) {
                if (guardPosition.row() == row && guardPosition.column() == column) continue;
                if (obstaclesOnRowsMap.get(row) != null && obstaclesOnRowsMap.get(row).contains(column)) continue;
                else {
                    sum += checkIfNewObstacleCausesALoop(row, column) ? 1 : 0;
                }
            }
        }

        return sum;
    }

    private boolean checkIfNewObstacleCausesALoop(int row, int column) {
        HashMap<Integer, List<Integer>> deepCopyObstaclesOnRowsMap = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : obstaclesOnRowsMap.entrySet()) {
            deepCopyObstaclesOnRowsMap.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }

        HashMap<Integer, List<Integer>> deepCopyObstaclesOnColumnsMap = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : obstaclesOnColumnsMap.entrySet()) {
            deepCopyObstaclesOnColumnsMap.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }

        deepCopyObstaclesOnRowsMap.computeIfAbsent(row, k -> new ArrayList<>()).add(column);
        deepCopyObstaclesOnColumnsMap.computeIfAbsent(column, k -> new ArrayList<>()).add(row);

        deepCopyObstaclesOnRowsMap.get(row).sort(Integer::compareTo);
        deepCopyObstaclesOnColumnsMap.get(column).sort(Integer::compareTo);

        Set<GuardPosition> guardPositions = new HashSet<>();
        GuardPosition currentGuardPosition = guardPosition;
        guardPositions.add(guardPosition);

        while (!isOnBorder(currentGuardPosition)) {
            GuardPosition nextGuardPosition = getNextGuardPosition(currentGuardPosition, deepCopyObstaclesOnRowsMap, deepCopyObstaclesOnColumnsMap);
            if (guardPositions.contains(nextGuardPosition)) return true;
            guardPositions.add(nextGuardPosition);
            currentGuardPosition = nextGuardPosition;

        }
        return false;
    }

    private void walkToNextPosition(GuardPosition guardPosition, Set<Pair<Integer, Integer>> distinctPositionsVisited) {

        GuardPosition nextGuardPosition = getNextGuardPosition(guardPosition, obstaclesOnRowsMap, obstaclesOnColumnsMap);

        distinctPositionsVisited.addAll(Pair.getAllIntegerPairsBetween(guardPosition.row(), guardPosition.column(), nextGuardPosition.row(), nextGuardPosition.column()));

        if (isOnBorder(nextGuardPosition)) return;

        walkToNextPosition(nextGuardPosition, distinctPositionsVisited);
    }

    private GuardPosition getNextGuardPosition(GuardPosition guardPosition, HashMap<Integer, List<Integer>> obstaclesOnRowsMap, HashMap<Integer, List<Integer>> obstaclesOnColumnsMap) {
        boolean isVertical = List.of(Direction.SOUTH, Direction.NORTH).contains(guardPosition.direction());
        boolean isPositiveDirection = List.of(Direction.SOUTH, Direction.EAST).contains(guardPosition.direction());

        List<Integer> obstaclesCoordinates = (isVertical ? obstaclesOnColumnsMap.get(guardPosition.column()) : obstaclesOnRowsMap.get(guardPosition.row()));

        if (obstaclesCoordinates == null) {
            obstaclesCoordinates = new ArrayList<>();
        } else {
            obstaclesCoordinates= obstaclesCoordinates.stream()
                    .filter(coordinate -> isPositiveDirection ? coordinate > (isVertical ? guardPosition.row() : guardPosition.column())
                            : coordinate < (isVertical ? guardPosition.row() : guardPosition.column()))
                    .toList();
        }

        int nextRow = guardPosition.row();
        int nextColumn = guardPosition.column();

        if (isVertical) {
            nextRow = obstaclesCoordinates.isEmpty()
                    ? (isPositiveDirection ? biggestCoordinates.row() : 0)
                    : (isPositiveDirection ? obstaclesCoordinates.getFirst() - 1 : obstaclesCoordinates.getLast() + 1);
        } else {
            nextColumn = obstaclesCoordinates.isEmpty()
                    ? (isPositiveDirection ? biggestCoordinates.column() : 0)
                    : (isPositiveDirection ? obstaclesCoordinates.getFirst() - 1 : obstaclesCoordinates.getLast() + 1);
        }

        return new GuardPosition(nextRow, nextColumn, Direction.turnNinetyDegrees(guardPosition.direction()));
    }

    private boolean isOnBorder(GuardPosition guardPosition) {
        return guardPosition.row() == 0 || guardPosition.row() == biggestCoordinates.row() || guardPosition.column() == 0 || guardPosition.column() == biggestCoordinates.column();
    }
}
