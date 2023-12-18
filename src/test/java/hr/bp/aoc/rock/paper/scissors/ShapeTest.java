package hr.bp.aoc.rock.paper.scissors;

import hr.bp.aoc.rock.paper.scissors.Status;
import hr.bp.aoc.rock.paper.scissors.shape.Paper;
import hr.bp.aoc.rock.paper.scissors.shape.Scissors;
import hr.bp.aoc.rock.paper.scissors.shape.ShapeWrapper;
import hr.bp.aoc.rock.paper.scissors.shape.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    private Rock rock;
    private Paper paper;
    private Scissors scissors;
    @BeforeEach
    void init(){
        rock = new Rock();
        scissors = new Scissors();
        paper = new Paper();
    }

    @Test
    public void simulateRockStatuses(){
        Status statusScissors = rock.simulateAgainst(scissors);
        Status statusPaper = rock.simulateAgainst(paper);
        Status statusRock = rock.simulateAgainst(rock);

        assertEquals(statusRock, Status.DRAW);
        assertEquals(statusPaper, Status.LOSE);
        assertEquals(statusScissors, Status.WIN);
    }

    @Test
    public void simulatePaperStatuses(){
        Status statusScissors = paper.simulateAgainst(scissors);
        Status statusPaper = paper.simulateAgainst(paper);
        Status statusRock = paper.simulateAgainst(rock);

        assertEquals(statusRock, Status.WIN);
        assertEquals(statusPaper, Status.DRAW);
        assertEquals(statusScissors, Status.LOSE);
    }

    @Test
    public void simulateScissorsStatuses(){
        Status statusScissors = scissors.simulateAgainst(scissors);
        Status statusPaper = scissors.simulateAgainst(paper);
        Status statusRock = scissors.simulateAgainst(rock);

        assertEquals(statusRock, Status.LOSE);
        assertEquals(statusPaper, Status.WIN);
        assertEquals(statusScissors, Status.DRAW);
    }

    @Test
    public void simulateRockStatusesEnum(){
        Status statusScissors = ShapeWrapper.getRock().simulateAgainst(ShapeWrapper.getScissors());
        Status statusPaper = ShapeWrapper.getRock().simulateAgainst(ShapeWrapper.getPaper());
        Status statusRock = ShapeWrapper.getRock().simulateAgainst(ShapeWrapper.getRock());

        assertEquals(statusRock, Status.DRAW);
        assertEquals(statusPaper, Status.LOSE);
        assertEquals(statusScissors, Status.WIN);
    }

    @Test
    public void simulatePaperStatusesEnum(){
        Status statusScissors = ShapeWrapper.getPaper().simulateAgainst(ShapeWrapper.getScissors());
        Status statusPaper = ShapeWrapper.getPaper().simulateAgainst(ShapeWrapper.getPaper());
        Status statusRock = ShapeWrapper.getPaper().simulateAgainst(ShapeWrapper.getRock());

        assertEquals(statusRock, Status.WIN);
        assertEquals(statusPaper, Status.DRAW);
        assertEquals(statusScissors, Status.LOSE);
    }

    @Test
    public void simulateScissorsStatusesEnum(){
        Status statusScissors = ShapeWrapper.getScissors().simulateAgainst(ShapeWrapper.getScissors());
        Status statusPaper = ShapeWrapper.getScissors().simulateAgainst(ShapeWrapper.getPaper());
        Status statusRock = ShapeWrapper.getScissors().simulateAgainst(ShapeWrapper.getRock());

        assertEquals(statusRock, Status.LOSE);
        assertEquals(statusPaper, Status.WIN);
        assertEquals(statusScissors, Status.DRAW);
    }

}