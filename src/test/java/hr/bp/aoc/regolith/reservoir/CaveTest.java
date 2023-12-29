package hr.bp.aoc.regolith.reservoir;

import hr.bp.aoc.regolith.reservoir.cave.Cave;
import hr.bp.aoc.regolith.reservoir.cave.CaveBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    private Cave cave;

    @BeforeEach
    void setUp() {
        CaveBuilder caveBuilder = new CaveBuilder(true);
        cave = caveBuilder
                .rockRange(new Point(498,4), new Point(498,6), new Point(496,6))
                .rockRange(new Point(503,4), new Point(502,4), new Point(502,9), new Point(494,9))
                .build();
    }

    @Test
    void canDrawCave(){
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

        assertEquals(text, cave.toString());
    }

    @Test
    void canDropSand(){
        String text = """
                0 ......+...
                1 ..........
                2 ..........
                3 ..........
                4 ....#...##
                5 ....#...#.
                6 ..###...#.
                7 ........#.
                8 ......o.#.
                9 #########.
                """;

        cave.dropSand();

        assertEquals(text, cave.toString());
    }

    @Test
    void canDropSandTestMoveLeft(){
        String text = """
                0 ......+...
                1 ..........
                2 ..........
                3 ..........
                4 ....#...##
                5 ....#...#.
                6 ..###...#.
                7 ........#.
                8 .....oo.#.
                9 #########.
                """;

        cave.dropSand();
        cave.dropSand();

        assertEquals(text, cave.toString());
    }

    @Test
    void canDropSandTestMoveRight(){
        String text = """
                0 ......+...
                1 ..........
                2 ..........
                3 ..........
                4 ....#...##
                5 ....#...#.
                6 ..###...#.
                7 ........#.
                8 .....ooo#.
                9 #########.
                """;

        cave.dropSand();
        cave.dropSand();
        cave.dropSand();

        assertEquals(text, cave.toString());
    }

    @Test
    void canDropSandTestLimit(){
        String text = """
                0 ......+...
                1 ..........
                2 ......o...
                3 .....ooo..
                4 ....#ooo##
                5 ...o#ooo#.
                6 ..###ooo#.
                7 ....oooo#.
                8 .o.ooooo#.
                9 #########.
                """;

        for(int i=0;i<24;i++) cave.dropSand();

        assertEquals(text, cave.toString());
    }

    @Test
    void canCountMaxSandCapacity(){
        String text = """
                0 ......+...
                1 ..........
                2 ......o...
                3 .....ooo..
                4 ....#ooo##
                5 ...o#ooo#.
                6 ..###ooo#.
                7 ....oooo#.
                8 .o.ooooo#.
                9 #########.
                """;

        int capacity = cave.countMaxSand();

        assertEquals(24, capacity);
        assertEquals(text, cave.toString());
    }

    @Test
    void canDrawACoolPiramid(){
        CaveBuilder caveBuilder = new CaveBuilder(false);
        Cave cave = caveBuilder
                .rockRange(new Point(498,4), new Point(498,6), new Point(496,6))
                .rockRange(new Point(503,4), new Point(502,4), new Point(502,9), new Point(494,9))
                .build();

        String text = """
                0 ............o............
                1 ...........ooo...........
                2 ..........ooooo..........
                3 .........ooooooo.........
                4 ........oo#ooo##o........
                5 .......ooo#ooo#ooo.......
                6 ......oo###ooo#oooo......
                7 .....oooo.oooo#ooooo.....
                8 ....oooooooooo#oooooo....
                9 ...ooo#########ooooooo...
                10 ..ooooo.......ooooooooo..
                11 #########################
                """;

        int capacity = cave.countMaxSand();

        assertEquals(text, cave.toString());
        assertEquals(93, capacity);
    }
}