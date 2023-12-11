package hr.bp.aoc.ropebridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;

class RopeManagerTest {
    RopeManager ropeManager;

    @BeforeEach
    void setUp() {
        ropeManager = new RopeManager(2);
    }

    @Test
    void canGetRopePositions(){
        Point position = new Point(0, 0);

        assertEquals(position, ropeManager.getHead());
        assertEquals(position, ropeManager.getTail());
    }

    @Test
    void canMoveRopeRight(){
        ropeManager.moveRight(1);

        Point headPosition = new Point(1, 0);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, ropeManager.getHead());
        assertEquals(tailPosition, ropeManager.getTail());
    }

    @Test
    void canMoveRopeLeft(){
        ropeManager.moveLeft(1);

        Point headPosition = new Point(-1, 0);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, ropeManager.getHead());
        assertEquals(tailPosition, ropeManager.getTail());
    }

    @Test
    void canMoveRopeUp(){
        ropeManager.moveUp(1);

        Point headPosition = new Point(0, 1);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, ropeManager.getHead());
        assertEquals(tailPosition, ropeManager.getTail());
    }

    @Test
    void canMoveRopeDown(){
        ropeManager.moveDown(1);

        Point headPosition = new Point(0, -1);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, ropeManager.getHead());
        assertEquals(tailPosition, ropeManager.getTail());
    }

    @Test
    void canMoveRopeRightMultipleTimes(){
        ropeManager.moveRight(3);

        Point headPosition = new Point(3, 0);
        Point tailPosition = new Point(2, 0);

        assertEquals(headPosition, ropeManager.getHead());
        assertEquals(tailPosition, ropeManager.getTail());
    }

    @Test
    void cannotMoveRightZeroTimes(){
        ropeManager.moveRight(0);

        Point position = new Point(0, 0);

        assertEquals(position, ropeManager.getHead());
        assertEquals(position, ropeManager.getTail());
    }

    @Test
    void cannotMoveRightNegativeTimes(){
        ropeManager.moveRight(-3);

        Point position = new Point(0, 0);

        assertEquals(position, ropeManager.getHead());
        assertEquals(position, ropeManager.getTail());
    }

    @Test
    void canProcessCommand(){
        String command = "R 1";
        ropeManager.parse(command);

        Point headPosition = new Point(1, 0);
        Point tailPosition = new Point(0, 0);

        assertEquals(headPosition, ropeManager.getHead());
        assertEquals(tailPosition, ropeManager.getTail());
    }

    @Test
    void canProcessCommandWith2Digits(){
        String command = "R 10";
        ropeManager.parse(command);

        Point headPosition = new Point(10, 0);
        Point tailPosition = new Point(9, 0);

        assertEquals(headPosition, ropeManager.getHead());
        assertEquals(tailPosition, ropeManager.getTail());
    }

    @Test
    void cantProcessCommand(){
        String command = "B 1";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ropeManager.parse(command));
        assertEquals("Input string not in correct format.", exception.getMessage());

        String command2 = "";

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> ropeManager.parse(command2));
        assertEquals("The validated character sequence is blank", exception2.getMessage());

        String command3 = null;

        NullPointerException exception3 = assertThrows(NullPointerException.class, () -> ropeManager.parse(command3));
        assertEquals("The validated character sequence is blank", exception3.getMessage());
    }

    @Test
    void canCountTailVisitedPositions(){
        ropeManager.moveRight(4);
        int count = ropeManager.countTailTrail();

        assertEquals(4, count);

        ropeManager.moveLeft(6);
        count = ropeManager.countTailTrail();

        assertEquals(5, count);
    }
}