package hr.bp.aoc.day2.reader;

import java.util.Map;

import hr.bp.aoc.day2.GameShape;

public class CharShapeDecoder {
  private static Map<Character, GameShape> strategyCharShapeMapping = Map.of(
      'A', GameShape.ROCK, 'B', GameShape.PAPER, 'C', GameShape.SCISSORS,
      'X', GameShape.ROCK, 'Y', GameShape.PAPER, 'Z', GameShape.SCISSORS);

  public static GameShape getGameShape(char inputChar) {
    return strategyCharShapeMapping.get(inputChar);
  }
}
