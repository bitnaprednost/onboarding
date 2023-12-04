package hr.bp.aoc.rockPaperScissors;

import hr.bp.aoc.rockPaperScissors.strategy.Strategy;
import hr.bp.aoc.rockPaperScissors.strategy.StrategyImpl1;
import hr.bp.aoc.rockPaperScissors.strategy.StrategyImpl2;
import hr.bp.aoc.rockPaperScissors.player.Player;
import hr.bp.aoc.rockPaperScissors.player.PlayerMe;
import hr.bp.aoc.rockPaperScissors.player.PlayerOpponent;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PlayerMe me = new PlayerMe();
        Player opponent = new PlayerOpponent();

        Strategy strategy = new StrategyImpl1(opponent, me);
        GameManager gameManager = new GameManager(strategy);
        gameManager.runGames("Resources/day2Data.txt");
        System.out.println(gameManager.getScore());

        strategy = new StrategyImpl2(opponent, me);
        gameManager = new GameManager(strategy);
        gameManager.runGames("Resources/day2Data.txt");
        System.out.println(gameManager.getScore());
    }
}
