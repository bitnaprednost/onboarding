package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.hill.climbing.algorithm.State;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.Algorithm;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.HillClimbingAlgorithm;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.TabooSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {

    private Algorithm<State> algorithm;
    private State initialState;

    @BeforeEach
    void setUp() {
        char[][] map = new char[][]{
                {'`', 'a', 'b', 'q', 'p', 'o', 'n', 'm'},
                {'a', 'b', 'c', 'r', 'y', 'x', 'x', 'l'},
                {'a', 'c', 'c', 's', 'z', '{', 'x', 'k'},
                {'a', 'c', 'c', 't', 'u', 'v', 'w', 'j'},
                {'a', 'b', 'd', 'e', 'f', 'g', 'h', 'i'}
        };

        char[][] stringMap = new char[][]{
                {'S', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'E', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        initialState = new State(map, new Point(0, 0), new Point(5, 2), stringMap);
    }

    @Test
    void canRunHillClimbAlgorithm(){
        algorithm = new HillClimbingAlgorithm();
        State endState = algorithm.run(initialState);

        assertTrue(endState.endReached());
        //System.out.println(endState + "count: " + algorithm.getCount());
    }

    @Test
    void canRunTabooSearchAlgorithm(){
        algorithm = new TabooSearch(5);
        State endState = algorithm.run(initialState);

        assertTrue(endState.endReached());
    }

    @Test
    void canRunMultipleHillClimbAlgorithm(){
        algorithm = new HillClimbingAlgorithm();
        State endState = algorithm.runMultiple(initialState, 100);

        assertEquals(31, algorithm.getCount());
    }

    @Test
    void canRunMultipleTabooSearchAlgorithm(){
        algorithm = new TabooSearch(5);
        State endState = algorithm.runMultiple(initialState, 100);

        assertEquals(31, algorithm.getCount());
    }
}