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
    private double[][][] fittness;

    public Ant(State state) {
        this.state = state;
        fittness = new double[state.getStringMap().length][state.getStringMap()[0].length][4];
    }
    public Ant(State state, double[][][] fittness) {
        this.state = state;
        this.fittness = fittness;
    }

    public Ant(Ant ant){
        this.state = ant.state;
        fittness = new double[state.getStringMap().length][state.getStringMap()[0].length][4];
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

    private Optional<Ant> moveRight() {
        if(state.getCurrentPosition().x==state.getMap()[0].length-1) return Optional.empty();

        Optional<Ant> ant = move(state.getCurrentPosition().y, state.getCurrentPosition().x + 1, '>');

        if (ant.isPresent() && fittness[state.getCurrentPosition().y][state.getCurrentPosition().x][0] == 0) {
            fittness[state.getCurrentPosition().y][state.getCurrentPosition().x][0] = ant.get().state.getHeuristic();
            return ant;
        }

        return Optional.empty();
    }

    private Optional<Ant> moveDown() {
        if(state.getCurrentPosition().y==state.getMap().length-1) return Optional.empty();

        Optional<Ant> ant = move(state.getCurrentPosition().y + 1, state.getCurrentPosition().x, 'v');

        if (ant.isPresent() && fittness[state.getCurrentPosition().y][state.getCurrentPosition().x][1] == 0) {
            fittness[state.getCurrentPosition().y][state.getCurrentPosition().x][1] = ant.get().state.getHeuristic();
            return ant;
        }

        return Optional.empty();
    }

    private Optional<Ant> moveUp() {
        if(state.getCurrentPosition().y==0) return Optional.empty();

        Optional<Ant> ant = move(state.getCurrentPosition().y - 1, state.getCurrentPosition().x, '^');

        if (ant.isPresent() && fittness[state.getCurrentPosition().y][state.getCurrentPosition().x][2] == 0) {
            fittness[state.getCurrentPosition().y][state.getCurrentPosition().x][2] = ant.get().state.getHeuristic();
            return ant;
        }

        return Optional.empty();
    }

    private Optional<Ant> moveLeft() {
        if(state.getCurrentPosition().x==0) return Optional.empty();

        Optional<Ant> ant = move(state.getCurrentPosition().y, state.getCurrentPosition().x - 1, '<');

        if (ant.isPresent() && fittness[state.getCurrentPosition().y][state.getCurrentPosition().x][3] == 0) {
            fittness[state.getCurrentPosition().y][state.getCurrentPosition().x][3] = ant.get().state.getHeuristic();
            return ant;
        }

        return Optional.empty();
    }

    private Optional<Ant> move(int y, int x, char arrow) {
        if (state.getValue(x,y) > state.getValue() + 1 || state.getValue(x,y) < state.getValue() - 2) return Optional.empty();
        else {
            char[][] newStringMap = state.cloneArray(state.getStringMap());
            newStringMap[state.getCurrentPosition().y][state.getCurrentPosition().x] = arrow; //getValue();

            double heuristic = calculateHeuristic(y, x, -3, -2);
            State newState = new State(state, new Point(x, y), heuristic, newStringMap);
            Ant ant = new Ant(newState, fittness);

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
        double distanceFromEnd = state.getStartingPosition().distance(x, y) / (state.getEndingPosition().distance(x, y) + 1) + 1;
        double letterDifference = (state.getValue(x, y) - state.getValue() + 2) / 3.0 + 1;

        return Math.pow(distanceFromEnd, alpha) * Math.pow(letterDifference, beta);
    }

    public Double getDistanceFromEnd(){
        return state.getEndingPosition().distance(getCurrentPosition().x, getCurrentPosition().y);
    }

    public double getFittness(int y, int x, int k){
        return fittness[y][x][k];
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
