package hr.bp.aoc.day2;

public class Pair {
  String playerShape;
  String opponentShape;

  public Pair(String playerShape, String opponentShape) {
    this.playerShape = playerShape;
    this.opponentShape = opponentShape;
  }

  @Override
  public int hashCode() {
    return playerShape.hashCode() + opponentShape.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    Pair otherPair = (Pair) obj;
    return playerShape.equals(otherPair.playerShape) && opponentShape.equals(otherPair.opponentShape);
  }
}
