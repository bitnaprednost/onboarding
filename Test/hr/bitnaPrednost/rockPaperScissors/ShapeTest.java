package hr.bitnaPrednost.rockPaperScissors;

import hr.bitnaPrednost.rockPaperScissors.shape.Paper;
import hr.bitnaPrednost.rockPaperScissors.shape.Rock;
import hr.bitnaPrednost.rockPaperScissors.shape.Scissors;
import hr.bitnaPrednost.rockPaperScissors.shape.ShapeClass;
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
        Status statusScissors = ShapeClass.getRock().simulateAgainst(ShapeClass.getScissors());
        Status statusPaper = ShapeClass.getRock().simulateAgainst(ShapeClass.getPaper());
        Status statusRock = ShapeClass.getRock().simulateAgainst(ShapeClass.getRock());

        assertEquals(statusRock, Status.DRAW);
        assertEquals(statusPaper, Status.LOSE);
        assertEquals(statusScissors, Status.WIN);
    }

    @Test
    public void simulatePaperStatusesEnum(){
        Status statusScissors = ShapeClass.getPaper().simulateAgainst(ShapeClass.getScissors());
        Status statusPaper = ShapeClass.getPaper().simulateAgainst(ShapeClass.getPaper());
        Status statusRock = ShapeClass.getPaper().simulateAgainst(ShapeClass.getRock());

        assertEquals(statusRock, Status.WIN);
        assertEquals(statusPaper, Status.DRAW);
        assertEquals(statusScissors, Status.LOSE);
    }

    @Test
    public void simulateScissorsStatusesEnum(){
        Status statusScissors = ShapeClass.getScissors().simulateAgainst(ShapeClass.getScissors());
        Status statusPaper = ShapeClass.getScissors().simulateAgainst(ShapeClass.getPaper());
        Status statusRock = ShapeClass.getScissors().simulateAgainst(ShapeClass.getRock());

        assertEquals(statusRock, Status.LOSE);
        assertEquals(statusPaper, Status.WIN);
        assertEquals(statusScissors, Status.DRAW);
    }

}