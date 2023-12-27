package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.State;

import java.awt.Point;
import java.util.*;

/**
 * <p>TabooSearch class.</p>
 *
 * @author Marko Krišković
 */
public class TabooSearch implements Algorithm<State>{
    private final Integer tenure;
    private List<State> tabooList;
    private int count;
    private int bestCount;
    private State bestState;

    public TabooSearch(Integer tenure){
        this.tabooList = new ArrayList<>();
        this.tenure = tenure;

        this.count = 0;
        this.bestCount = 100000;
    }

    private void updateList(State state){
        if(tabooList.size()==tenure) tabooList.removeFirst();
        tabooList.add(state);
    }

    @Override
    public State runMultiple(State initialState, int times) {
        State currentState = initialState;
        bestState = initialState;

        for(int i=0;i<times;i++){
            count=0;
            currentState = run(initialState);

            if(currentState.endReached()) {
                if(count < bestCount){
                    bestCount = count;
                    bestState = currentState;
                }
            }
            else{
                if(currentState.getHeuristic() > bestState.getHeuristic()){
                    bestCount = count;
                    bestState = currentState;
                }
            }
        }

        return bestState;
    }

    @Override
    public State run(State currentState) {
        boolean changed=true;
        int tenureCount = tabooList.size()-2;

        for(int i=0;i<300 && changed;i++) {
            if(currentState.getValue()=='{') break;
            changed = false;

            List<State> neighbors = currentState.generateNeighbors();

//            if(currentState.hasNextValue(neighbors)) {
//                State finalCurrentState = currentState;
//                neighbors = neighbors.stream().filter(state -> finalCurrentState.getValue() < state.getValue()).toList();
//            }

            List<State> filtered = neighbors.stream()
                    .filter(neighbor->!tabooList.contains(neighbor))
                    .toList();

            Optional<State> max = State.choose(filtered, SelectionEnum.MIXED);
            if(max.isPresent()){
                currentState = max.get();
                changed = true;
                count++;
                updateList(currentState);
                tenureCount = tabooList.size()-2;
            }
            else if(tenureCount > 0){
                changed = true;
                currentState = tabooList.get(tenureCount--);
            }

        }

        return currentState;
    }

    @Override
    public int getCount() {
        if(bestState==null) return count;
        else return bestCount;
    }
}
