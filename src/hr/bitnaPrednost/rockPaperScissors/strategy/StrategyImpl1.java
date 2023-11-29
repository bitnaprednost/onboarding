package hr.bitnaPrednost.rockPaperScissors.strategy;

import hr.bitnaPrednost.rockPaperScissors.Status;
import hr.bitnaPrednost.rockPaperScissors.player.Player;
import hr.bitnaPrednost.rockPaperScissors.player.PlayerMe;
import hr.bitnaPrednost.rockPaperScissors.shape.Shape;

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
