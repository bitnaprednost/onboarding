package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.hill.climbing.algorithm.algorithms.SelectionEnum;
import net.sf.saxon.expr.Component;
import org.w3c.dom.Entity;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.*;

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
    private final Point endingPosition;
    private final double heuristic;


    public State(State prev, Point currentPosition, double heuristic, char[][] stringMap) {
        this.currentPosition = currentPosition;
        this.heuristic = heuristic;
        this.stringMap = stringMap;

        this.map = prev.map;
        this.startingPosition = prev.startingPosition;
        this.endingPosition = prev.endingPosition;
    }

    public State(char[][] map,  Point startingPosition, Point endingPosition, char[][] stringMap) {
        this.map = map;
        this.currentPosition = startingPosition;
        this.heuristic = 0;
        this.stringMap = stringMap;
        this.startingPosition = startingPosition;
        this.endingPosition = endingPosition;
    }

    public List<State> generateNeighbors(){
        List<State> neighbors = new ArrayList<>();

        moveRight().ifPresent(neighbors::add);
        moveDown().ifPresent(neighbors::add);
        moveUp().ifPresent(neighbors::add);
        moveLeft().ifPresent(neighbors::add);

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
        if (map[y][x] > map[currentPosition.y][currentPosition.x] + 1 || map[y][x] < map[currentPosition.y][currentPosition.x] - 1) return Optional.empty();
        else {
            char[][] newStringMap = cloneArray(stringMap);
            newStringMap[currentPosition.y][currentPosition.x] = arrow;

            double heuristic = calculateHeuristic(y, x, 1000, 30, 10);
            State state = new State(this, new Point(x, y), heuristic, newStringMap);

            return Optional.of(state);
        }
    }

    public static Optional<State> choose(List<State> list, SelectionEnum selection){
        if(list.isEmpty()) return Optional.empty();

        return selection.select(list);
    }

    public boolean hasNextValue(List<State> list) {
        for(State state : list){
            if(state.getValue() > this.getValue()) return true;
        }
        return false;
    }

    private double calculateHeuristic(int y, int x, double alpha, double beta, double gamma) {
        double letterDifference = (map[y][x] - map[currentPosition.y][currentPosition.x] + 1) * alpha;
        double distanceFromStart = endingPosition.distance(x, y) * beta + 1;
        double distanceFromNextLetter = approximateNextLetterPosition(getValue()).distance(x,y) * gamma;

        return letterDifference / (distanceFromStart + distanceFromNextLetter);// + map[y][x];
    }

    private Point2D approximateNextLetterPosition(char value) {
        int count = 0;
        Point approximate = new Point(0, 0);
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j] == value+1) {
                    approximate.x += j;
                    approximate.y += i;
                    count++;
                }
            }
        }
        if(count==0) return currentPosition;

        approximate.x /= count;
        approximate.y /= count;
        return approximate;
    }

    public char[][] cloneArray(char[][] array){
        return Arrays.stream(array).map(char[]::clone).toArray(char[][]::new);
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public char getValue(){
        return map[currentPosition.y][currentPosition.x];
    }
    public char getValue(int x, int y){
        return map[y][x];
    }

    public boolean endReached(){
        return currentPosition.equals(endingPosition);
    }

    public char[][] getStringMap() {
        return stringMap;
    }

    public char[][] getMap() {
        return map;
    }

    public Point getEndingPosition() {
        return endingPosition;
    }

    public Point getStartingPosition() {
        return startingPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State state)) return false;

        if (Double.compare(heuristic, state.heuristic) != 0) return false;
        if (!Arrays.deepEquals(map, state.map)) return false;
        if (!Objects.equals(currentPosition, state.currentPosition))
            return false;
        if (!Objects.equals(startingPosition, state.startingPosition))
            return false;
        return Objects.equals(endingPosition, state.endingPosition);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Arrays.deepHashCode(map);
        result = 31 * result + (currentPosition != null ? currentPosition.hashCode() : 0);
        result = 31 * result + (startingPosition != null ? startingPosition.hashCode() : 0);
        result = 31 * result + (endingPosition != null ? endingPosition.hashCode() : 0);
        temp = Double.doubleToLongBits(heuristic);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
