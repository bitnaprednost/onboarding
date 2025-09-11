package hr.bp.aoc.day2.game;

import java.util.Map;

public final class GamePoints {
  private static Map<GameShape, Integer> shapeScoreMapping = Map.of(
      GameShape.ROCK, 1, GameShape.PAPER, 2, GameShape.SCISSORS, 3);
  private static Map<GameOutcome, Integer> gameOutcomeScoreMapping = Map.of(
      GameOutcome.WIN, 6, GameOutcome.DRAW, 3, GameOutcome.LOSE, 0);

  public static int getShapePoints(GameShape playerShape) {
    return shapeScoreMapping.get(playerShape);
  }

  public static int getGameOutcomePoints(GameOutcome gameOutcome) {
    return gameOutcomeScoreMapping.get(gameOutcome);
  }
}
