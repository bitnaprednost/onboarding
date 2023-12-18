package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.State;

import java.util.List;
import java.util.Optional;

/**
 * <p>HillClimbingAlgorithm class.</p>
 *
 * @author Marko Krišković
 */
public class HillClimbingAlgorithm implements Algorithm {
    private int bestCount;
    private State bestState;
    private int count;

    public HillClimbingAlgorithm() {
        this.count = 0;
        this.bestCount = 100000;
    }

    @Override
    public State runMultiple(State initialState, int times){
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

        do{
            if(currentState.getValue()=='{') break;
            changed = false;

            List<State> neighbors = currentState.generateNeighbors();

            Optional<State> max = State.choose(neighbors);
            if(max.isPresent()){
                currentState = max.get();
                changed = true;
            }
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
