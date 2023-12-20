package hr.bp.aoc.hill.climbing.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marko Krišković
 */
class AntTest {
    private Ant initialAnt;
    private Double[][] pheromones;
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

        State initialState = new State(map, new Point(0, 0), new Point(3, 4), stringMap);
        initialAnt = new Ant(initialState);

        int dimensionY = map.length;
        int dimensionX = map[0].length;
        this.pheromones = new Double[dimensionX*dimensionY][4];

        for (int i = 0; i < dimensionY*dimensionX; i++) {
            for (int j = 0; j < 4; j++) {
                pheromones[i][j] = 0.25;
            }
        }
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

        assertEquals(stringMap, initialAnt.toString());
    }

    @Test
    void canGetAllNeighborsBeginingEdgeCase(){
        Map<Ant, Double> neighbors = initialAnt.generateNeighbors(pheromones[0]);
        Iterator<Ant> iterator = neighbors.keySet().iterator();

        String neighbor0 = """
                            >a..
                            ....
                            ....
                            ....
                            ...E
                            """;

        String neighbor1 = """
                            v...
                            a...
                            ....
                            ....
                            ...E
                            """;


        assertEquals(2, neighbors.size());
        Ant next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1));
        next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1));
    }

    @Test
    void canGetAllNeighbors(){
        State state = new State(map, new Point(1, 1), new Point(3, 4), stringMap);
        Ant ant = new Ant(state);
        Map<Ant, Double> neighbors = ant.generateNeighbors(pheromones[5]);
        Iterator<Ant> iterator = neighbors.keySet().iterator();

        String neighbor2 = """
                            Sa..
                            .^..
                            ....
                            ....
                            ...E
                            """;

        String neighbor3 = """
                            S...
                            .v..
                            .c..
                            ....
                            ...E
                            """;

        String neighbor1 = """
                            S...
                            a<..
                            ....
                            ....
                            ...E
                            """;

        String neighbor0 = """
                            S...
                            .>c.
                            ....
                            ....
                            ...E
                            """;


        assertEquals(4, neighbors.size());
        Ant next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1) || next.toString().equals(neighbor2) || next.toString().equals(neighbor3));
        next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1) || next.toString().equals(neighbor2) || next.toString().equals(neighbor3));
        next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1) || next.toString().equals(neighbor2) || next.toString().equals(neighbor3));
        next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1) || next.toString().equals(neighbor2) || next.toString().equals(neighbor3));
    }

    @Test
    void canGetAllNeighborsEndEdgeCase(){
        map[3][3] = 'd';
        map[4][3] = 'd';

        State state = new State(map, new Point(3, 4), new Point(3, 4), stringMap);
        Ant ant = new Ant(state);
        Map<Ant, Double> neighbors = ant.generateNeighbors(pheromones[19]);
        Iterator<Ant> iterator = neighbors.keySet().iterator();


        String neighbor1 = """
                            S...
                            ....
                            ....
                            ...d
                            ...^
                            """;

        String neighbor0 = """
                            S...
                            ....
                            ....
                            ....
                            ..d<
                            """;


        assertEquals(2, neighbors.size());
        Ant next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1));
        next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1));
    }

    @Test
    void cantGetNeighborsLargerThanOneLetter(){
        State state = new State(map, new Point(2, 0), new Point(3, 4), stringMap);
        Ant ant = new Ant(state);
        Map<Ant, Double> neighbors = ant.generateNeighbors(pheromones[2]);
        Iterator<Ant> iterator = neighbors.keySet().iterator();


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
        Ant next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1));
        next = iterator.next();
        assertTrue(next.toString().equals(neighbor0) || next.toString().equals(neighbor1));
    }
}