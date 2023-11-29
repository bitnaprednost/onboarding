package hr.bitnaPrednost.day2.strategy;

import hr.bitnaPrednost.day2.Status;
import hr.bitnaPrednost.day2.player.Player;
import hr.bitnaPrednost.day2.player.PlayerMe;
import hr.bitnaPrednost.day2.shape.Shape;

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
