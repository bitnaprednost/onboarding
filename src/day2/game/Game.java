package day2.game;

import day2.Status;
import day2.player.Player;
import day2.player.PlayerMe;
import day2.shape.Shape;

public abstract class Game {
    protected PlayerMe me;
    protected Player opponent;
    protected int finalScore=0;

    public Game(Player opponent, PlayerMe me) {
        this.me = me;
        this.opponent = opponent;
    }

    public Status compareShapes(Shape opponentShape, Shape myShape) {
        return myShape.simulateAgainst(opponentShape);
    }

    public Shape elfStrategy(Shape opponentShape, Status status) {
        return opponentShape.elfStrategy(status);
    }

    public abstract void simulateGame(char opponentCode, char myCode);

    public int getScore() {
        return finalScore;
    }

    public void resetScore() {
        finalScore=0;
    }
}
