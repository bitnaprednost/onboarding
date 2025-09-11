package hr.bp.aoc.day2.reader;

import java.util.Map;

import hr.bp.aoc.day2.GameShape;

public class CharShapeDecoder {
  private static Map<String, GameShape> strategyCharShapeMapping = Map.of(
      "A", GameShape.ROCK, "B", GameShape.PAPER, "C", GameShape.SCISSORS,
      "X", GameShape.ROCK, "Y", GameShape.PAPER, "Z", GameShape.SCISSORS);

  public static GameShape getGameShape(String inputChar) {
    return strategyCharShapeMapping.get(inputChar);
  }
}
