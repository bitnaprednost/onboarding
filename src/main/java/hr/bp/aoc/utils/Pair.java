package hr.bp.aoc.utils;

public class Pair<P> {
  private P firstPair;
  private P secondPair;

  public Pair(P firstPair, P secondPair) {
    this.firstPair = firstPair;
    this.secondPair = secondPair;
  }

  public P getFirstPair() {
    return firstPair;
  }

  public P getSecondPair() {
    return secondPair;
  }
}
