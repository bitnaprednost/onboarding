package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.hill.climbing.algorithm.algorithms.SelectionEnum;
import net.sf.saxon.expr.Component;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Marko Krišković
 */
public class Ant {
    private State state;

    public Ant(State state) {
        this.state = state;
    }

    public static Optional<Ant> choose(Map<Ant, Double> map) {
        if(map.isEmpty()) return Optional.empty();

        return SelectionEnum.ROULETTE.selectAnt(map);
    }

    public Map<Ant, Double> generateNeighbors(Double[] pheromones) {
        Map<Ant, Double> neighbors = new HashMap<>();

        moveRight().ifPresent(ant -> neighbors.put(ant, pheromones[0]));
        moveDown().ifPresent(ant -> neighbors.put(ant, pheromones[1]));
        moveUp().ifPresent(ant -> neighbors.put(ant, pheromones[2]));
        moveLeft().ifPresent(ant -> neighbors.put(ant, pheromones[3]));

        return neighbors;
    }

    private Optional<Ant> moveUp() {
        if(state.getCurrentPosition().y==0) return Optional.empty();

        return move(state.getCurrentPosition().y - 1, state.getCurrentPosition().x, '^');
    }

    private Optional<Ant> moveDown() {
        if(state.getCurrentPosition().y==state.getMap().length-1) return Optional.empty();

        return move(state.getCurrentPosition().y + 1, state.getCurrentPosition().x, 'v');
    }

    private Optional<Ant> moveLeft() {
        if(state.getCurrentPosition().x==0) return Optional.empty();

        return move(state.getCurrentPosition().y, state.getCurrentPosition().x - 1, '<');
    }

    private Optional<Ant> moveRight() {
        if(state.getCurrentPosition().x==state.getMap()[0].length-1) return Optional.empty();

        return move(state.getCurrentPosition().y, state.getCurrentPosition().x + 1, '>');
    }

    private Optional<Ant> move(int y, int x, char arrow) {
        if (state.getValue(x,y) > state.getValue() + 1 || state.getValue(x,y) < state.getValue() - 2) return Optional.empty();
        else {
            char[][] newStringMap = state.cloneArray(state.getStringMap());
            newStringMap[state.getCurrentPosition().y][state.getCurrentPosition().x] = arrow;

            double heuristic = calculateHeuristic(y, x, 4, 3);
            State newState = new State(state, new Point(x, y), heuristic, newStringMap);
            Ant ant = new Ant(newState);

            return Optional.of(ant);
        }
    }

    public Point getCurrentPosition() {
        return state.getCurrentPosition();
    }

    public char getValue() {
        return state.getValue();
    }

    public char[][] getStringMap() {
        return state.getStringMap();
    }

    public boolean endReached() {
        return state.endReached();
    }

    private double calculateHeuristic(int y, int x, double alpha, double beta) {
        double letterDifference = (state.getValue(x, y) - state.getValue() + 1);
        double distanceFromStart = 1 / state.getEndingPosition().distance(x, y) + 1;

        return Math.pow(distanceFromStart, alpha) + Math.pow(letterDifference, beta);
    }

    public Double getDistanceFromEnd(){
        return state.getEndingPosition().distance(getCurrentPosition().x, getCurrentPosition().y);
    }

    public double getFittness(){
        return state.getHeuristic();
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
