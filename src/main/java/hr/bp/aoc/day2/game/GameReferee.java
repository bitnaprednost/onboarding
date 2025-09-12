package hr.bp.aoc.day2.game;

import java.util.Map;

public class GameReferee {
  private static Map<GameShapePair, GameOutcome> gameOutcomeShapeMapping = Map.of(
      new GameShapePair(GameShape.ROCK, GameShape.SCISSORS), GameOutcome.WIN,
      new GameShapePair(GameShape.PAPER, GameShape.ROCK), GameOutcome.WIN,
      new GameShapePair(GameShape.SCISSORS, GameShape.PAPER), GameOutcome.WIN,
      new GameShapePair(GameShape.ROCK, GameShape.PAPER), GameOutcome.LOSE,
      new GameShapePair(GameShape.PAPER, GameShape.SCISSORS), GameOutcome.LOSE,
      new GameShapePair(GameShape.SCISSORS, GameShape.ROCK), GameOutcome.LOSE,
      new GameShapePair(GameShape.ROCK, GameShape.ROCK), GameOutcome.DRAW,
      new GameShapePair(GameShape.PAPER, GameShape.PAPER), GameOutcome.DRAW,
      new GameShapePair(GameShape.SCISSORS, GameShape.SCISSORS), GameOutcome.DRAW);

  public static GameOutcome getGameOutcome(GameShape playerGameShape,
      GameShape opponentGameShape) {
    if (playerGameShape.equals(opponentGameShape))
      return GameOutcome.DRAW;
    GameShapePair gameShapePair = new GameShapePair(playerGameShape, opponentGameShape);

    return gameOutcomeShapeMapping.get(gameShapePair);
  }

  public static GameShape getShapeForDesiredOutcome(GameOutcome desiredOutcome, GameShape opponentShape) {
    GameShape[] possibleChoices = { GameShape.ROCK, GameShape.PAPER, GameShape.SCISSORS };

    for (GameShape selectedShape : possibleChoices) {
      GameShapePair gameShapePair = new GameShapePair(selectedShape, opponentShape);

      if (desiredOutcome.equals(gameOutcomeShapeMapping.get(gameShapePair)))
        return selectedShape;
    }

    return null;
  }

}
