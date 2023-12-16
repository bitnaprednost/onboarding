package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.hill.climbing.algorithm.algorithms.Algorithm;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.HillClimbingAlgorithm;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.TabooSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {

    private Algorithm algorithm;
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

        initialState = new State(map, new Point(0, 0), stringMap);
    }

    @Test
    void canRunHillClimbAlgorithm(){
        char[][] map = new char[][]{
                {'`', 'a', 'b', 'q'},
                {'a', 'b', 'c', 'r'},
                {'a', 'c', 'c', 's'},
                {'a', 'c', 'c', 't'},
                {'a', 'b', 'd', 'e'}
        };

        char[][] stringMap = new char[][]{
                {'S', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', 'E'}
        };

        initialState = new State(map, new Point(0, 0), stringMap);

        //runs infinite loop on the real task
        algorithm = new HillClimbingAlgorithm('e');
        State endState = algorithm.run(initialState);

        String result = """
                        v...
                        >v..
                        .v..
                        .>v.
                        ..>e
                        """;

        assertEquals(result, endState.toString());
        assertEquals(7, algorithm.getCount());
    }

    @Test
    void canRunTabooSearchAlgorithm(){
        algorithm = new TabooSearch(3);
        State endState = algorithm.run(initialState);

        String result = """
                        v..v<<<<
                        >v.vv<<^
                        .v.v>{^^
                        .>v>>>^^
                        ..>>>>>^
                        """;

        assertEquals(result, endState.toString());
        assertEquals(31, algorithm.getCount());
    }
}