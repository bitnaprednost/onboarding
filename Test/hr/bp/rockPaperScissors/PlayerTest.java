package hr.bp.rockPaperScissors;

import hr.bp.rockPaperScissors.player.Player;
import hr.bp.rockPaperScissors.player.PlayerMe;
import hr.bp.rockPaperScissors.player.PlayerOpponent;
import hr.bp.rockPaperScissors.shape.Paper;
import hr.bp.rockPaperScissors.shape.Rock;
import hr.bp.rockPaperScissors.shape.Scissors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private PlayerMe me;
    private Player opponent;


    @BeforeEach
    void init(){
        me = new PlayerMe();
        opponent = new PlayerOpponent();
    }

    @Test
    public void canIThrowRockPaperOrScissors(){
        Rock rock = me.throwRock();
        Paper paper = me.throwPaper();
        Scissors scissors = me.throwScissors();

        assertInstanceOf(Rock.class, rock);
        assertInstanceOf(Paper.class, paper);
        assertInstanceOf(Scissors.class, scissors);
    }

    @Test
    public void canOpponentThrowRockPaperOrScissors(){
        Rock rock = opponent.throwRock();
        Paper paper = opponent.throwPaper();
        Scissors scissors = opponent.throwScissors();

        assertInstanceOf(Rock.class, rock);
        assertInstanceOf(Paper.class, paper);
        assertInstanceOf(Scissors.class, scissors);
    }

}