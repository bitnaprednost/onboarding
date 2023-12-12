package hr.bp.aoc.rock.paper.scissors;

import static org.junit.jupiter.api.Assertions.*;

import hr.bp.aoc.rock.paper.scissors.player.Player;
import hr.bp.aoc.rock.paper.scissors.player.PlayerMe;
import hr.bp.aoc.rock.paper.scissors.player.PlayerOpponent;
import hr.bp.aoc.rock.paper.scissors.strategy.StrategyImpl1;
import hr.bp.aoc.rock.paper.scissors.strategy.Strategy;
import hr.bp.aoc.rock.paper.scissors.strategy.StrategyImpl2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrategyTest {
    private Strategy strategy;
    private PlayerMe me;
    private Player opponent;


    @BeforeEach
    void init(){
        me = new PlayerMe();
        opponent = new PlayerOpponent();
        strategy = new StrategyImpl1(opponent, me);
    }

//    @Test
//    void canCompareGame(){
//        Status status = strategy.compareShapes(new Rock(), new Paper());
//
//        assertEquals(status, Status.WIN);
//    }

    @Test
    public void canSimulateSingleGame1(){
        strategy.simulateGame('A', 'Y');
        Integer score = strategy.getScore();

        assertEquals(score, 8);
    }

    @Test
    public void canSimulateMultipleGames1(){
        strategy.simulateGame('A', 'Y');
        strategy.simulateGame('B', 'X');
        strategy.simulateGame('C', 'Z');
        Integer score = strategy.getScore();

        assertEquals(score, 15);
    }

    @Test
    public void canSimulateSingleGame2(){
        strategy = new StrategyImpl2(opponent, me);
        strategy.simulateGame('A', 'Y');
        Integer score = strategy.getScore();

        assertEquals(score, 4);
    }

    @Test
    public void canSimulateMultipleGames2(){
        strategy = new StrategyImpl2(opponent, me);
        strategy.simulateGame('A', 'Y');
        strategy.simulateGame('B', 'X');
        strategy.simulateGame('C', 'Z');
        Integer score = strategy.getScore();

        assertEquals(score, 12);
    }

    @Test
    public void canResetScore(){
        strategy.simulateGame('A', 'Y');
        strategy.resetScore();
        Integer score = strategy.getScore();

        assertEquals(score, 0);
    }

}