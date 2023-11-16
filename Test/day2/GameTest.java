package day2;

import static org.junit.jupiter.api.Assertions.*;

import day2.game.Game;
import day2.game.GameImpl1;
import day2.game.GameImpl2;
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
        game = new GameImpl1(opponent, me);
    }

    @Test
    void canCompareGame(){
        Status status = game.compareShapes(new Rock(), new Paper());

        assertEquals(status, Status.WIN);
    }

    @Test
    public void canSimulateSingleGame1(){
        game.simulateGame('A', 'Y');
        Integer score = game.getScore();

        assertEquals(score, 8);
    }

    @Test
    public void canSimulateMultipleGames1(){
        game.simulateGame('A', 'Y');
        game.simulateGame('B', 'X');
        game.simulateGame('C', 'Z');
        Integer score = game.getScore();

        assertEquals(score, 15);
    }

    @Test
    public void canSimulateSingleGame2(){
        game = new GameImpl2(opponent, me);
        game.simulateGame('A', 'Y');
        Integer score = game.getScore();

        assertEquals(score, 4);
    }

    @Test
    public void canSimulateMultipleGames2(){
        game = new GameImpl2(opponent, me);
        game.simulateGame('A', 'Y');
        game.simulateGame('B', 'X');
        game.simulateGame('C', 'Z');
        Integer score = game.getScore();

        assertEquals(score, 12);
    }

    @Test
    public void canResetScore(){
        game.simulateGame('A', 'Y');
        game.resetScore();
        Integer score = game.getScore();

        assertEquals(score, 0);
    }

}