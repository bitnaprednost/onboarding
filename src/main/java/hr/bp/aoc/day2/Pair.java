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
}
