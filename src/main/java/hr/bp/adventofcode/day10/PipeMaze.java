package hr.bp.adventofcode.day10;

import hr.bp.adventofcode.Pair;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class PipeMaze {

    private GridElement[][] grid;

    private Integer startingPositionRowIndex;
    private Integer startingPositionColumnIndex;

    public PipeMaze(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        initializeGrid(input);
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

    public int findFarthestPosition() {
        Pair<Pair<Integer, Integer>, Move> nextGridElementMove = findNextMoveFromStartingPosition();
        return moveThroughMaze(nextGridElementMove.left().left(), nextGridElementMove.left().right(), nextGridElementMove.right()) / 2;
    }

    private int moveThroughMaze(Integer row, Integer column, Move previousMove) {
        GridElement currentElement = grid[row][column];
        
        if (currentElement.equals(GridElement.STARTING_POSITION)) return 1;

        Move nextMove = currentElement.nextMove(previousMove);

        int nextRow = nextMove.getMoveRow().apply(row);
        int nextColumn = nextMove.getMoveColumn().apply(column);

        return 1 + moveThroughMaze(nextRow, nextColumn, nextMove);
    }

    private Pair<Pair<Integer, Integer>, Move> findNextMoveFromStartingPosition() {
        int row = startingPositionRowIndex;
        int column = startingPositionColumnIndex;

        if (canConnectNorthFromStartingPosition()) {
            return new Pair<>(new Pair<>(row-1, column), Move.NORTH);
        } else if (canConnectSouthFromStartingPosition()) {
            return new Pair<>(new Pair<>(row+1, column), Move.SOUTH);
        } else if (canConnectWestFromStartingPosition()) {
            return new Pair<>(new Pair<>(row, column-1), Move.WEST);
        } else if (canConnectEastFromStartingPosition()) {
            return new Pair<>(new Pair<>(row, column+1), Move.EAST);
        } else {
            throw new IllegalArgumentException("Grid is invalid, you cannot move anywhere from starting position");
        }
    }

    private boolean canConnectNorthFromStartingPosition() {
        if (startingPositionRowIndex < 1) return false;

        GridElement northernElement = grid[startingPositionRowIndex - 1][startingPositionColumnIndex];

        return List.of(GridElement.SOUTH_WEST, GridElement.SOUTH_EAST, GridElement.NORTH_SOUTH).contains(northernElement);
    }

    private boolean canConnectSouthFromStartingPosition() {
        if (startingPositionRowIndex >= grid.length - 1) return false;

        GridElement southernElement = grid[startingPositionRowIndex + 1][startingPositionColumnIndex];

        return List.of(GridElement.NORTH_EAST, GridElement.NORTH_WEST, GridElement.NORTH_SOUTH).contains(southernElement);
    }

    private boolean canConnectWestFromStartingPosition() {
        if (startingPositionColumnIndex < 1) return false;

        GridElement northernElement = grid[startingPositionRowIndex][startingPositionColumnIndex - 1];

        return List.of(GridElement.NORTH_EAST, GridElement.SOUTH_EAST, GridElement.EAST_WEST).contains(northernElement);
    }

    private boolean canConnectEastFromStartingPosition() {
        if (startingPositionColumnIndex >= grid[0].length - 1) return false;

        GridElement southernElement = grid[startingPositionRowIndex][startingPositionColumnIndex + 1];

        return List.of(GridElement.NORTH_WEST, GridElement.SOUTH_WEST, GridElement.EAST_WEST).contains(southernElement);
    }

    public GridElement[][] getGrid() {
        return grid;
    }
}
