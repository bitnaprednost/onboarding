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

  @Override
  public int hashCode() {
    return firstPair.hashCode() + secondPair.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Pair<?> other))
      return false;

    return (firstPair.equals(other.getFirstPair()) && secondPair.equals(other.getSecondPair()));
  }
}
