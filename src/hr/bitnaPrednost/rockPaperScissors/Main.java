package hr.bitnaPrednost.rockPaperScissors;

import hr.bitnaPrednost.rockPaperScissors.strategy.Strategy;
import hr.bitnaPrednost.rockPaperScissors.strategy.StrategyImpl1;
import hr.bitnaPrednost.rockPaperScissors.strategy.StrategyImpl2;
import hr.bitnaPrednost.rockPaperScissors.player.Player;
import hr.bitnaPrednost.rockPaperScissors.player.PlayerMe;
import hr.bitnaPrednost.rockPaperScissors.player.PlayerOpponent;

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
