package hr.bp.aoc.rockPaperScissors.strategy;

import hr.bp.aoc.rockPaperScissors.player.Player;
import hr.bp.aoc.rockPaperScissors.player.PlayerMe;

public abstract class Strategy {
    protected PlayerMe me;
    protected Player opponent;
    protected int finalScore=0;

    public Strategy(Player opponent, PlayerMe me) {
        this.me = me;
        this.opponent = opponent;
    }
    public abstract void simulateGame(char opponentCode, char myCode);

    public int getScore() {
        return finalScore;
    }

    public void resetScore() {
        finalScore=0;
    }
}
