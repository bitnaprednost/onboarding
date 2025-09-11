package hr.bp.aoc.day2.game;

public class GameShapePair {
  GameShape playerShape;
  GameShape opponentShape;

  public GameShapePair(GameShape playerShape, GameShape opponentShape) {
    this.playerShape = playerShape;
    this.opponentShape = opponentShape;
  }

  @Override
  public int hashCode() {
    return playerShape.hashCode() + opponentShape.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    GameShapePair otherPair = (GameShapePair) obj;
    return playerShape.equals(otherPair.playerShape) && opponentShape.equals(otherPair.opponentShape);
  }
}
