package hr.bp.aoc.rock.paper.scissors.strategy;

import hr.bp.aoc.rock.paper.scissors.Status;
import hr.bp.aoc.rock.paper.scissors.player.Player;
import hr.bp.aoc.rock.paper.scissors.player.PlayerMe;
import hr.bp.aoc.rock.paper.scissors.shape.Shape;

/**
 * <p>StrategyImpl1 class.</p>
 *
 * @author Marko Krišković
 */
public class StrategyImpl1 extends Strategy {
    public StrategyImpl1(Player opponent, PlayerMe me) {
        super(opponent, me);
    }

    @Override
    public void simulateGame(char opponentCode, char myCode) {
        Shape opponentShape = opponent.getShapeFromChar(opponentCode);
        Shape myShape = me.getShapeFromChar(myCode);
        Status status = compareShapes(opponentShape, myShape);

        finalScore += myShape.getScore() + status.getScore();
    }

    private Status compareShapes(Shape opponentShape, Shape myShape) {
        return myShape.simulateAgainst(opponentShape);
    }

}
