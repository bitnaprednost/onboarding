package hr.bp.aoc.regolith.reservoir;

import hr.bp.aoc.regolith.reservoir.cave.Cave;
import hr.bp.aoc.regolith.reservoir.cave.CaveBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CaveBuilderTest {

    private CaveBuilder caveBuilder;
    private Point point1;
    private Point point2;
    private Point point3;

    @BeforeEach
    void setUp() {
        caveBuilder = new CaveBuilder();
        point1 = new Point(498,4);
        point2 = new Point(498,6);
        point3 = new Point(496,6);
    }

    @Test
    void canSetRock(){
        caveBuilder.rock(point1);

        assertEquals(1, caveBuilder.getRocksSize());
    }

    @Test
    void canSetMultipleRocks(){
        caveBuilder.rock(point1);
        caveBuilder.rock(point2);
        caveBuilder.rock(point3);
        caveBuilder.rock(point3);

        assertEquals(3, caveBuilder.getRocksSize());
    }

    @Test
    void canSetRange(){
        caveBuilder.rockRange(point1, point2);

        assertEquals(3, caveBuilder.getRocksSize());
    }

    @Test
    void canSetRangeMultiple(){
        caveBuilder.rockRange(point1, point2, point3);

        assertEquals(5, caveBuilder.getRocksSize());
    }

    @Test
    void canBuildCave(){
        Cave cave = caveBuilder.rockRange(point1, point2, point3).build();

        assertEquals(5, cave.getObsticlesSize());
    }

    @Test
    void canBuildCaveWithBottom(){
        CaveBuilder caveBuilder = new CaveBuilder(false);
        Cave cave = caveBuilder
                .rockRange(point1, point2, point3)
                .rockRange(new Point(503,4), new Point(502,4), new Point(502,9), new Point(494,9))
                .build();

        assertEquals(45, cave.getObsticlesSize());
        System.out.println(cave);
    }
}