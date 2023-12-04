package hr.bp.aoc.rockPaperScissors;

/**
 * <p>Status class.</p>
 *
 * @author Marko Krišković
 */
public enum Status {
    WIN(6), DRAW(3), LOSE(0);

    private final int score;

    Status(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
