package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.State;

/**
 * <p>Algorithm interface.</p>
 *
 * @author Marko Krišković
 */
public interface Algorithm <T> {
    T run(T initialState);
    T runMultiple(T initialState, int times);
    int getCount();
}
