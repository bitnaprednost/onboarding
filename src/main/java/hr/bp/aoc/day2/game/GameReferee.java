package hr.bp.aoc.day2;

import java.util.Map;

public class GameReferee {
  private static Map<GameShapePair, GameOutcome> gameOutcomeShapeMapping = Map.of(
      new GameShapePair(GameShape.ROCK, GameShape.SCISSORS), GameOutcome.WIN,
      new GameShapePair(GameShape.PAPER, GameShape.ROCK), GameOutcome.WIN,
      new GameShapePair(GameShape.SCISSORS, GameShape.PAPER), GameOutcome.WIN,
      new GameShapePair(GameShape.ROCK, GameShape.PAPER), GameOutcome.LOSE,
      new GameShapePair(GameShape.PAPER, GameShape.SCISSORS), GameOutcome.LOSE,
      new GameShapePair(GameShape.SCISSORS, GameShape.ROCK), GameOutcome.LOSE);

  public static GameOutcome getGameOutcome(GameShape playerGameShape,
      GameShape opponentGameShape) {
    if (playerGameShape.equals(opponentGameShape))
      return GameOutcome.DRAW;
    GameShapePair gameShapePair = new GameShapePair(playerGameShape, opponentGameShape);

    return gameOutcomeShapeMapping.get(gameShapePair);
  }

}
