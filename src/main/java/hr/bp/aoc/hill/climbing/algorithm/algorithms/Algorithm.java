package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.State;

public interface Algorithm {
    State run(State initialState);
    int getCount();
}
