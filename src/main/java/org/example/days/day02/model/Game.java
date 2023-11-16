package org.example.days.day02.model;

/**
 * @author Luka Ljubić
 */
public final class Game {
    private final String playerOneInput;
    private final String playerTwoInput;

    public Game(String playerOneInput, String playerTwoInput) {
        this.playerOneInput = playerOneInput;
        this.playerTwoInput = playerTwoInput;
    }

    public String getPlayerOneInput() {
        return this.playerOneInput;
    }

    public String getPlayerTwoInput() {
        return this.playerTwoInput;
    }

    @Override
    public String toString() {
        return "Game{" +
                "playerOneInput=" + playerOneInput +
                ", playerTwoInput=" + playerTwoInput +
                '}';
    }
}
