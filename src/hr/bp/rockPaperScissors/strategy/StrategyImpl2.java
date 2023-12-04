package hr.bp.rockPaperScissors.strategy;

import hr.bp.rockPaperScissors.Status;
import hr.bp.rockPaperScissors.player.Player;
import hr.bp.rockPaperScissors.player.PlayerMe;
import hr.bp.rockPaperScissors.shape.Shape;

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
