package hr.bp.aoc.ropebridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongRopeTest {
    private Rope rope;

    @BeforeEach
    void setUp() {
        rope = new Rope(6);
    }

    @Test
    void canInitializePosition(){
        Point position = new Point(0, 0);

        assertEquals(position, rope.getHead());
        assertEquals(position, rope.getTail());
    }

    @Test
    void canMoveRopeRight(){
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();

        Point headPosition = new Point(5, 0);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeLeft(){
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();

        Point headPosition = new Point(-5, 0);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeUp(){
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();

        Point headPosition = new Point(0, 5);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeDown(){
        rope.moveDown();
        rope.moveDown();
        rope.moveDown();
        rope.moveDown();
        rope.moveDown();

        Point headPosition = new Point(0, -5);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeRightMultipleTimes(){
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();

        Point headPosition = new Point(7, 0);
        Point tailPosition = new Point(2, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeLeftMultipleTimes(){
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();

        Point headPosition = new Point(-7, 0);
        Point tailPosition = new Point(-2, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeOppositeSide(){
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();

        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();

        Point headPosition = new Point(0, 0);
        Point tailPosition = new Point(1, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeOppositeSide2(){
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();

        rope.moveDown();
        rope.moveDown();
        rope.moveDown();
        rope.moveDown();
        rope.moveDown();
        rope.moveDown();

        Point headPosition = new Point(0, 0);
        Point tailPosition = new Point(0, 1);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeTailMovesDiagonally(){
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();

        Point headPosition = new Point(5, 5);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeTailMovesDiagonally2(){
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();

        Point headPosition = new Point(3, 5);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeTailMovesDiagonally3(){
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();
        rope.moveUp();

        Point headPosition = new Point(3, 6);
        Point tailPosition = new Point(3, 1);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }
}
