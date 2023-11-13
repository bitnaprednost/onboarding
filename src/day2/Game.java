package day2;

import day2.player.Player;
import day2.player.PlayerMe;
import day2.shape.Shape;

public class Game {
    private PlayerMe me;
    private Player opponent;
    private int finalScore=0;

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

    public void simulateGame(char opponentCode, char myCode) {
        Shape opponentShape = opponent.getShapeFromChar(opponentCode);
        //Shape myShape = me.getShapeFromChar(opponentCode);
        //Status status = compareShapes(opponentShape, myShape);
        Status status = me.statusToShape(myCode);
        Shape myShape = elfStrategy(opponentShape, status);

        finalScore += myShape.getScore() + status.getScore();
    }



    public int getScore() {
        return finalScore;
    }
}
