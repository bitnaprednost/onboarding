package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.hill.climbing.algorithm.ParserDay12;
import hr.bp.aoc.hill.climbing.algorithm.State;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ParserDay12Test {
    @Test
    void canParseText(){
        String text = """
                Sabqponm
                abcryxxl
                accszExk
                acctuvwj
                abdefghi
                """;
        State state = ParserDay12.parseStartingState(text.split("\n"));

        String map = """
                `.......
                ........
                .....E..
                ........
                ........
                """;
        assertEquals(map, state.toString());
        assertEquals('`', state.getValue());
        assertEquals(0, state.getHeuristic());
        assertEquals(new Point(0, 0), state.getCurrentPosition());
    }
}