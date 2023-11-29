package hr.bitnaPrednost.day2;

import hr.bitnaPrednost.day2.Status;
import hr.bitnaPrednost.day2.shape.Paper;
import hr.bitnaPrednost.day2.shape.Rock;
import hr.bitnaPrednost.day2.shape.Scissors;
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

}