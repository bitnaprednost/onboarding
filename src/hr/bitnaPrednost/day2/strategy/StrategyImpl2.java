package hr.bitnaPrednost.day2.strategy;

import hr.bitnaPrednost.day2.Status;
import hr.bitnaPrednost.day2.player.Player;
import hr.bitnaPrednost.day2.player.PlayerMe;
import hr.bitnaPrednost.day2.shape.Shape;

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
