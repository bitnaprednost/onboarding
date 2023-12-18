package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.hill.climbing.algorithm.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    private State initialState;
    private char[][] map;
    private char[][] stringMap;

    @BeforeEach
    void setUp() {
        map = new char[][]{
                {'`', 'a', 'b', 'q'},
                {'a', 'b', 'c', 'r'},
                {'a', 'c', 'c', 's'},
                {'a', 'c', 'c', 't'},
                {'a', 'b', 'd', 'e'}
        };
        stringMap = new char[][]{
                {'S', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', 'E'}
        };

        initialState = new State(map, new Point(0, 0), new Point(3, 4), stringMap);
    }

    @Test
    void canPrintString(){
        String stringMap = """
                            `...
                            ....
                            ....
                            ....
                            ...E
                            """;

        assertEquals(stringMap, initialState.toString());
    }

    @Test
    void canGetAllNeighborsBeginingEdgeCase(){
        List<State> neighbors = initialState.generateNeighbors();

        String neighbor0 = """
                            v...
                            a...
                            ....
                            ....
                            ...E
                            """;

        String neighbor1 = """
                            >a..
                            ....
                            ....
                            ....
                            ...E
                            """;

        assertEquals(2, neighbors.size());
        assertEquals(neighbor0, neighbors.get(0).toString());
        assertEquals(neighbor1, neighbors.get(1).toString());
    }

    @Test
    void canGetAllNeighbors(){
        State state = new State(map, new Point(1, 1), new Point(3, 4), stringMap);
        List<State> neighbors = state.generateNeighbors();

        String neighbor0 = """
                            Sa..
                            .^..
                            ....
                            ....
                            ...E
                            """;

        String neighbor1 = """
                            S...
                            .v..
                            .c..
                            ....
                            ...E
                            """;

        String neighbor2 = """
                            S...
                            a<..
                            ....
                            ....
                            ...E
                            """;

        String neighbor3 = """
                            S...
                            .>c.
                            ....
                            ....
                            ...E
                            """;

        assertEquals(4, neighbors.size());
        assertEquals(neighbor0, neighbors.get(0).toString());
        assertEquals(neighbor1, neighbors.get(1).toString());
        assertEquals(neighbor2, neighbors.get(2).toString());
        assertEquals(neighbor3, neighbors.get(3).toString());
    }

    @Test
    void canGetAllNeighborsEndEdgeCase(){
        map[3][3] = 'd';
        State state = new State(map, new Point(3, 4), new Point(3, 4), stringMap);
        List<State> neighbors = state.generateNeighbors();

        String neighbor0 = """
                            S...
                            ....
                            ....
                            ...d
                            ...^
                            """;

        String neighbor1 = """
                            S...
                            ....
                            ....
                            ....
                            ..d<
                            """;

        assertEquals(2, neighbors.size());
        assertEquals(neighbor0, neighbors.get(0).toString());
        assertEquals(neighbor1, neighbors.get(1).toString());
    }

    @Test
    void cantGetNeighborsLargerThanOneLetter(){
        State state = new State(map, new Point(2, 0), new Point(3, 4), stringMap);
        List<State> neighbors = state.generateNeighbors();

        String neighbor0 = """
                            S.v.
                            ..c.
                            ....
                            ....
                            ...E
                            """;

        String neighbor1 = """
                            Sa<.
                            ....
                            ....
                            ....
                            ...E
                            """;


        assertEquals(2, neighbors.size());
        assertEquals(neighbor0, neighbors.get(0).toString());
        assertEquals(neighbor1, neighbors.get(1).toString());
    }
}