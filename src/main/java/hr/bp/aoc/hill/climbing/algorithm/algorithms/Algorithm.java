package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.State;

/**
 * <p>Algorithm interface.</p>
 *
 * @author Marko Krišković
 */
public interface Algorithm {
    State run(State initialState);
    State runMultiple(State initialState, int times);
    int getCount();
}
