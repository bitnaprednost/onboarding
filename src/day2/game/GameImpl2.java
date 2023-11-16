package day2.game;

import day2.Status;
import day2.game.Game;
import day2.player.Player;
import day2.player.PlayerMe;
import day2.shape.Shape;

public class GameImpl2 extends Game {
    public GameImpl2(Player opponent, PlayerMe me) {
        super(opponent, me);
    }

    @Override
    public void simulateGame(char opponentCode, char myCode) {
        Shape opponentShape = opponent.getShapeFromChar(opponentCode);
        Status status = me.statusToShape(myCode);
        Shape myShape = elfStrategy(opponentShape, status);

        finalScore += myShape.getScore() + status.getScore();
    }
}
