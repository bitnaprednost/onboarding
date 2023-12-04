package hr.bp.aoc.rockPaperScissors.strategy;

import hr.bp.aoc.rockPaperScissors.Status;
import hr.bp.aoc.rockPaperScissors.player.Player;
import hr.bp.aoc.rockPaperScissors.player.PlayerMe;
import hr.bp.aoc.rockPaperScissors.shape.Shape;

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
