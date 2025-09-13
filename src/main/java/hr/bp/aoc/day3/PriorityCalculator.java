package hr.bp.aoc.day3;

public class PriorityCalculator {
  static int getPriority(char item) {
    if (item >= 'a' && item <= 'z') {
      return item - 'a' + 1;
    } else {
      return item - 'A' + 27;
    }
  }
}
