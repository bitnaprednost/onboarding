package hr.bp.aoc.rock.paper.scissors;

import hr.bp.aoc.rock.paper.scissors.player.Player;
import hr.bp.aoc.rock.paper.scissors.player.PlayerMe;
import hr.bp.aoc.rock.paper.scissors.player.PlayerOpponent;
import hr.bp.aoc.rock.paper.scissors.strategy.Strategy;
import hr.bp.aoc.rock.paper.scissors.strategy.StrategyImpl1;
import hr.bp.aoc.rock.paper.scissors.strategy.StrategyImpl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        PlayerMe me = new PlayerMe();
        Player opponent = new PlayerOpponent();

        Strategy strategy = new StrategyImpl1(opponent, me);
        GameManager gameManager = new GameManager(strategy);
        gameManager.runGames("src/main/resources/day2Data.txt");
        logger.info(String.valueOf(gameManager.getScore()));

        strategy = new StrategyImpl2(opponent, me);
        gameManager = new GameManager(strategy);
        gameManager.runGames("src/main/resources/day2Data.txt");
        logger.info(String.valueOf(gameManager.getScore()));
    }
}
