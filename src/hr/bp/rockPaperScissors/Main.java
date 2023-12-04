package hr.bp.rockPaperScissors;

import hr.bp.rockPaperScissors.strategy.Strategy;
import hr.bp.rockPaperScissors.strategy.StrategyImpl1;
import hr.bp.rockPaperScissors.strategy.StrategyImpl2;
import hr.bp.rockPaperScissors.player.Player;
import hr.bp.rockPaperScissors.player.PlayerMe;
import hr.bp.rockPaperScissors.player.PlayerOpponent;

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
