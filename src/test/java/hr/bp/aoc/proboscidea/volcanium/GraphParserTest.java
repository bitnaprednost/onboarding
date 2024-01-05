package hr.bp.aoc.proboscidea.volcanium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphParserTest {

    @Test
    void canParseTextToGraph(){
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
        String[] lines = text.split("\n");

        Valve AA = new Valve("AA", 0, new HashSet<>(List.of("DD", "II", "BB")));
        Valve BB = new Valve("BB", 13, new HashSet<>(List.of("CC", "AA")));
        Valve CC = new Valve("CC", 2, new HashSet<>(List.of("DD", "BB")));
        Valve DD = new Valve("DD", 20, new HashSet<>(List.of("CC", "AA", "EE")));
        Valve EE = new Valve("EE", 3, new HashSet<>(List.of("FF", "DD")));
        Valve FF = new Valve("FF", 0, new HashSet<>(List.of("EE", "GG")));
        Valve GG = new Valve("GG", 0, new HashSet<>(List.of("FF", "HH")));
        Valve HH = new Valve("HH", 22, new HashSet<>(List.of("GG")));
        Valve II = new Valve("II", 0, new HashSet<>(List.of("AA", "JJ")));
        Valve JJ = new Valve("JJ", 21, new HashSet<>(List.of("II")));
        Graph graph = new Graph(new HashSet<>(List.of(AA, BB, CC, DD, EE, FF, GG, HH, II, JJ)));

        Graph result = GraphParser.parseGraph(lines);

        assertEquals(graph, result);
    }
}