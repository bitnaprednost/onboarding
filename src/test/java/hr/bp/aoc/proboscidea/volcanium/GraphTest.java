package hr.bp.aoc.proboscidea.volcanium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private Valve AA;
    private Valve BB;
    private Graph graph;

    @BeforeEach
    void setUp() {
        AA = new Valve("AA", 0, new HashSet<>(List.of("DD", "II", "BB")));
        BB = new Valve("BB", 13, new HashSet<>(List.of("CC", "AA")));
        graph = new Graph(new HashSet<>(List.of(BB, AA)));
    }

    @Test
    void canFindValve(){
        String valveString = "AA";
        Optional<Valve> valve = graph.findValve(valveString);

        assertEquals(AA, valve.get());
    }

    @Test
    void cantFindValve(){
        String valveString = "CC";
        Optional<Valve> valve = graph.findValve(valveString);

        assertEquals(Optional.empty(), valve);
    }

    @Test
    void canChangeValveRate(){
        Valve BB = new Valve("BB", 13, new HashSet<>(List.of("CC", "AA")));
        graph.setToZero(BB);
        Optional<Valve> bb = graph.findValve("BB");

        assertEquals(0, bb.get().getRate());
    }

    @Test
    void canCreateCopy(){
        Graph copy = graph.copy();
        Optional<Valve> aa = copy.findValve("AA");
        Optional<Valve> bb = copy.findValve("BB");

        assertEquals(AA, aa.get());
        assertEquals(BB, bb.get());
        assertNotSame(AA, aa.get());
        assertNotSame(BB, bb.get());
    }
}