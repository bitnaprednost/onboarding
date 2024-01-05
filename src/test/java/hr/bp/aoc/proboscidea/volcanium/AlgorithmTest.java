package hr.bp.aoc.proboscidea.volcanium;

import hr.bp.aoc.proboscidea.volcanium.command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {
    private Algorithm algorithm;
    private VulcanoManager manager;

    @BeforeEach
    void setUp() {
        String text = """
                Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
                Valve BB has flow rate=13; tunnels lead to valves CC, AA
                Valve CC has flow rate=2; tunnels lead to valves DD, BB
                Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE
                Valve EE has flow rate=3; tunnels lead to valves FF, DD
                Valve FF has flow rate=0; tunnels lead to valves EE, GG
                Valve GG has flow rate=0; tunnels lead to valves FF, HH
                Valve HH has flow rate=22; tunnel leads to valve GG
                Valve II has flow rate=0; tunnels lead to valves AA, JJ
                Valve JJ has flow rate=21; tunnel leads to valve II
                """;
        Graph graph = GraphParser.parseGraph(text.split("\n"));

        manager = new VulcanoManager(graph, graph.findValve("AA").get());
        algorithm = new Algorithm(manager);
    }

    @Test
    void canFindNextBestStep(){
        Command command = algorithm.findBestStep(1);

        assertEquals("You move to valve DD.", command.toString());
        assertEquals(0, manager.getPressureReleased());
    }

    @Test
    void canFindNextBestStep2Depth(){
        Command command = algorithm.findBestStep(2);

        assertEquals("You move to valve DD.", command.toString());
        assertEquals(0, manager.getPressureReleased());
    }

    @Test
    void canFindNextBestStep3Depth(){
        Command command = algorithm.findBestStep(3);

        assertEquals("You move to valve DD.", command.toString());
        assertEquals(0, manager.getPressureReleased());
    }

    @Test
    void cantFindNextBestStep(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {Command command = algorithm.findBestStep(0);});
        assertEquals(exception.getMessage(), "Depth must be a positive integer.");
    }

    @Test
    void canMakeNext2Steps(){
        algorithm.nextStep(2);
        Command command = algorithm.findBestStep(1);

        assertEquals("You open valve DD.", command.toString());
        assertEquals(0, manager.getPressureReleased());
    }

    @Test
    void canMakeNext5Steps(){
        algorithm.nextSteps(4, 4);
        Command command = algorithm.findBestStep(3);

        assertEquals("You open valve BB.", command.toString());
        assertEquals(40, manager.getPressureReleased());
    }

    @Test
    void cantMakeNextNegativeSteps(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> algorithm.nextSteps(-4, 3));
        assertEquals(exception.getMessage(), "Number of iterations must be a positive integer.");
    }

    @Test
    void canMakeNext10Steps(){
        algorithm.nextSteps(30, 6);

        assertEquals(1651, manager.getPressureReleased());
    }
}