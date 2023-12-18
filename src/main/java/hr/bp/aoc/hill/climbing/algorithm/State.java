package hr.bp.aoc.hill.climbing.algorithm;

import org.w3c.dom.Entity;

import java.awt.Point;
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
    private static final Random random =  new Random();


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
        if (map[y][x] > map[currentPosition.y][currentPosition.x] + 1 || map[y][x] < map[currentPosition.y][currentPosition.x]) return Optional.empty();
        else {
            char[][] newStringMap = cloneArray(stringMap);
            newStringMap[currentPosition.y][currentPosition.x] = arrow;

            double heuristic = calculateHeuristic(y, x);
            State state = new State(this, new Point(x, y), heuristic, newStringMap);

            return Optional.of(state);
        }
    }

    public static Optional<State> choose(List<State> list){
        if(list.isEmpty()) return Optional.empty();

        //if(list.size()>1) save(state)

        return selectTournament(list);
    }

    private static Optional<State> selectRoulette(List<State> list) {
        double sum = list.stream().mapToDouble(State::getHeuristic).sum();

        Map<State, Double> map = new LinkedHashMap<>();
        double initial = 0;
        for(State state : list){
            initial += state.heuristic / sum;
            map.put(state, initial);
        }

        double rand = random.nextDouble();
        for(Map.Entry<State, Double> entry : map.entrySet()){
            if(rand <= entry.getValue()) return Optional.of(entry.getKey());
        }

        return Optional.empty();
    }

    private static Optional<State> selectTournament(List<State> list) {
        return switch (list.size()){
            case 1 -> Optional.of(list.getFirst());
            case 2 -> Optional.of(versus(list.get(0), list.get(1)));
            default -> {
                int randInt1 = random.nextInt(list.size());
                int randInt2 = random.nextInt(list.size());
                yield Optional.of(versus(list.get(randInt1), list.get(randInt2)));
            }
        };
    }

    private static State versus(State state0, State state1) {
        if(state0.heuristic >= state1.heuristic) return state0;
        else return state1;
    }

    private double calculateHeuristic(int y, int x) {
        double distanceFromStart = endingPosition.distance(x, y);

        return 100 / (distanceFromStart+1);
    }

    private char[][] cloneArray(char[][] array){
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

    public boolean endReached(){
        return currentPosition.equals(endingPosition);
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
