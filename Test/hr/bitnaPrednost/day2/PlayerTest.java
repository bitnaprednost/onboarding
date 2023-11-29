package hr.bitnaPrednost.day2;

import hr.bitnaPrednost.day2.player.Player;
import hr.bitnaPrednost.day2.player.PlayerMe;
import hr.bitnaPrednost.day2.player.PlayerOpponent;
import hr.bitnaPrednost.day2.shape.Paper;
import hr.bitnaPrednost.day2.shape.Rock;
import hr.bitnaPrednost.day2.shape.Scissors;
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