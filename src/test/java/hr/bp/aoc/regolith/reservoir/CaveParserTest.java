package hr.bp.aoc.regolith.reservoir;

import hr.bp.aoc.regolith.reservoir.cave.Cave;
import hr.bp.aoc.regolith.reservoir.cave.CaveBuilder;
import hr.bp.aoc.regolith.reservoir.cave.CaveParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaveParserTest {
    @Test
    void canParseLine(){
        String line = "498,4 -> 498,6 -> 496,6";
        CaveBuilder builder = new CaveBuilder(true);
        CaveBuilder caveBuilder = CaveParser.parseLine(builder, line);

        assertEquals(5, caveBuilder.getRocksSize());
    }

    @Test
    void canParseLines(){
        String line1 = "498,4 -> 498,6 -> 496,6";
        String line2 = "503,4 -> 502,4 -> 502,9 -> 494,9";
        String[] lines = new String[] {line1, line2};

        String text = """
                0 ......+...
                1 ..........
                2 ..........
                3 ..........
                4 ....#...##
                5 ....#...#.
                6 ..###...#.
                7 ........#.
                8 ........#.
                9 #########.
                """;

        Cave cave = CaveParser.parseLines(lines, true);

        assertEquals(20, cave.getObsticlesSize());
        assertEquals(text, cave.toString());
    }

    @Test
    void canParseLinesWithBottom(){
        String line1 = "498,4 -> 498,6 -> 496,6";
        String line2 = "503,4 -> 502,4 -> 502,9 -> 494,9";
        String[] lines = new String[] {line1, line2};

        Cave cave = CaveParser.parseLines(lines, false);

        assertEquals(45, cave.getObsticlesSize());
    }
}