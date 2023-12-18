package hr.bp.aoc.hill.climbing.algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * <p>State class.</p>
 *
 * @author Marko Krišković
 */
public class State {
    private final char[][] map;
    private final char[][] stringMap;
    private final Point currentPosition;
    private final Point startingPosition;
    private final int heuristic;


    public State(State prev, Point currentPosition, int heuristic, char[][] stringMap) {
        this.currentPosition = currentPosition;
        this.heuristic = heuristic;
        this.stringMap = stringMap;

        this.map = prev.map;
        this.startingPosition = prev.startingPosition;
    }

    public State(char[][] map,  Point startingPosition, char[][] stringMap) {
        this.map = map;
        this.currentPosition = startingPosition;
        this.heuristic = 0;
        this.stringMap = stringMap;
        this.startingPosition = startingPosition;
    }

    public List<State> generateNeighbors(){
        List<State> neighbors = new ArrayList<>();

        moveUp().ifPresent(neighbors::add);
        moveDown().ifPresent(neighbors::add);
        moveLeft().ifPresent(neighbors::add);
        moveRight().ifPresent(neighbors::add);

        return neighbors;
    }

    private Optional<State> moveUp() {
        if(currentPosition.y==0) return Optional.empty();

        return move(currentPosition.y - 1, currentPosition.x, '^');
    }

    private Optional<State> moveDown() {
        if(currentPosition.y==map.length-1) return Optional.empty();

        return move(currentPosition.y + 1, currentPosition.x, 'v');
    }

    private Optional<State> moveLeft() {
        if(currentPosition.x==0) return Optional.empty();

        return move(currentPosition.y, currentPosition.x - 1, '<');
    }

    private Optional<State> moveRight() {
        if(currentPosition.x==map[0].length-1) return Optional.empty();

        return move(currentPosition.y, currentPosition.x + 1, '>');
    }

    private Optional<State> move(int y, int x, char arrow) {
        if (map[y][x] > map[currentPosition.y][currentPosition.x] + 1) return Optional.empty();
        else {
            char[][] newStringMap = cloneArray(stringMap);
            newStringMap[currentPosition.y][currentPosition.x] = arrow;

            int heuristicDiff = calculateHeuristic(y, x);
            State state = new State(this, new Point(x, y), heuristic + heuristicDiff, newStringMap);

            return Optional.of(state);
        }
    }

    private int calculateHeuristic(int y, int x) {
        int letterDifference = map[y][x] - map[currentPosition.y][currentPosition.x];
        double distanceFromStart = startingPosition.distance(x, y) * 10;

        return letterDifference*100 + (int) distanceFromStart;
    }

    private char[][] cloneArray(char[][] array){
        return Arrays.stream(array).map(char[]::clone).toArray(char[][]::new);
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public char getValue(){
        return map[currentPosition.y][currentPosition.x];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<stringMap.length;i++){
            for(int j=0;j<stringMap[0].length;j++){
                if(i!=currentPosition.y || j!=currentPosition.x) sb.append(stringMap[i][j]);
                else sb.append(getValue());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
