package hr.bp.adventofcode.day10;

import hr.bp.adventofcode.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class PipeMaze {

    private GridElement[][] grid;

    private final List<Pair<Integer, Integer>> edges = new ArrayList<>();

    private Integer startingPositionRowIndex;
    private Integer startingPositionColumnIndex;

    private int farthestPosition;

    public PipeMaze(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        initializeGrid(input);
        setFarthestPosition();
    }

    private void checkIfStartingPositionIsEdge() {
        if (!(canMoveNorthFromStartingPosition() && canMoveSouthFromStartingPosition())
                && !(canMoveEastFromStartingPosition() && canMoveWestFromStartingPosition())) {
            edges.add(new Pair<>(startingPositionRowIndex, startingPositionColumnIndex));
        }
    }

    private void setFarthestPosition() {
        Pair<Pair<Integer, Integer>, Move> nextGridElementMove = findNextMoveFromStartingPosition();
        this.farthestPosition = moveThroughMaze(nextGridElementMove.left().left(), nextGridElementMove.left().right(), nextGridElementMove.right()) / 2 + 1;
    }

    public int getFarthestPosition() {
        return this.farthestPosition;
    }

    private void initializeGrid(String input) {
        String[] lines = input.split("\\n");

        grid = new GridElement[lines.length][];

        int rowIndex = 0;

        for (String line : lines) {
            addRowToGrid(line, rowIndex++);
        }
    }

    private void addRowToGrid(String line, int rowIndex) {
        GridElement[] row = new GridElement[line.length()];

        for (int i = 0; i < line.length(); i++) {

            String element = line.substring(i, i+1);
            row[i] = GridElement.fromSymbol(element);

            if (element.equals("S")) {
                startingPositionRowIndex = rowIndex;
                startingPositionColumnIndex = i;
            }
        }
        grid[rowIndex] = row;
    }

    private int moveThroughMaze(Integer row, Integer column, Move previousMove) {
        checkIfStartingPositionIsEdge();

        GridElement currentElement = grid[row][column];
        int sum = 0;

        while (!currentElement.equals(GridElement.STARTING_POSITION)) {
            Move move = currentElement.nextMove(previousMove);

            if (currentElement.isEdge()) {
                edges.add(new Pair<> (row, column));
            }

            row = move.getMoveRow().apply(row);
            column = move.getMoveColumn().apply(column);
            previousMove = move;

            currentElement = grid[row][column];

            sum++;
        }
        return sum;
    }

    private Pair<Pair<Integer, Integer>, Move> findNextMoveFromStartingPosition() {
        int row = startingPositionRowIndex;
        int column = startingPositionColumnIndex;

        if (canMoveNorthFromStartingPosition()) {
            return new Pair<>(new Pair<>(row-1, column), Move.NORTH);

        } else if (canMoveSouthFromStartingPosition()) {
            return new Pair<>(new Pair<>(row+1, column), Move.SOUTH);

        } else if (canMoveWestFromStartingPosition()) {
            return new Pair<>(new Pair<>(row, column-1), Move.WEST);

        } else if (canMoveEastFromStartingPosition()) {
            return new Pair<>(new Pair<>(row, column+1), Move.EAST);

        } else {
            throw new IllegalArgumentException("Grid is invalid, you cannot move anywhere from starting position");
        }
    }

    private boolean canMoveNorthFromStartingPosition() {
        if (startingPositionRowIndex < 1) return false;

        GridElement northernElement = grid[startingPositionRowIndex - 1][startingPositionColumnIndex];

        return List.of(GridElement.SOUTH_WEST, GridElement.SOUTH_EAST, GridElement.NORTH_SOUTH).contains(northernElement);
    }

    private boolean canMoveSouthFromStartingPosition() {
        if (startingPositionRowIndex >= grid.length - 1) return false;

        GridElement southernElement = grid[startingPositionRowIndex + 1][startingPositionColumnIndex];

        return List.of(GridElement.NORTH_EAST, GridElement.NORTH_WEST, GridElement.NORTH_SOUTH).contains(southernElement);
    }

    private boolean canMoveWestFromStartingPosition() {
        if (startingPositionColumnIndex < 1) return false;

        GridElement northernElement = grid[startingPositionRowIndex][startingPositionColumnIndex - 1];

        return List.of(GridElement.NORTH_EAST, GridElement.SOUTH_EAST, GridElement.EAST_WEST).contains(northernElement);
    }

    private boolean canMoveEastFromStartingPosition() {
        if (startingPositionColumnIndex >= grid[0].length - 1) return false;

        GridElement southernElement = grid[startingPositionRowIndex][startingPositionColumnIndex + 1];

        return List.of(GridElement.NORTH_WEST, GridElement.SOUTH_WEST, GridElement.EAST_WEST).contains(southernElement);
    }

    // https://en.wikipedia.org/wiki/Pick%27s_theorem
    public int calculateDotsInsideTheMainLoop() {
        int A = calculateAreaOfTheMainLoop();
        int b = farthestPosition*2;
        return A -b/2 + 1;
    }

    // https://en.wikipedia.org/wiki/Shoelace_formula
    private int calculateAreaOfTheMainLoop() {
        int sum = 0;
        for (int i = 0; i < edges.size(); i++) {
            sum += calculateDeterminant(edges.get(i), edges.get((i+1) % edges.size()));
        }
        return Math.abs(sum)/2;
    }

    private int calculateDeterminant(Pair<Integer, Integer> edge1, Pair<Integer, Integer> edge2) {
        return edge1.left() * edge2.right() - edge2.left() * edge1.right();
    }

    public GridElement[][] getGrid() {
        return grid;
    }
}
