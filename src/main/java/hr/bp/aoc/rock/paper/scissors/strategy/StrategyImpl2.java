package hr.bp.aoc.rock.paper.scissors.strategy;

import hr.bp.aoc.rock.paper.scissors.Status;
import hr.bp.aoc.rock.paper.scissors.player.Player;
import hr.bp.aoc.rock.paper.scissors.player.PlayerMe;
import hr.bp.aoc.rock.paper.scissors.shape.Shape;

/**
 * <p>StrategyImpl2 class.</p>
 *
 * @author Marko Krišković
 */
public class StrategyImpl2 extends Strategy {
    public StrategyImpl2(Player opponent, PlayerMe me) {
        super(opponent, me);
    }

    @Override
    public void simulateGame(char opponentCode, char myCode) {
        Shape opponentShape = opponent.getShapeFromChar(opponentCode);
        Status status = me.statusToShape(myCode);
        Shape myShape = elfStrategy(opponentShape, status);

        finalScore += myShape.getScore() + status.getScore();
    }

    private Shape elfStrategy(Shape opponentShape, Status status) {
        return opponentShape.elfStrategy(status);
    }

}
