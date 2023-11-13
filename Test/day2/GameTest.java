package day2;

import static org.junit.jupiter.api.Assertions.*;

import day2.player.Player;
import day2.player.PlayerMe;
import day2.player.PlayerOpponent;
import day2.shape.Paper;
import day2.shape.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    private Game game;
    private PlayerMe me;
    private Player opponent;


    @BeforeEach
    void init(){
        me = new PlayerMe();
        opponent = new PlayerOpponent();
        game = new Game(opponent, me);
    }

    @Test
    void canCompareGame(){
        Status status = game.compareShapes(new Rock(), new Paper());

        assertEquals(status, Status.WIN);
    }

    @Test
    public void canSimulateSingleGame(){
        game.simulateGame('A', 'Y');
        Integer score = game.getScore();

        assertEquals(score, 4);
    }

    @Test
    public void canSimulateMultipleGames(){
        game.simulateGame('A', 'Y');
        game.simulateGame('B', 'X');
        game.simulateGame('C', 'Z');
        Integer score = game.getScore();

        assertEquals(score, 12);
    }

}