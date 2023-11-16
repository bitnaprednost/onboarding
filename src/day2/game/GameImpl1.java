package day2.game;

import day2.Status;
import day2.game.Game;
import day2.player.Player;
import day2.player.PlayerMe;
import day2.shape.Shape;

public class GameImpl1 extends Game {
    public GameImpl1(Player opponent, PlayerMe me) {
        super(opponent, me);
    }

    @Override
    public void simulateGame( char opponentCode, char myCode) {
        Shape opponentShape = opponent.getShapeFromChar(opponentCode);
        Shape myShape = me.getShapeFromChar(myCode);
        Status status = compareShapes(opponentShape, myShape);

        finalScore += myShape.getScore() + status.getScore();
    }
}
