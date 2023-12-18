package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.State;

import java.awt.Point;
import java.util.*;

/**
 * <p>TabooSearch class.</p>
 *
 * @author Marko Krišković
 */
public class TabooSearch implements Algorithm{
    private Integer tenure;
    private List<Point> tabooList;
    private int count;
    private int bestCount;
    private State bestState;

    public TabooSearch(Integer tenure){
        this.tabooList = new ArrayList<>();
        this.tenure=tenure;

        this.count=0;
        this.bestCount = 100000;
    }

    private void updateList(Point point){
        if(tabooList.size()==tenure) tabooList.removeFirst();
        tabooList.add(point);
    }

    @Override
    public State runMultiple(State initialState, int times) {
        State currentState = initialState;

        for(int i=0;i<times;i++){
            count=0;
            currentState = run(initialState);

            if(currentState.endReached()) {
                if(count < bestCount){
                    bestCount = count;
                    bestState = currentState;
                }
            }
        }

        return currentState;
    }

    @Override
    public State run(State currentState) {
        boolean changed;

        do {
            if(currentState.getValue()=='{') break;
            changed = false;

            List<State> neighbors = currentState.generateNeighbors();

            List<State> filtered = neighbors.stream()
                    .filter(neighbor->!tabooList.contains(neighbor.getCurrentPosition()))
                    .toList();

            Optional<State> max = State.choose(filtered);
            if(max.isPresent()){
                currentState = max.get();
                changed = true;
            }

            updateList(currentState.getCurrentPosition());
            count++;
        }while(changed);

        return currentState;
    }

    @Override
    public int getCount() {
        if(bestState==null) return count;
        else return bestCount;
    }
}
