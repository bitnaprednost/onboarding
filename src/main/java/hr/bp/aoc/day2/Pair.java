package hr.bp.aoc.day2;

public class Pair {
  String firstShape;
  String secondShape;

  public Pair(String firstShape, String secondShape) {
    this.firstShape = firstShape;
    this.secondShape = secondShape;
  }

  @Override
  public int hashCode() {
    return firstShape.hashCode() + secondShape.hashCode();
  }

  public boolean equals(Object obj) {
    Pair otherPair = (Pair) obj;
    return firstShape.equals(otherPair.firstShape) && secondShape.equals(otherPair.secondShape);
  }
}
