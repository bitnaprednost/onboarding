package hr.bp.aoc.rope.bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortRopeTest {
    private Rope rope;

    @BeforeEach
    void setUp() {
        rope = new Rope(2);
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

        Point headPosition = new Point(1, 0);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeLeft(){
        rope.moveLeft();

        Point headPosition = new Point(-1, 0);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeUp(){
        rope.moveUp();

        Point headPosition = new Point(0, 1);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeDown(){
        rope.moveDown();

        Point headPosition = new Point(0, -1);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeRightMultipleTimes(){
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();

        Point headPosition = new Point(3, 0);
        Point tailPosition = new Point(2, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeLeftMultipleTimes(){
        rope.moveLeft();
        rope.moveLeft();
        rope.moveLeft();

        Point headPosition = new Point(-3, 0);
        Point tailPosition = new Point(-2, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeOppositeSide(){
        rope.moveRight();
        rope.moveRight();
        rope.moveRight();

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

        rope.moveDown();
        rope.moveDown();
        rope.moveDown();

        Point headPosition = new Point(0, 0);
        Point tailPosition = new Point(0, 1);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeWithoutMovingTail(){
        rope.moveRight();
        rope.moveUp();

        Point headPosition = new Point(1, 1);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeTailMovesDiagonally(){
        rope.moveRight();
        rope.moveUp();
        rope.moveUp();

        Point headPosition = new Point(1, 2);
        Point tailPosition = new Point(1, 1);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }

    @Test
    void canMoveRopeTailMovesDiagonally2(){
        rope.moveRight();
        rope.moveUp();
        rope.moveRight();

        Point headPosition = new Point(2, 1);
        Point tailPosition = new Point(1, 1);

        assertEquals(headPosition, rope.getHead());
        assertEquals(tailPosition, rope.getTail());
    }
}