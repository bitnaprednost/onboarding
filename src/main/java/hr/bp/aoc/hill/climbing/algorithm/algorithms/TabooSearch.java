package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.State;

import java.awt.Point;
import java.util.*;

public class TabooSearch implements Algorithm{
    private Integer tenure;
    private List<Point> tabooList;

    public TabooSearch(Integer tenure){
        this.tabooList = new ArrayList<>();
        this.tenure=tenure;
    }

    private void updateList(Point point){
        if(tabooList.size()==tenure) tabooList.removeFirst();
        tabooList.add(point);
    }

    @Override
    public State run(State initialState) {
        Random random = new Random();
        State currentState = initialState;

        boolean changed;
        do {
            if(currentState.getValue()=='{') break;
            changed = false;

            List<State> neighbors = currentState.generateNeighbors();

            List<State> filtered = neighbors.stream()
                    .filter(neighbor->!tabooList.contains(neighbor.getCurrentPosition()))
                    .sorted(Comparator.comparing(State::getHeuristic).reversed())
                    .toList();

            Optional<State> max = Optional.of(filtered.getFirst());//choose(filtered, random);
            if(max.isPresent()){
                currentState = max.get();
                changed = true;
            }
            updateList(currentState.getCurrentPosition());
        }while(changed);

        return currentState;
    }

    private Optional<State> choose(List<State> list, Random random){
        if(list.isEmpty()) return Optional.empty();

        if(list.size() >= 2){
            int randInt = random.nextInt(2);
            return Optional.of(list.get(randInt));
        }

        return Optional.empty();
    }
}
