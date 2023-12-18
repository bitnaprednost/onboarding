package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.State;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.Algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * <p>HillClimbingAlgorithm class.</p>
 *
 * @author Marko Krišković
 */
public class HillClimbingAlgorithm implements Algorithm {
    private final char endFlag;
    private int count;

    public HillClimbingAlgorithm(char endFlag) {
        this.endFlag = endFlag;
        this.count = 0;
    }

    public State run(State initialState) {
        State currentState = initialState;

        boolean changed;
        do{
            if(currentState.getValue()==endFlag) break;
            changed = false;

            List<State> neighbors = currentState.generateNeighbors();

            Optional<State> max = neighbors.stream().max(Comparator.comparing(State::getHeuristic));
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
        return count;
    }
}
