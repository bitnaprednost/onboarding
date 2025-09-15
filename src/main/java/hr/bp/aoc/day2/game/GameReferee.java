package hr.bp.aoc.day2.game;

import java.util.Map;

import hr.bp.aoc.utils.Pair;

public class GameReferee {
  private static Map<Pair<GameShape>, GameOutcome> gameOutcomeShapeMapping = Map.of(
      new Pair<GameShape>(GameShape.ROCK, GameShape.SCISSORS), GameOutcome.WIN,
      new Pair<GameShape>(GameShape.PAPER, GameShape.ROCK), GameOutcome.WIN,
      new Pair<GameShape>(GameShape.SCISSORS, GameShape.PAPER), GameOutcome.WIN,
      new Pair<GameShape>(GameShape.ROCK, GameShape.PAPER), GameOutcome.LOSE,
      new Pair<GameShape>(GameShape.PAPER, GameShape.SCISSORS), GameOutcome.LOSE,
      new Pair<GameShape>(GameShape.SCISSORS, GameShape.ROCK), GameOutcome.LOSE,
      new Pair<GameShape>(GameShape.ROCK, GameShape.ROCK), GameOutcome.DRAW,
      new Pair<GameShape>(GameShape.PAPER, GameShape.PAPER), GameOutcome.DRAW,
      new Pair<GameShape>(GameShape.SCISSORS, GameShape.SCISSORS), GameOutcome.DRAW);

  public static GameOutcome getGameOutcome(GameShape playerGameShape,
      GameShape opponentGameShape) {
    Pair<GameShape> gameShapePair = new Pair<>(playerGameShape, opponentGameShape);

    return gameOutcomeShapeMapping.get(gameShapePair);
  }

  public static GameShape getShapeForDesiredOutcome(GameOutcome desiredOutcome, GameShape opponentShape) {
    GameShape[] possibleChoices = { GameShape.ROCK, GameShape.PAPER, GameShape.SCISSORS };

    for (GameShape selectedShape : possibleChoices) {
      Pair<GameShape> gameShapePair = new Pair<>(selectedShape, opponentShape);

      if (desiredOutcome.equals(gameOutcomeShapeMapping.get(gameShapePair)))
        return selectedShape;
    }

    throw new IllegalStateException("No matching shape found!");
  }

}
